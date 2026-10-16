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
    }
}