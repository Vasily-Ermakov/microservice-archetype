# Architecture
Generates multi-module project.

`api` module represents microservice interface. It is packaged into separate artifact allowing code reuse by dependent microservices.
 
`service` module represents microservice implementation.

Both modules inherit corresponding POMs from a [parent](https://github.com/Vasily-Ermakov/microservice-parent-archetype).

# Features
* Spring Web MVC
* Spring Data JPA
* Spring Cloud Config Client
* Spring Cloud OpenFeign
* JUnit 5

# Properties
* parentRootGroupId
* parentRootArtifactId
* parentRootVersion

# Example of generation & running on local environment
1. Install parent archetype

    Pull parent archetype [project](https://github.com/Vasily-Ermakov/microservice-parent-archetype).
    Install from root directory.
    
        mvn install
2. Generate parent from archetype

    Generate from target directory or specify outputDirectory parameter.
    Package parameter is irrelevant.
    
        mvn archetype:generate -DarchetypeGroupId=com.gmail.rec0rd.alterego -DarchetypeArtifactId=microservice-parent-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=g -DartifactId=a -Dversion=v -Dpackage=p
3. Install parent
    Install from target directory.
4. Create configuration repository

    Init from {configurationRepositoryDirectory} directory.
    
       git init
5. Install configuration server archetype

    Pull configuration server archetype [project](https://github.com/Vasily-Ermakov/configuration-server-archetype).
    Install from root directory.
6. Generate configuration server from archetype

    Generate from target directory or specify outputDirectory parameter.
    Replace {configurationRepositoryDirectory} with actual value.
    
        mvn archetype:generate -DarchetypeGroupId=com.gmail.rec0rd.alterego -DarchetypeArtifactId=configuration-server-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=csg -DartifactId=csa -Dversion=csv -DconfigServerGitUri=file://{configurationRepositoryDirectory}
7. Install configuration server

    Install from target directory.
8. Install microservice archetype

    Install from root directory.
9. Generate microservice from archetype

    Generate from target directory or specify outputDirectory parameter.
    
        mvn archetype:generate -DarchetypeGroupId=com.gmail.rec0rd.alterego -DarchetypeArtifactId=microservice-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=mg -DartifactId=ma -Dversion=mv -Dpackage=mp -DparentRootGroupId=g -DparentRootArtifactId=a -DparentRootVersion=v
10. Fill microservice properties

    Copy /ma-service/src/main/resources/application.yaml to {configurationRepositoryDirectory}.
    Rename file to ma.yaml.
    Fill actual property values. Add & commit.
    
        git add *
        git commit
11. Run configuration server

        mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8090
12. Run microservice

        mvn spring-boot:run -pl ma-service -Dspring-boot.run.jvmArguments=-Dspring.cloud.config.uri=http://localhost:8090