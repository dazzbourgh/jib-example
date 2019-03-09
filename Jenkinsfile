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
        sh 'gradle build'
      }
    }
    stage('Deploy') {
      steps {
        sh 'docker run dazzbourgh/jib-example:latest'
      }
    }
  }
}