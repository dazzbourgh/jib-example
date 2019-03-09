pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew jib'
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker run -d dazzbourgh/jib-example:latest'
      }
    }
  }
}