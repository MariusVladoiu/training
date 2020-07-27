pipeline {
  agent any
  stages {
    stage('Package') {
      steps {
        sh 'mvn clean package'
        echo 'Package finished'
      }
    }

    stage('Deploy') {
      steps {
        sh 'mvn tomcat7:deploy'
        echo 'Deploy Finished'
      }
    }

  }
}