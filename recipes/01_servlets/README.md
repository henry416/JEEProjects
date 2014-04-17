01SimpleServlet
---------------

1) mvn archetype:generate -DgroupId=henry416 -DartifactId=01SimpleServlet -DarchetypeArtifactId=maven-archetype-webapp

2) pom.xml

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
    <build>
        <finalName>${project.artifactId}</finalName>
    </build>
	
3) mkdir src\main\java\henry416

4) src\main\java\henry416\SimpleServlet.java

5) mvn clean package

6) asadmin deploy target\01SimpleServlet.war

7) asadmin list-applications

8) http://localhost:8080/01SimpleServlet/SimpleServlet
host:port/war_name/url_pattern

9) asadmin undeploy 01SimpleServlet

10) mvn clean

02ServletNoDD
--------------

1) copy the above clean directories/files as 02ServletNoDD

2) modify pom.xml to 02ServletNoDD

3) rename SimpleServlet.java to ServletNoDD.java, and modify as the following

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletNoDD", urlPatterns = {"/ServletNoDD"})
public class ServletNoDD extends HttpServlet {

4) remove web.xml

5) http://localhost:8080/02ServletNoDD/ServletNoDD

