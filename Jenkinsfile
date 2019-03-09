pipeline {
  agent none
  stages {
    stage('Build') {
      agent {
        docker {
          image 'gradle:jdk8'
          args '-v /home/dazzbourgh/.m2:/root/.m2'
        }
      }
      steps {
        sh 'gradle jib'
      }
    }
    stage('Deploy') {
      agent any
      steps {
        sh 'docker run -d dazzbourgh/jib-example:latest'
      }
    }
  }
}