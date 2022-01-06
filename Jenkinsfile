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
                // sh "pid=\$(lsof -i:9008 -t); kill -TERM \$pid || kill -KILL \$pid"
                echo 'Empty for now'
            }
        }
        stage('Deploy') {
            steps {
                // echo "Deploy project"
                // sh 'nohup ./mvnw spring-boot:run &'
                // BUILD_ID=dontKillMe
                //  >> /opt/DEPLOYMENT/logs/test-pipeline.log
                //  sh 'nohup java -jar target/test-pipeline.jar &'
                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=9008 &'
                }
            }
        }
    }

/*     post {
        always {
            deleteDir()
        }
    } */

    /*
    sh "pid=\$(lsof -i:8989 -t); kill -TERM \$pid "
                      + "|| kill -KILL \$pid"
                    withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                        sh 'nohup ./mvnw spring-boot:run -Dserver.port=8989 &'
                    }
    */
}