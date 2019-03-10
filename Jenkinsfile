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
        sh 'docker stack deploy --compose-file docker-compose.yml jib-example'
        sh 'docker service update --publish-add published=1489,target=1489 jib-example_jib-example'
      }
    }
  }
}