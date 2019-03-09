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
        sh 'docker stop jib-example'
        sh 'docker run -d -p 1489:1489 --name jib-example dazzbourgh/jib-example:latest'
      }
    }
  }
}