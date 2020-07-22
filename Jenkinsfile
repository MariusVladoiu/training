pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                /* `make check` returns non-zero on test failures,
                * using `true` to allow the Pipeline to continue nonetheless
                */
		sh 'mvn test'
                junit '**/target/surefire-reports/*.xml' 
            }
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
