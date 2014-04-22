05ServletEventListener
----------------------
Sometimes it is useful to know when certain events occur within the application server container. This concept can be
useful under many different circumstances, but most often it would likely be used for initializing an application upon
start-up or cleaning up after an application upon shutdown. A servlet listener can be registered with an application
to indicate when it has been started up or shut down. Therefore, by listening for such events, the servlet has the
opportunity to perform some actions when they occur.


Listener Types
--------------

There are many different listener types, and the interface that the class implements is what determines the listener type.

javax.servlet.ServletContextListener : for application deploy (startup) and undeploy (shutdown)
javax.servlet.ServletContextAttributeListener for context attribute changes

javax.servlet.ServletRequestListener : for application/servlet request init and destroy
javax.servlet.ServletRequestAttrbiteListener

javax.servlet.HttpSessionListener : for request.session created and destroyed
javax.servlet.HttpSessionAttributeListener
javax.servlet.http.HttpSessionBindingListener 
javax.servlet.http.HttpSessionActivationListener
javax.servlet.AsyncListener

Implementation
--------------

To create a listener that performs actions based upon a container event, you must develop a class that implements the related interface.
After registered, they are automatically called each time the event occurs.

Registration
------------

use one of the following techniques:

• Utilize the @WebListener annotation, as demonstrated by the solution to this recipe.

• Register the listener within the web.xml application deployment descriptor.

  <listener>
    <listener-class>henry416.listener.AppContextListener</listener-class>
  </listener>
  
• Use the addListener methods defined on interface.


web.xml
--------

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>ServletListenerExample</display-name>
   
  <context-param>
    <param-name>DBUSER</param-name>
    <param-value>test</param-value>
  </context-param>
  <context-param>
    <param-name>DBPWD</param-name>
    <param-value>test</param-value>
  </context-param>
  <context-param>
    <param-name>DBURL</param-name>
    <param-value>jdbc:mysql://localhost/test</param-value>
  </context-param>
   
  <listener>
    <listener-class>henry416.listener.MyAppContextListener</listener-class>
  </listener>
  <listener>
    <listener-class>henry416.listener.MyAppContextAttributeListener</listener-class>
  </listener>
  <listener>
    <listener-class>henry416.listener.MySessionListener</listener-class>
  </listener>
  <listener>
    <listener-class>henry416.listener.MyServletRequestListener</listener-class>
  </listener>
</web-app>

Output
-------

C:\glassfish4\glassfish\domains\domain1\logs\server.log

asadmin deploy target\05ServletEventListener.war
------------------------------------------------

[2014-04-21T11:57:05.507-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=33 _ThreadName=Thread-3] [timeMillis: 1398095825507] [levelValue: 800] [[
  ServletContext attribute added::{DBManager,henry416.db.DBConnectionManager@1ee6cf5}]]

[2014-04-21T11:57:05.507-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=33 _ThreadName=Thread-3] [timeMillis: 1398095825507] [levelValue: 800] [[
  Database connection initialized for Application.]]

....

[2014-04-21T11:57:05.867-0400] [glassfish 4.0] [INFO] [AS-WEB-GLUE-00172] [javax.enterprise.web] [tid: _ThreadID=33 _ThreadName=admin-listener(2)] [timeMillis: 1398095825867] [levelValue: 800] [[
  Loading application [05ServletEventListener] at [/05ServletEventListener]]]

[2014-04-21T11:57:06.226-0400] [glassfish 4.0] [INFO] [] [javax.enterprise.system.core] [tid: _ThreadID=33 _ThreadName=admin-listener(2)] [timeMillis: 1398095826226] [levelValue: 800] [[
  05ServletEventListener was successfully deployed in 9,438 milliseconds.]]
  
http://localhost:8080/05ServletEventListener/MyServlet
------------------------------------------------------  

[2014-04-21T11:57:11.023-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=20 _ThreadName=Thread-3] [timeMillis: 1398095831023] [levelValue: 800] [[
  ServletRequest initialized. Remote IP=127.0.0.1]]

[2014-04-21T11:57:11.054-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=20 _ThreadName=Thread-3] [timeMillis: 1398095831054] [levelValue: 800] [[
  ServletContext attribute added::{User,test}]]

[2014-04-21T11:57:11.054-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=20 _ThreadName=Thread-3] [timeMillis: 1398095831054] [levelValue: 800] [[
  ServletContext attribute removed::{User,test}]]

[2014-04-21T11:57:11.945-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=20 _ThreadName=Thread-3] [timeMillis: 1398095831945] [levelValue: 800] [[
  Session Created:: ID=501610812888e9f69b1d1d947538]]

[2014-04-21T11:57:12.288-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=20 _ThreadName=Thread-3] [timeMillis: 1398095832288] [levelValue: 800] [[
  Session Destroyed:: ID=501610812888e9f69b1d1d947538]]

[2014-04-21T11:57:12.382-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=20 _ThreadName=Thread-3] [timeMillis: 1398095832382] [levelValue: 800] [[
  ServletRequest destroyed. Remote IP=127.0.0.1]]

asadmin undeploy 05ServletEventListener
----------------------------------------
  
[2014-04-21T12:23:43.267-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=32 _ThreadName=Thread-3] [timeMillis: 1398097423267] [levelValue: 800] [[
  Database connection closed for Application.]]
  
  ......


Reference
---------

http://www.journaldev.com/1945/servlet-listener-example-servletcontextlistener-httpsessionlistener-and-servletrequestlistener