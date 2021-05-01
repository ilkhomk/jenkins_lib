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
          stage("Terraform Plan"){
        timestamps {
          ws {
            sh "terraform version"
        }
      }
    }
          stage("Terraform Aply"){
        timestamps {
          ws {
            sh "terraform version"
        }
      }
    }
  }
}