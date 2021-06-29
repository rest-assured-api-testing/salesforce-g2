pipeline {
  agent any
  stages {
    stage('commit') {
      steps {
        bat './gradlew cucumberCli'
      }
    }

  }
}
