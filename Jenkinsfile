pipeline {
  agent {
    docker {
      image 'gradle:jdk8'
      args '-v /home/dazzbourgh/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'gradle build'
      }
    }
  }
}