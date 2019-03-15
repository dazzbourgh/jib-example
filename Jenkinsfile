#!/usr/bin/env groovy

pipeline {
  environment {
    PATH = "$PATH:/usr/local/bin"
    JIB_BRANCH = "${env.BRANCH_NAME}"
  }
  agent any
  stages {
    stage('Check branch') {
      when { anyOf { branch 'master'; expression { env.CHANGE_ID != null } } }
      stages {
        stage('Build') {
          steps {
            sh './gradlew jib'
          }
        }
        stage('Deploy') {
          steps {
            git url: 'https://github.com/dazzbourgh/jib-example-compose.git'
            sh "docker stack deploy --compose-file docker-compose.yml jib-example-${JIB_BRANCH}"
          }
        }
        stage('Create review environment') {
          when { expression { env.CHANGE_ID != null } }
          steps {
            script {
              pullRequest.comment("A review app is available at http://94.250.249.86/jib-example-${JIB_BRANCH}")
            }
          }
        }
      }
    }
  }
}