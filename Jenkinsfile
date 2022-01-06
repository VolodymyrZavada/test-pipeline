properties([pipelineTriggers([githubPush()])])

pipeline {
    agent any

    environment {
        APP_PORT= 9008
    }

    stages {
        stage('Pull From Github') {
            steps {
               checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'master']],
                    userRemoteConfigs: [[
                        url: 'https://github.com/VolodymyrZavada/test-pipeline.git',
                        credentialsId: ''
                    ]]
               ])
            }
        }
        stage('Compile') {
            steps {
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
                sh './mvnw package'
            }
        }
        stage('Kill process on port') {
            steps {
                script {
                    sh '''#!/bin/bash
                          pids=$(lsof -ti tcp:${APP_PORT})
                          if test "$pids"; then
                            kill -9 "$pids"
                          else
                            echo "No process on port to kill"
                          fi
                       '''
                }
            }
        }
        stage('Deploy') {
            steps {
                withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                    sh 'nohup ./mvnw spring-boot:run -Dserver.port=${APP_PORT} &'
                }
            }
        }
    }
    post {
        always {
            echo "Post called"

            /*
                === DELETE PREVIOUS BUILDS ===
                def jobName = "test-pipeline"
                def job = Jenkins.instance.getItem(jobName)
                job.getBuilds().each { if(it.number >= 1 && it.number <= 33) it.delete() }
                job.save()
            */
        }
    }
}