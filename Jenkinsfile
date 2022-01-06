properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    stages {
        stage('Pull From Github') {
            steps {
                // echo "Pull project"
               checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'master']],
                    userRemoteConfigs: [[
                        // https://github.com/VolodymyrZavada/test-pipeline.git
                        url: 'git@github.com:VolodymyrZavada/test-pipeline.git',
                        credentialsId: ''
                    ]]
               ])
            }
        }
        stage('Compile') {
            steps {
                  echo "Compile project"
            }
        }
        stage('Build project') {
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