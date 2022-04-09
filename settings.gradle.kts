rootProject.name = "go-around-server-application"
include("application-modules")
include("application-modules:go-around-api")
findProject(":application-modules:go-around-api")?.name = "go-around-api"
include("domain-modules")
include("domain-modules:mysql-domain")
findProject(":domain-modules:mysql-domain")?.name = "mysql-domain"
include("internal-modules")
include("internal-modules:go-around-jwt")
findProject(":internal-modules:go-around-jwt")?.name = "go-around-jwt"

include("common-modules")
include("common-modules:type")
findProject(":common-modules:type")?.name = "type"