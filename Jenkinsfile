pipeline {
  agent any
  stages {
    stage('commit') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew clean executeFeatures'
      }
      post {
        always {
           archiveArtifacts artifacts: 'build/cucumber/'
        }
      }
    }

  }
}