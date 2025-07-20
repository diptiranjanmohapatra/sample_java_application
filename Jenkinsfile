pipeline {
  agent {
    docker {
      image 'maven:3.9.6-eclipse-temurin-17'
      args '-v $HOME/.m2:/root/.m2 -v /var/run/docker.sock:/var/run/docker.sock'
    }
  }
  stages {
    stage('Clone') {
      steps { git url: 'https://your-repo.git', branch: 'main' }
    }
    stage('Build Package') {
      steps { sh 'mvn clean package -DskipTests' }
    }
    stage('Docker Build with Jib') {
      steps { sh 'mvn jib:dockerBuild' }
    }
    stage('Run Container') {
      steps {
        sh '''
          docker run -d --name demo-app -p 8080:8080 springboot-jib-complex:latest
          sleep 5
          curl http://localhost:8080/api/products || true
        '''
      }
    }
  }
}