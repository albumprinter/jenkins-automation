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
  image="derwasp/jenkins-jnlp:dind-netcore-mono",
  remoteFSRoot=null,
  memorySoftReservation=1536,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("jenkins_java")
def jenkins_java = new ECSTaskTemplate(
  templateName="jenkins-java",
  label="jenkins-java",
  image="cloudbees/jnlp-slave-with-java-build-tools",
  remoteFSRoot=null,
  memorySoftReservation=1024,
  memoryHardReservation=0,
  cpu=1,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("netcore_serverless")
def netcore_serverless = new ECSTaskTemplate(
  templateName="netcore-serverless",
  label="netcore-serverless",
  image="derwasp/jenkins-jnlp:netcore1.0.3-sdk-rc4-004771-serverless-1.8.0",
  remoteFSRoot=null,
  memorySoftReservation=1024,
  memoryHardReservation=0,
  cpu=256,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("netcore_rc4_dind")
def netcore_rc4_dind = new ECSTaskTemplate(
  templateName="netcore-rc4-dind",
  label="netcore-rc4-dind",
  image="derwasp/jenkins-jnlp:dind-1.13.1-netcore1.1-sdk-rc4-004771-mono-4.6.2.16",
  remoteFSRoot=null,
  memorySoftReservation=1536,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("netcore10_dind_sls")
def netcore10_dind_sls = new ECSTaskTemplate(
  templateName="netcore10-dind-sls",
  label="netcore10-dind-sls",
  image="derwasp/jenkins-jnlp:dind-1.13.0-netcore1.0.3-sdk-rc4-004771-mono-4.6.2.16-serverless-1.8.0",
  remoteFSRoot=null,
  memorySoftReservation=1536,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("netcore10")
def netcore10 = new ECSTaskTemplate(
  templateName="netcore10",
  label="netcore10",
  image="derwasp/jenkins-jnlp:netcore1.0.5-sdk1.0.4-mono-4.8.0.524",
  remoteFSRoot=null,
  memorySoftReservation=2048,
  memoryHardReservation=0,
  cpu=2048,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("ecs")
def ecs = new ECSTaskTemplate(
  templateName="ecs",
  label="ecs",
  image="cloudbees/jnlp-slave-with-java-build-tools",
  remoteFSRoot=null,
  memorySoftReservation=2048,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("dotnet")
def dotnet = new ECSTaskTemplate(
  templateName="dotnet",
  label="dotnet",
  image="ivanakcheurov/jenkins-jnlp-slave-dotnet:v6",
  remoteFSRoot=null,
  memorySoftReservation=2048,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)


logger.info("ecsjava")
def ecsjava = new ECSTaskTemplate(
  templateName="ecsjava",
  label="ecsjava",
  image="apbowang/jenkinsslave:javabase",
  remoteFSRoot=null,
  memorySoftReservation=2048,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("asp_net")
def asp_net = new ECSTaskTemplate(
  templateName="asp_net",
  label="asp_net",
  image="74th/jenkins-dotnet",
  remoteFSRoot=null,
  memorySoftReservation=2048,
  memoryHardReservation=0,
  cpu=1024,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("ecsjavaweb")
def ecsjavaweb = new ECSTaskTemplate(
  templateName="ecsjavaweb",
  label="ecsjavaweb",
  image="apbowang/jenkinsslave:javawebchrome",
  remoteFSRoot=null,
  memorySoftReservation=4096,
  memoryHardReservation=0,
  cpu=2048,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("ecsjavawebff")
def ecsjavawebff = new ECSTaskTemplate(
  templateName="ecsjavawebff",
  label="ecsjavawebff",
  image="apbowang/javawebffjenkinsslave",
  remoteFSRoot=null,
  memorySoftReservation=4096,
  memoryHardReservation=0,
  cpu=2048,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("dockerbuilder")
def dockerbuilder = new ECSTaskTemplate(
  templateName="dockerbuilder",
  label="dockerbuilder",
  image="derwasp/jenkins-jnlp-dind",
  remoteFSRoot=null,
  memorySoftReservation=7000,
  memoryHardReservation=0,
  cpu=2048,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)

logger.info("alltestrun")
def alltestrun = new ECSTaskTemplate(
  templateName="alltestrun",
  label="alltestrun",
  image="apbowang/javawebjenkinsslave",
  remoteFSRoot=null,
  memorySoftReservation=7000,
  memoryHardReservation=0,
  cpu=2048,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)


logger.info("ecspython")
def ecspython = new ECSTaskTemplate(
  templateName="ecspython",
  label="ecspython",
  image="sajnikanth/docker",
  remoteFSRoot=null,
  memorySoftReservation=2048,
  memoryHardReservation=0,
  cpu=2048,
  privileged=false,
  containerUser=null,
  logDriverOptions=[],
  environments=[],
  extraHosts=[],
  mountPoints=[],
  extraHosts=[]
)


String arn= env['ECS_CLUSTER_ARN']
String jenkinsUrl= env['JENKINS_OWN_IP']

logger.info("esc ECS_CLUSTER_ARN is ${arn} and JENKINS_OWN_IP is ${jenkinsUrl}")
// You can also access the specific variable, say 'username', as show below

ecsCloud = new ECSCloud(
  name="ecs",
  templates=Arrays.asList(netcore_dind, jenkins_java, netcore_serverless, netcore_rc4_dind,
            netcore10_dind_sls, netcore10, ecs, dotnet, ecsjava, asp_net, ecsjavaweb,
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
