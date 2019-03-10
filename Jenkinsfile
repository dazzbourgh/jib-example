pipeline {
  environment {
    PATH = "$PATH:/usr/local/bin"
  }
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew jib'
      }
    }
    stage('Deploy') {
      steps {
        git url: 'https://github.com/dazzbourgh/jib-example-compose.git'
        sh 'docker-compose up -d'
      }
    }
  }
}