pipeline {
    agent any

    environment {
        DOCKER_IMAGE_NAME = 'calculatormp'
        GITHUB_REPO_URL = 'https://github.com/rishithaiiitb/CalculatorSPE.git'
    }

    stages {
        stage('Github Checkout') {
            steps {
                script {
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build Maven Jar'){
            steps{
                    sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Images') {
            steps {
                script{
                    docker.withRegistry('', 'DockerHubCred') {
                    sh 'docker tag calculatormp rishithaiiitb/calculatormp:latest'
                    sh 'docker push rishithaiiitb/calculatormp'
                    }
                 }
            }
        }

       stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                     )
                }
            }
        }

    }

    post {
        always {
            emailext(
                subject: "Pipeline Status: ${currentBuild.result}",
                body: "Build Status: ${currentBuild.result}\n\nCheck the Jenkins console for details.",
                to: "rishichinnu27@gmail.com",
                from: "smtp.gmail.com",
            )
        }
        

    }
}

