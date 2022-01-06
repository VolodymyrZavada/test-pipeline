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
        stage('Checkstyle') {
            steps {
                sh './mvnw checkstyle:checkstyle'
            }
        }
        stage('Build project') {
            steps {
                // echo "Build project"
                sh './mvnw package'
            }
        }
        stage('Kill process on port') {
            steps {
                sh 'pid=\$(lsof -i:9008 -t); kill -TERM \$pid || kill -KILL \$pid'
            }
        }
        stage('Deploy') {
            steps {
                // echo "Deploy project"
                sh 'nohup ./mvnw spring-boot:run &'
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}