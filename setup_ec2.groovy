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

def windowsAmiType = new WindowsData("FooBar@123", false, "180")

def windowsTemplate = new SlaveTemplate(
  ami = "ami-c4e444bd",
  zone = "eu-west-1b",
  spotConfig = null,
  securityGroups = "Jenkins",
  remoteFS = "C:\\Jenkins",
  type = InstanceType.M1Large,
  ebsOptimized = false,
  labelString = "windows",
  mode = Node.Mode.NORMAL,
  description = "Windows .net slave",
  initScript = "",
  tmpDir = "",
  userData = "",
  numExecutors = "1",
  remoteAdmin = "vagrant",
  amiType = windowsAmiType,
  jvmopts = "",
  stopOnTerminate = false,
  subnetId = "subnet-d83942bc",
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
  region = "eu-west-1",
  privateKey = """-----BEGIN RSA PRIVATE KEY-----
MIIEowIBAAKCAQEAuuodlJaHw7f+80Rua4bWf5s3LTaTf+a/LA7UzsOwIwm7PVgm1RtsFsWZVCsA
MT46QU6hv11ery2bJY1iR8qF6LQptXjk6JO1WVhrzpeiNRdMcXkHG4q/lWdhkz2rNMayMbhhXpTr
kloyknSlVfd2JdlsMLnHR3g6CYO53YMTm2y21tenijBkLW81D2vmA+Jt9VrsqhxCK8IkHQOu/9mf
VOA1GbONQ68Z0kFUs8wLBwV8pAwATm2JQoCn5ASCGX+WTSxGgTtqARWwLPWf7lQHBMk1wD/guX2b
zvOTE8V4K0JqJGDGSX/Hl/z+GWGG/fMER9HLooM1JQkERz/doInQHwIDAQABAoIBAFX1MpNRwq/c
XxAK6WjjwqM+g1p0ndKVEFe3nmBUGB2U7Rnh/0HD8aprRv8xI06CGpJMEhCKZO/U3mOfqJHxbjG9
IO1G4qaevyiOhE2m6D7YLxyEFyOwZDjWKUZoduK3ed1puMWhYNCWUGmP4TUur5PqcFncJewVO0OC
46geDpdL1x7muP2YgIDwmdYiYin42G3CHZz86OQjm4Jg2qeXP1Z5zjm64wNIEjD25wilxmpZB/aC
2sUgX5dTT5wDWQNfcqhf0ODA2yvS/Z1rjS+n1NacVxbUInyZemYSIDvfES2lbBqjkA4EXtK1cRIB
sde3IuKZiB4BcQwocS7lX8INh/ECgYEA6EVLC3cTyZDEZ7cSiKy4MxXEO8mWo2Lpm1R7RqnHp/2I
vhQAPDTvl5v0Yu7RpK8JQzavaLMJn3+59nWEGyEFreyJG+G+CQN1Dnfxavg+Fj6Y8AbNIGpChVMm
Ae5+q4BTnv2SYLXdkObaBdpNiiA+MZ8hN9sEsTjmBlPcjs5FuRcCgYEAzgKY0QGk2LUr4xMwclN6
fqIaxxIoBIQ6LPJR88/iFhMiQLCzRJHtqTDQCl0DcgE/2/aeD7hybFmNt06FqOc6wTaYvgOgpYGA
63/RNl6YcBQCRYK4OrFnjcbgdqclnPNzA1AxFRmN+U4nblE/qkI1D1M+y1nOhQev3sZj/YfFdjkC
gYAtD1RRsxYpomYX4NI9pZROhMh++Mq6g7PiKG+J8+IB2xOuHF83TuW0OdMdZktRcYuQeIlq/GC/
ip3fDElGog9iAGNQ/2hIg10wI2C4adRRqG8vEYK16SdiihDzivsT9l9CltrQ3DdRpxdgz0r/ouWt
5rshBOJSJ0GotJgzNB0enQKBgGpV5NNdad2CBpk7OnKIrF3ZBsFimc1bAzxYB/01fJmwXqnNi3sF
aAtA6uGuiSy7gF7luUicCFPtFb1chplcYXOB3u2VqcJESmtEmpTZ1w1jBpkilD2XfMAtu4cDV+Lf
tqorJmqhuirJMIk83wPfEMxMR8lnHbaE9T6kYNBo2H/hAoGBAIWkF1x1dVeu8DFMWPyWH4ADSwhw
uuhdQsQs3fuh4l1+1KDrvkCSi+Z87lU40Ftz7gOvguvh7eh3FTcWRiVE1oFEVAyiNf72QR+Kikfx
fijN7MqcVEUonBBXkTCrBWlvyczUPjpwPmmaEkdQXyxtZ3I+bBXiecGHvNkVxvBKop4t
-----END RSA PRIVATE KEY-----""",
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
