pipeline {
    agent any

    stages {
        stage('Checking master') {
            steps {
                echo 'Checking master'
            }
        }
        stage('Testing') {
            steps {
            checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'git@github.com:nani-test/projectTestAll.git']])
            }
        }
        stage('Deploying to stage') {
            steps {
                echo 'Deploying to stage'
            }
        }
    }
}

