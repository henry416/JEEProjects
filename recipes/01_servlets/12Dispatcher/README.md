12Dispatcher
--------------

how to pass control from one Servlet to another using RequestDispatcher.forward() method and how to include response from another Servlet within the caller Servlet using RequestDispatcher.include() method.

RequestDispatcher Interface
---------------------------

This interface is present in the javax.servlet package and contains only following two methods :

1) forward(ServletRequest request, ServletResponse response) Forwards a request to another resource on the same server. That resource can be a Servlet, JSP page or a simple HTML page.

2) include(ServletRequest request, ServletResponse response) Works like a server-side include ( SSI ) and includes the response from the given resource ( Servlet, JSP page, HTML page ) within the caller response.

How to get a reference to RequestDispatcher Interface ?
-------------------------------------------------------

In order to use forward() or include() methods we discussed above we will have to get a reference to RequestDispatcher interface. There are two ways you can do this :

ServletContext.getRequestDispatcher(String resource)

ServletRequest.getRequestDispatcher(String resource)

1) If your Servlet is extending HttpServletRequest then you can simply call getRequestDispatcher(String resource) to get reference to the RequestDispatcher object for the given resource. This is what we will do in the demo application later.

	// req is HttpServletRequest object

	RequestDispatcher rd;
	rd = req.getRequestDispatcher("pathToServlet");
	rd.forward(req, res);

2) Or you can use ServletContext's getRequestDispatcher(String resource) to do the same.

	RequestDispatcher rd;
	rd = getServletContext().getRequestDispatcher("pathToServlet");
	rd.forward(req, res);

Our Programs
------------

Our program will consist of two Servlets. 

1) TestDispatcherServlet1.java

2) TestDispatcherServlet2.java


First Servlet will call forward() and include() methods to display response from second Servlet. 

To demonstrate the use of HttpServletRequest attributes, we will set an attribute in the first Servlet and display that attribute from within the second Servlet.	

Execution
---------
mvn clean package

asadmin deploy target\12Dispatcher.war

http://localhost:8080/12Dispatcher/TestDispatcherServlet1

asadmin undeploy 12Dispatcher

mvn clean
	
References
----------

http://xmelegance.org/qxservlet/request-dispatcher1.html

http://xmelegance.org/qxservlet/request-dispatcher2.html	
