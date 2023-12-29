pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/jaswantg98/user_service'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

#        stage('Test') {
#            steps {
#                sh 'mvn test'
#            }
#        }

#        stage('Deploy') {
#            steps {
#                // Add deployment steps here
#            }
#        }
    }
}
