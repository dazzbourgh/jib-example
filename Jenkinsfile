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
        sh 'docker stop jib-example || docker rm jib-example || true'
        sh 'docker run -d -p 1489:8080 --name jib-example dazzbourgh/jib-example:latest'
      }
    }
  }
}