pipeline {
  environment {
    PATH = "$PATH:/usr/local/bin"
  }
  agent any
  stages {
    stage('Build & Deploy app') {
      when { branch 'master' || expression { env.CHANGE_ID != null } }
      stages {
        stage('Build') {
          steps {
            sh './gradlew jib'
          }
        }
        stage('Deploy') {
          steps {
            git url: 'https://github.com/dazzbourgh/jib-example-compose.git'
            sh "docker stack deploy --compose-file docker-compose.yml jib-example${env.CHANGE_ID}"
          }
        }
        stage('Update port') {
          when { branch 'master' }
          steps {
            sh 'docker service update --publish-rm 1489 jib-example_jib-example'
            sh 'docker service update --publish-add published=1489,target=1489 jib-example_jib-example'
          }
        }
        stage('Create review environment') {
          when { expression { env.CHANGE_ID != null } }
          steps {
            sh "echo '${env.CHANGE_ID}'"
            sh "echo 'this is a pull request'"
            //TODO: handle pull requests
          }
        }
      }
    }
  }
}