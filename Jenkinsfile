
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    options {
        skipStagesAfterUnstable()
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn -B clean compile'
            }
        }

        stage('Testes JUnit') {
            steps {
                bat 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn -B jacoco:report'
                archiveArtifacts artifacts: 'target/site/jacoco/**', fingerprint: true
            }
        }
    }
}
