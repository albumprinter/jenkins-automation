#!/bin/bash -ex
wget --quiet http://127.0.0.1:8080/jnlpJars/jenkins-cli.jar
sh ./call_jenkins_groovy.sh jenkins_git.groovy
sh ./call_jenkins_groovy.sh setup_clean_clusters.groovy
sh ./call_jenkins_groovy.sh setup_ecs.groovy
sh ./call_jenkins_groovy.sh setup_ec2.groovy
echo 'DONE configuring plugins'
