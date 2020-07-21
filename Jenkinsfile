pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
		sh 'echo $JAVA_HOME'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            echo 'This will always run'		
            //archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
            junit 'target/surefire-reports/**/*.xml'
	    //deleteDir() /* clean up our workspace */
        }
        success {
            echo 'I succeeeded!'
	    mail to: 'marius.vladoiu@gmail.com',
             subject: "Failed Pipeline: XXX",
             body: "Something is wrong with YYY"
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
        }
        changed {
            echo 'Things were different before...'
        }
    }
}

/*pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh '''
                    echo "Multiline shell steps works too"
					pwd
                    ls -lah
                '''
            }
        }
		stage('Deploy') {
            steps {
                sh 'echo "Deploy Hello World"'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Fail!"; //exit 1'
            }
        }
    }
    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}*/
