pipeline {
  agent any
  stages {
    stage('commit') {
      steps {
        sh './gradlew clean executeFeatures'
      }
    }

  }
}