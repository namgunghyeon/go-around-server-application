rootProject.name = "anyone-server-application"
include("application-modules")
include("application-modules:go-around-api")
findProject(":application-modules:go-around-api")?.name = "go-around-api"