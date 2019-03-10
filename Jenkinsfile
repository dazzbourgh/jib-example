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
        def environmentName = (env.CHANGE_ID) ? "-${env.CHANGE_ID}" : ''
        sh "docker stack deploy --compose-file docker-compose.yml jib-example${environmentName}"
        if (!environmentName.empty) {
          //TODO: handle pull requests
        } else {
          sh 'docker service update --publish-rm 1489 jib-example_jib-example'
          sh 'docker service update --publish-add published=1489,target=1489 jib-example_jib-example'
        }
      }
    }
  }
}