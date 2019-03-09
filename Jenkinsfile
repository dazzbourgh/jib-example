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
        sh 'docker stop jib-example || true'
        sh 'docker rm jib-example || true'
        sh 'docker run -d --name jib-example -p 1489:8080 dazzbourgh/jib-example:latest'
      }
    }
  }
}