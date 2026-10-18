
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
        stage('Package') {
            steps {
                bat 'mvn -B package -DskipTests'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
        stage('Deploy') {
            steps {
                bat '''
                    if not exist "%JENKINS_HOME%\\deploy\\MovieGuesser" (
                        mkdir "%JENKINS_HOME%\\deploy\\MovieGuesser"
                    )

                    copy /Y "target\\MovieGuesser-1.0-SNAPSHOT.jar" "%JENKINS_HOME%\\deploy\\MovieGuesser\\MovieGuesser.jar"
                    if errorlevel 1 exit /b 1

                    java -cp "%JENKINS_HOME%\\deploy\\MovieGuesser\\MovieGuesser.jar" org.example.Main
                    if errorlevel 1 exit /b 1
                '''
            }
        }
    }
}
