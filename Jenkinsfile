pipeline {
    agent any
    
    tools {
        maven 'Maven-3.8.5'
        jdk 'JDK-11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/tu-usuario/proyecto-automatizacion.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/site/surefire-report.html',
                        reportFiles: 'index.html',
                        reportName: 'Reporte de Tests Unitarios'
                    ])
                }
            }
        }
    }
    
    post {
        always {
            emailext (
                subject: "Build ${currentBuild.result}: Job ${env.JOB_NAME}",
                body: "Estado del build: ${currentBuild.result}\nURL: ${env.BUILD_URL}",
                to: "equipo@empresa.com"
            )
        }
        failure {
            slackSend(
                channel: '#ci-alerts',
                message: "Build FAILED: ${env.JOB_NAME} - ${env.BUILD_URL}"
            )
        }
    }
}