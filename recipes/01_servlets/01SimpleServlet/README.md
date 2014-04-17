SimpleServlet
--------------

Java servlets provide developers with the flexibility to design applications using a request-response programming model. 
Servlets play a key role in the development of service-oriented and web application development on the Java platform.
Every servlet class must implement the javax.servlet.Servlet interface or extend another class that does.

The servlet named SimpleServlet extends the HttpServlet class, which provides methods
for handling HTTP processes. In this scenario, a browser client request is sent from the container to the servlet;
then the servlet service method dispatches the HttpServletRequest object to the appropriate method provided by
HttpServlet. Namely, the HttpServlet class provides the doGet, doPut, doPost, and doDelete methods for working
with an HTTP request. The HttpServlet class is abstract, so it must be subclassed, and then an implementation can
be provided for its methods.

Servlet Life Cycle
-------------------

Servlets conform to a life cycle for processing requests and posting results. First, the Java servlet container calls
the servlet’s constructor. The constructor of every servlet must take no arguments. Next, the container calls the servlet
init method, which is responsible for initializing the servlet. Once the servlet has been initialized, it is ready for use.
At that point, the servlet can begin processing. Each servlet contains a service method, which handles the requests
being made and dispatches them to the appropriate methods for request handling. Implementing the service
method is optional. Finally, the container calls the servlet’s destroy method, which takes care of finalizing the servlet
and taking it out of service.

Deployment Descriptor (DD)
--------------------------

Registering servlets in the web.xml file

API
---
javac -cp C:\glassfish4\glassfish\modules\javax.servlet-api.jar SimpleServlet.java

or

C:\glassfish4\glassfish\lib\javaee.jar


