pipeline {
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
        stage('Deploy') {
            steps {
                sh 'echo "Deploy Hello World"'
            }
        }
    }
}