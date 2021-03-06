import java.util.Arrays
import java.util.logging.Logger
import jenkins.model.*
Logger logger = Logger.getLogger("ecs-cluster")

logger.info("Loading Jenkins")

instance = Jenkins.getInstance()


import com.cloudbees.jenkins.plugins.amazonecs.ECSCloud
def env = System.getenv()

import com.cloudbees.jenkins.plugins.amazonecs.ECSTaskTemplate
logger.info("netcore_dind")
def netcore_dind = new ECSTaskTemplate(
  templateName="netcore-dind",
  label="netcore-dind",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp:dind-netcore-mono",
  launchType = '',
  remoteFSRoot=null,
  memory=1536,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("jenkins_java")
def jenkins_java = new ECSTaskTemplate(
  templateName="jenkins-java",
  label="jenkins-java",
  taskDefinitionOverride = null,
  image="cloudbees/jnlp-slave-with-java-build-tools",
  launchType = '',
  remoteFSRoot=null,
  memory=1024,
  memoryReservation=0,
  cpu=1,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("netcore_serverless")
def netcore_serverless = new ECSTaskTemplate(
  templateName="netcore-serverless",
  label="netcore-serverless",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp:netcore1.0.3-sdk-rc4-004771-serverless-1.8.0",
  launchType = '',
  remoteFSRoot=null,
  memory=1024,
  memoryReservation=0,
  cpu=256,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("netcore_rc4_dind")
def netcore_rc4_dind = new ECSTaskTemplate(
  templateName="netcore-rc4-dind",
  label="netcore-rc4-dind",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp:dind-1.13.1-netcore1.1-sdk-rc4-004771-mono-4.6.2.16",
  launchType = '',
  remoteFSRoot=null,
  memory=1536,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("netcore10_dind_sls")
def netcore10_dind_sls = new ECSTaskTemplate(
  templateName="netcore10-dind-sls",
  label="netcore10-dind-sls",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp:dind-1.13.0-netcore1.0.3-sdk-rc4-004771-mono-4.6.2.16-serverless-1.8.0",
  launchType = '',
  remoteFSRoot=null,
  memory=1536,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("netcore10")
def netcore10 = new ECSTaskTemplate(
  templateName="netcore10",
  label="netcore10",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp:netcore1.0.5-sdk1.0.4-mono-4.8.0.524",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("netcore20")
def netcore20 = new ECSTaskTemplate(
  templateName="netcore20",
  label="netcore20",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp:netcore2.0.5-sdk2.1.101-mono-4.8.0.524",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("ecs")
def ecs = new ECSTaskTemplate(
  templateName="ecs",
  label="ecs",
  taskDefinitionOverride = null,
  image="cloudbees/jnlp-slave-with-java-build-tools",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("dotnet")
def dotnet = new ECSTaskTemplate(
  templateName="dotnet",
  label="dotnet",
  taskDefinitionOverride = null,
  image="ivanakcheurov/jenkins-jnlp-slave-dotnet:v6",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])


logger.info("ecsjava")
def ecsjava = new ECSTaskTemplate(
  templateName="ecsjava",
  label="ecsjava",
  taskDefinitionOverride = null,
  image="apbowang/jenkinsslave:javabase",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("asp_net")
def asp_net = new ECSTaskTemplate(
  templateName="asp_net",
  label="asp_net",
  taskDefinitionOverride = null,
  image="74th/jenkins-dotnet",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=1024,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("ecsjavaweb")
def ecsjavaweb = new ECSTaskTemplate(
  templateName="ecsjavaweb",
  label="ecsjavaweb",
  taskDefinitionOverride = null,
  image="apbowang/jenkinsslave:javawebchrome",
  launchType = '',
  remoteFSRoot=null,
  memory=4096,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("ecsjavawebff")
def ecsjavawebff = new ECSTaskTemplate(
  templateName="ecsjavawebff",
  label="ecsjavawebff",
  taskDefinitionOverride = null,
  image="apbowang/javawebffjenkinsslave",
  launchType = '',
  remoteFSRoot=null,
  memory=4096,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("dockerbuilder")
def dockerbuilder = new ECSTaskTemplate(
  templateName="dockerbuilder",
  label="dockerbuilder",
  taskDefinitionOverride = null,
  image="derwasp/jenkins-jnlp-dind",
  launchType = '',
  remoteFSRoot=null,
  memory=7000,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])

logger.info("alltestrun")
def alltestrun = new ECSTaskTemplate(
  templateName="alltestrun",
  label="alltestrun",
  taskDefinitionOverride = null,
  image="apbowang/javawebjenkinsslave",
  launchType = '',
  remoteFSRoot=null,
  memory=7000,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])


logger.info("ecspython")
def ecspython = new ECSTaskTemplate(
  templateName="ecspython",
  label="ecspython",
  taskDefinitionOverride = null,
  image="sajnikanth/docker",
  launchType = '',
  remoteFSRoot=null,
  memory=2048,
  memoryReservation=0,
  cpu=2048,
  subnets = null,
  securityGroups = null,
  assignPublicIp = false,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  portMappings=[])


String arn= env['ECS_CLUSTER_ARN']
String jenkinsUrl= env['JENKINS_OWN_IP']

logger.info("esc ECS_CLUSTER_ARN is ${arn} and JENKINS_OWN_IP is ${jenkinsUrl}")
// You can also access the specific variable, say 'username', as show below

ecsCloud = new ECSCloud(
  name="ecs",
  templates=Arrays.asList(netcore_dind, jenkins_java, netcore_serverless, netcore_rc4_dind,
            netcore10_dind_sls, netcore10, netcore20, ecs, dotnet, ecsjava, asp_net, ecsjavaweb,
             ecsjavawebff, dockerbuilder, alltestrun, ecspython),
  credentialsId=null,
  cluster=arn,
  regionName="eu-west-1",
  jenkinsUrl="http://" + jenkinsUrl + ":8080",
  slaveTimoutInSeconds=60
)

instance.clouds.each{cl -> logger.info(cl.name)}
def clouds = instance.clouds
logger.info("adding provisioned cloud")
clouds.add(ecsCloud)
logger.info("Saving jenkins")
instance.save()
instance.clouds.each{cl -> logger.info(cl.name)}
