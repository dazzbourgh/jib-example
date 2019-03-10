pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew jib'
      }
    }
    stage('Deploy') {
      git url: 'https://github.com/dazzbourgh/jib-example-compose.git'
      steps {
        sh 'docker-compose up -d'
      }
    }
  }
}