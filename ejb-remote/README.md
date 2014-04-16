The project uses EJB remote interface from a Java Clientto to test EJB and JPA on Glassfish 4


1. Create a project directory
=============================

mkdir src
mkdir src\main

mkdir src\main\java
mkdir src\main\java\henry416

mkdir src\main\resources
mkdir src\main\resources\META-INF

pom.xml
-------

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>henry416</groupId>
    <artifactId>jpa-ejb-remote</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
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

2. src\main\resources\META-INF
===============================

persistence.xml
---------------

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
    <persistence-unit name="StudentService" transaction-type="JTA">
        <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
        <jta-data-source>java:app/jdbc/testdb</jta-data-source>
        <properties>
            <property name="eclipselink.ddl-generation" value="drop-and-create-tables"/>
        </properties>
    </persistence-unit>
</persistence>


glassfish-resources.xml
-----------------------

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE resources PUBLIC "-//GlassFish.org//DTD GlassFish Application Server 3.1 Resource Definitions//EN" "http://glassfish.org/dtds/glassfish-resources_1_5.dtd">
<resources>
    <jdbc-connection-pool allow-non-component-callers="false" associate-with-thread="false" 
	connection-creation-retry-attempts="0" connection-creation-retry-interval-in-seconds="10" 
	connection-leak-reclaim="false" connection-leak-timeout-in-seconds="0" connection-validation-method="auto-commit" 
	datasource-classname="org.apache.derby.jdbc.ClientDataSource" fail-all-connections="false" idle-timeout-in-seconds="300" 
	is-connection-validation-required="false" is-isolation-level-guaranteed="true" 
	lazy-connection-association="false" lazy-connection-enlistment="false" match-connections="false" 
	max-connection-usage-count="0" max-pool-size="32" max-wait-time-in-millis="60000" 
	name="derby_net_testdb_appPool" non-transactional-connections="false" pool-resize-quantity="2" 
	res-type="javax.sql.DataSource" statement-timeout-in-seconds="-1" steady-pool-size="8" 
	validate-atmost-once-period-in-seconds="0" wrap-jdbc-objects="false">
        <property name="serverName" value="localhost"/>
        <property name="portNumber" value="1527"/>
        <property name="databaseName" value="testdb"/>
        <property name="User" value="app"/>
        <property name="Password" value="app"/>
        <property name="URL" value="jdbc:derby://localhost:1527/testdb;create=true"/>
        <property name="driverClass" value="org.apache.derby.jdbc.ClientDriver"/>
    </jdbc-connection-pool>
    <jdbc-resource enabled="true" jndi-name="java:app/jdbc/testdb" object-type="user" pool-name="derby_net_testdb_appPool"/>
</resources>

ejb-jar.xml
-----------

<?xml version="1.0" encoding="UTF-8"?>

<ejb-jar>
   <enterprise-beans>

   </enterprise-beans>
</ejb-jar>

3. Execution Steps
===================

mvn clean package

asadmin start-domain

asadmin start-database

asadmin deploy target\jpa-ejb-remote-1.0.jar

cd target\classes

java -classpath C:\glassfish4\glassfish\lib\javaee.jar;C:\glassfish4\glassfish\lib\appserv-rt.jar;. henry416.Main

asadmin undeploy jpa-ejb-remote-1.0

4. Some references
===================

http://stuetzpunkt.wordpress.com/2014/01/06/create-jdbc-resources-on-glassfish-4-with-glassfish-resources-xml/

https://blogs.oracle.com/enterprisetechtips/entry/datasource_resource_definition_in_java

https://blogs.oracle.com/JagadishPrasath/entry/application_scoped_resources_in_glassfish
