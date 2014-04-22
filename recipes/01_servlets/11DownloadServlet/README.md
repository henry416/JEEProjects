11DownloadServlet
-----------------
servlet application to have the ability to download a given file

a servlet that will accept the name and path of a chosen file and then read the file and stream it to the file
requestor.

Programs
--------

index.html

downloadTest.txt

DownloadServlet.java


Instruction
-----------

mvn clean package

asadmin deploy target\11DownloadServlet.war

http://localhost:8080/11DownloadServlet

asadmin undeploy 11DownloadServlet

mvn clean

