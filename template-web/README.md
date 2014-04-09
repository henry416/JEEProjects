THIS IS A FULL TEMPLATE FOR A Java EE 7 APPLICATION


1. Create a project directory
------------------------------
mkdir src
mkdir src\main

mkdir src\main\java
mkdir src\main\java\henry416

mkdir src\main\resources
mkdir src\main\resources\META-INF

mkdir src\main\webapp
mkdir src\main\webapp\WEB-INF



2. pom.xml
----------

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>henry416</groupId>
    <artifactId>web-template</artifactId>
    <version>1.0</version>
    <packaging>war</packaging>
    <dependencies>
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
    <properties>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </properties>
</project>

3. Java EE 7 Deployment Descriptors
------------------------------------

http://antoniogoncalves.org/2013/06/04/java-ee-7-deployment-descriptors/

