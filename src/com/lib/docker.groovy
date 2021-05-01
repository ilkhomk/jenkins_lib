  
def deploy(){
    node {
          stage("Checkout SCM"){
        timestamps {
          ws {
            echo "Slack"
          checkout([$class: 'GitSCM', branches: [[name: 'master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/farrukh90/terraform_march_2021']]])
        }
      }
    }
          stage("Docker Build"){
        timestamps {
          ws {
            sh "docker build -t "${BRANCH}"
        }
      }
    }
          stage("Docker push "){
        timestamps {
          ws {
            sh "terraform version"
        }
      }
    }
  }
}