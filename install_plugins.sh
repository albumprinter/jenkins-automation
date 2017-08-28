#!/bin/bash -ex
wget -N --quiet http://127.0.0.1:8080/jnlpJars/jenkins-cli.jar
pass=`sudo cat  /root/.jenkins/secrets/initialAdminPassword`
sh ./call_jenkins_groovy.sh create_user.groovy
sh ./call_jenkins_command.sh 'install-plugin git'
sh ./call_jenkins_command.sh 'install-plugin xunit'
sh ./call_jenkins_command.sh 'install-plugin amazon-ecs'
sh ./call_jenkins_command.sh 'restart'