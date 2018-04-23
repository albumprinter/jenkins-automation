#!/bin/bash -ex
wget -N --quiet http://127.0.0.1:8080/jnlpJars/jenkins-cli.jar
pass=`sh ./get_jenkins_pass.sh`
sh ./call_jenkins_groovy.sh create_user.groovy
sh ./call_jenkins_groovy.sh setup_jnlp_port.groovy
sh ./call_jenkins_command.sh 'install-plugin git'
sh ./call_jenkins_command.sh 'install-plugin xunit'
sh ./call_jenkins_command.sh 'install-plugin amazon-ecs'
sh ./call_jenkins_command.sh 'install-plugin aws-codepipeline'
sh ./call_jenkins_command.sh 'install-plugin slack'
sh ./call_jenkins_command.sh 'install-plugin cucumber-slack-notifier'
sh ./call_jenkins_command.sh 'install-plugin sonar'
sh ./call_jenkins_command.sh 'install-plugin ec2'
sh ./call_jenkins_command.sh 'restart'