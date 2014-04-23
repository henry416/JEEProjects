13Redirect
----------

redirect client request to some other location (URL changes)

res.sendRedirect("http://henry416.wordpress.com");

Instructions
-------------

mvn clean package

asadmin deploy target\13Redirect.war

http://localhost:8080/13Redirect/redirect

(will go directly to http://henry416.wordpress.com)

asadmin undeploy 13Redirect

mvn clean