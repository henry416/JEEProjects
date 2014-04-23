15JDBCServlet
--------------

A Servlet to connect to mysql via JDBC directly without using JDNI, and run a query to display a table

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


Drop mysql jar into Glassfish
-----------------------------

	copy mysql-connector-java-5.1.30-bin.jar to C:\glassfish4\glassfish\domains\domain1\lib
	
Reference
---------

http://www.java2s.com/Code/Java/Servlets/Database.htm

http://www.tutorialspoint.com/jdbc/index.htm

