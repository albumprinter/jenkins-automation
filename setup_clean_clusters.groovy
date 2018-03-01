import java.util.Arrays
import java.util.logging.Logger
import jenkins.model.*

Logger logger = Logger.getLogger("setup-clear-cluster")

logger.info("Loading Jenkins")

instance = Jenkins.getInstance()
def env = System.getenv()

instance.clouds.each{cl -> logger.info(cl.name)}
def clouds = instance.clouds

logger.info("killing all existing clouds")
clouds.removeAll{1 == 1 }
instance.save()

logger.info("Saving jenkins")
instance.save()
instance.clouds.each{cl -> logger.info(cl.name)}
