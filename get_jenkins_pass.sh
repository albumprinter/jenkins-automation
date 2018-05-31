#!/bin/bash -ex

JENKINS_HOME=${JENKINS_HOME:/jenkins}
if [ ! -f $JENKINS_HOME/secrets/provisionerPassword ]; then
    # echo "provisioner password not found!"
    pass=`sudo cat $JENKINS_HOME/secrets/initialAdminPassword`
    openssl rand -base64 32 > $JENKINS_HOME/secrets/provisionerPassword
    provisionPass=`sudo cat $JENKINS_HOME/secrets/provisionerPassword`
    echo 'jenkins.model.Jenkins.instance.securityRealm.createAccount("provisioner","'$provisionPass'")' | java -jar jenkins-cli.jar -auth admin:$pass -s http://localhost:8080/ groovy =
    #echo $pass
    #echo $provisionPass
fi

provisionPass=`sudo cat $JENKINS_HOME/secrets/provisionerPassword`
echo $provisionPass
