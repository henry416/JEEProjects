02ServletNoDD
--------------
This is an example for a servlet without deployment description web.xml! 

There are a couple of ways to register servlets with a web container. The first way is to register them using the
web.xml deployment descriptor. The second way to register them is to use the @WebServlet annotation. 

The Servlet 3.0 API introduced the @WebServlet annotation, which provides an easier technique to use for mapping a servlet to a URL. 
The @WebServlet annotation is placed before the declaration of a class, and it accepts the elements below

Elements
--------

description 	Description of the servlet
displayName 	The display name of the servlet
initParams 		Accepts list of @WebInitParam annotations
largeIcon 		The large icon of the servlet
loadOnStartup 	Load on start-up order of the servlet
name 			Servlet name
smallIcon 		The small icon of the servlet
urlPatterns 	URL patterns that invoke the servlet


API
---
C:\glassfish4\glassfish\modules\javax.servlet-api.jar

or

C:\glassfish4\glassfish\lib\javaee.jar


