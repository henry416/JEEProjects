JSF & DAO
=========

The project performs basic CRUD (Create, Read, Update, Delete) operations by using JSF 2.2 and DAO design pattern.

Prerequisites
=============

1) Any web containers support JSF 2.2 like glassfish 4 and above;

2) Derby

3) maven 3

Instructions
============
create a testdb in your glassfish derby

asadmin start-database
ij
ij version 10.9
ij> connect 'jdbc:derby:testdb;create=TRUE;user=test1;password=test1';
ij> create table test1.student (id int, name char(50), gpa double);
0 rows inserted/updated/deleted
ij> insert into test1.student (id, name, gpa) values (1, 'Tom Thomas', 3.54);
1 row inserted/updated/deleted
ij> select * from test1.student;
ID         |NAME                                              |GPA                   
-------------------------------------------------------------------------------------
1          |Tom Thomas                                        |3.54   



