rootProject.name = "go-around-server-application"
include("application-modules")
include("application-modules:go-around-api")
findProject(":application-modules:go-around-api")?.name = "go-around-api"
include("domain-modules")
include("domain-modules:mysql-domain")
findProject(":domain-modules:mysql-domain")?.name = "mysql-domain"
