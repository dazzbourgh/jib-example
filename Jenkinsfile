pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew jib'
      }
    }
    stage('Deploy') {
      withEnv(["PATH=$PATH:/usr/local/bin"]) {
        steps {
          git url: 'https://github.com/dazzbourgh/jib-example-compose.git'
          sh 'docker-compose up -d'
        }
      }
    }
  }
}