plugins {
    id("com.gradle.enterprise") version "3.12.6"
}

dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}

rootProject.name = "ise-lab-code-jason"

include("helloworld")
include("computation")
include("interaction")
include("fanboy")
include("domotic")
include("thermostat")
include("robots")
include("contractnet")

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishOnFailure()
    }
}
