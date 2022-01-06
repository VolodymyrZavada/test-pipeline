properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Pull From Github') {
            steps {
                echo "Pull project"
            }
        }
        stage('Compile') {
            steps {
                  echo "Compile project"
            }
        }
        stage('Build') {
                    steps {
                          echo "Build project"
                    }
                }
         stage('Deploy') {
                    steps {
                          echo "Deploy project"
                    }
                }
    }
}