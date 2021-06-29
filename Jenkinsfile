pipeline {
  agent any
  stages {
    stage('commit') {
      steps {
        sh 'chmod +x gradlew'
        sh 'gradle wrapper'
        sh './gradlew clean executeFeatures'
      }
    }

  }
}