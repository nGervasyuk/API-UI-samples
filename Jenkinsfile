node {

      stage("checkout repo") {
            git branch 'master'
            credentialsId: '93fa56cc-8cc7-41da-9a17-23145640964c'
            url: 'https://github.com/nGervasyuk/lessons.git'
      }

      stage("build") {
            sh "./gradlew clean api-tests:assemble"
      }

      stage("run api tests") {
            sh "./gradlew api-tests:test"
      }

      post {
        allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/allure-results']]
         ])
       }
}
