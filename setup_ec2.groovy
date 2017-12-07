import java.util.Arrays
import java.util.logging.Logger
import jenkins.model.*

import com.amazonaws.services.ec2.model.InstanceType;
import hudson.plugins.ec2.AmazonEC2Cloud;
import hudson.plugins.ec2.SlaveTemplate;
import hudson.plugins.ec2.WindowsData;
import hudson.model.Node

Logger logger = Logger.getLogger("ec2-cluster")
logger.info("Getting the Jenkins instance..")

instance = Jenkins.getInstance()
def env = System.getenv()

def windowsClusterAmi = env['JENKINS_EC2_AMI']
def windowsBoxUserName = env['JENKINS_EC2_WIN_USER']
def windowsBoxPassword = env['JENKINS_EC2_WIN_PASSWORD']
def ec2ClusterRegion = env['JENKINS_EC2_REGION']
def ec2ClusterZone = env['JENKINS_EC2_ZONE']
def ec2ClusterSubnetId = env['JENKINS_EC2_SUBNET']
def ec2ClusterPrivateKey = env['JENKINS_EC2_ZONE']

def windowsAmiType = new WindowsData(windowsBoxPassword, false, "180")

def windowsTemplate = new SlaveTemplate(
  ami = windowsClusterAmi,
  zone = ec2ClusterZone,
  spotConfig = null,
  securityGroups = "Jenkins",
  remoteFS = "C:\\Jenkins",
  type = InstanceType.M1Large,
  ebsOptimized = false,
  labelString = "windows",
  mode = Node.Mode.NORMAL,
  description = "Jenkins slave",
  initScript = "",
  tmpDir = "",
  userData = "",
  numExecutors = "1",
  remoteAdmin = windowsBoxUserName,
  amiType = windowsAmiType,
  jvmopts = "",
  stopOnTerminate = false,
  subnetId = ec2ClusterSubnetId,
  tags = [],
  idleTerminationMinutes = "30",
  usePrivateDnsName = false,
  instanceCapStr ="",
  iamInstanceProfile ="",
  useEphemeralDevices = false,
  useDedicatedTenancy = false,
  launchTimeoutStr = "180",
  associatePublicIp = false,
  customDeviceMapping = ""
)

ecsCloud = new AmazonEC2Cloud(
  cloudName="windows",
  useInstanceProfileForCredentials = false,
  credentialsId = null,
  region = ec2ClusterRegion,
  privateKey = ec2ClusterPrivateKey,
instanceCapStr = "",
templates = Arrays.asList(windowsTemplate)  
)

instance.clouds.each{cl -> logger.info(cl.name)}
def clouds = instance.clouds
logger.info("adding provisioned cloud")
clouds.add(ecsCloud)
logger.info("Saving jenkins")
instance.save()
instance.clouds.each{cl -> logger.info(cl.name)}
