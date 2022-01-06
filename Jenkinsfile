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
                        url: 'https://github.com/VolodymyrZavada/test-pipeline.git',
                        credentialsId: ''
                    ]]
               ])
            }
        }
        stage('Compile') {
            steps {
                  // echo "Compile project"
                  sh './mvnw clean install -DskipTests'
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

    post {
        always {
            deleteDir()
        }
    }
}