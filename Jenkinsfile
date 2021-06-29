pipeline {
  agent any
  stages {
    stage('commit') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew wrapper'
        sh './gradlew clean executeFeatures'
      }
    }

  }
}