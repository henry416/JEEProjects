The project to show a simple application to use CDI, JPA, EJB, JSF with glassfish and mysql

1 Java Sources (src\main\java\henry416)
=======================================

Student.java (Entity Bean for CDI)

Student.java (EJB (@Stateless) to manage Entity by using EntityManager)

StudentControl.java (Backing Bean to inject EJB to manage entity and control navigation for JSF front end)

2 Web Front End (src\main\webapps)
==================================

index.xhtml

addStudent.xhtml


3 src\main\resources\META-INF\persistence.xml
=============================================

define persistence-unit and JTA resource for glassfish to mysql

4 some commands for mysql on windows
=====================================

-- start MySQL
start mysqld --defaults-file="C:\Documents and Settings\All Users\Application Data\MySQL\MySQL Server 5.6\my.ini"
or
net start MySQL56

-- status
mysqladmin -u root -p status
mysqladmin -u root -p ping

-- shutdown
mysqladmin -u root -p shutdown

-- print some variables
mysqladmin -u root --password=abcd1234 variables|findstr dir
mysqladmin -u root --password=abcd1234 variables|findstr host
mysqladmin -u root --password=abcd1234 variables|findstr port

mysql -u test -p
mysql -h localhost -u test -p
show databases;
use test;
show tables;

5 Some setup on Glassfish for mysql
====================================

copy mysql-connector-java-5.1.30-bin.jar to C:\glassfish4\glassfish\domains\domain1\lib

asadmin stop-domain

asadmin start-domain

asadmin create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource --restype javax.sql.ConnectionPoolDataSource --property "User=test:Password=test:URL=jdbc\:mysql\://localhost\:3306/test" jdbc/testMySQLPool

asadmin ping-connection-pool jdbc/testMySQLPool

asadmin --user=admin create-jdbc-resource --connectionpoolid jdbc/testMySQLPool jdbc/testMySQL

asadmin list-jdbc-reources


6. Execution Steps
===================

mvn clean package

asadmin deploy target\test.war

asadmin undeploy test

7 Some references
===================

http://www.developer.com/java/ent/integrating-jpa-jsf-and-ejb-in-java-ee7-applications.html

Changes on JSF 2.2
------------------

Since JSF 2.2 we consider the old style @ManagedBean annotation deprecated

1. Change @ManagedBean(name="xxx") to @Named("xxx")

2. Change the package imports for your @XXXScoped annotations to the CDI equivalents.

From						To
javax.faces.bean.ApplicationScoped	javax.enterprise.context.ApplicationScoped
javax.faces.bean.RequestScoped	javax.enterprise.context.RequestScoped
javax.faces.bean.SessionScoped	javax.enterprise.context.SessionScoped
javax.faces.bean.ViewScoped		javax.faces.view.ViewScoped