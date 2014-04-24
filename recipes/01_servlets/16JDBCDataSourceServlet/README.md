15JDBCServlet
--------------

	A Servlet to connect to mysql via JDBC directly by JDBC DataSource (JDNI), and run a query to display a table

MySQL
-----

	CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;

	CREATE TABLE `student` (
	  `ID` int(11) NOT NULL AUTO_INCREMENT,
	  `GPA` double DEFAULT NULL,
	  `NAME` varchar(255) DEFAULT NULL,
	  PRIMARY KEY (`ID`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

	USE test;

	INSERT INTO student ( NAME, GPA) VALUES ("Tom Thomson", 3.54);
	INSERT INTO student ( NAME, GPA) VALUES ("Dav Davison", 3.88);
	INSERT INTO student ( NAME, GPA) VALUES ("Mike Butters", 3.22);


Setup JDBC Datasource on Glassfish
-----------------------------------

	copy mysql-connector-java-5.1.30-bin.jar C:\glassfish4\glassfish\domains\domain1\lib
	
	asadmin create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource --restype javax.sql.ConnectionPoolDataSource --property "User=test:Password=test:URL=jdbc:mysql://localhost:3306/test" jdbc/testMySQLPool
	asadmin ping-connection-pool jdbc/testMySQLPool
	
	asadmin --user=admin create-jdbc-resource --connectionpoolid jdbc/testMySQLPool jdbc/testMySQL
	asadmin list-jdbc-reources
	
How to use JDBC resources (JDNI)
--------------------------------

	InitialContext ctx = new InitialContext();
	DataSource ds = (DataSource)ctx.lookup("jdbc/testMySQL");			
	Connection conn = ds.getConnection();
	Statement statement = conn.createStatement();
	ResultSet rs = statement.executeQuery("select ID, NAME, GPA from STUDENT");
	...
	while (rs.next()) {
	out.println("<tr><td>" + rs.getString("ID") + "</td><td>"
		+ rs.getString("NAME") + "</td><td>" + rs.getString("GPA")+"</td></tr>");
	}
	...
	statement.close();
	conn.close();
	
Logical JNDI name option is not available in glassfish
------------------------------------------------------

	https://java.net/jira/browse/GLASSFISH-20243

	Please note that we don' have any logical JDNI like "java:/comp/env/jdbc/testMySQL" in glassfish.
	The logical JDNI is only for default. User defined JDNI don't have any logical JDNI.


	
Instructions
------------

	mvn clean package
	asadmin deploy target\16JDBCDataSourceServlet.war
	http://localhost:8080/16JDBCDataSourceServlet/JDBCDataSourceServlet
	asadmin undeploy 16JDBCDataSourceServlet
	mvn clean
	
Reference
---------

	http://www.java2s.com/Code/Java/Servlets/Database.htm

	http://www.tutorialspoint.com/jdbc/index.htm

