09WebFilter
--------------
Servlet Filters are pluggable java components that we can use to intercept and process requests before they are sent to servlets and response after servlet code is finished and before container sends the response back to the client.

Some common tasks that we can do with filters are:

1) Logging request parameters to log files.
2) Authentication and autherization of request for resources.
3) Formatting of request body or header before sending it to servlet.
4) Compressing the response data sent to the client.
5) Alter response by adding some cookies, header information etc.


Servlet filters are pluggable and configured in deployment descriptor (web.xml) file. Servlets and filters both are unaware of each other and we can add or remove a filter just by editing web.xml.
 
API
---
javax.servlet.Filter
javax.servlet.annotation.WebFilter

Filter interface lifecycle methods
----------------------------------

void init(FilterConfig paramFilterConfig)
-----------------------------------------

When container initializes the Filter, this is the method that gets invoked. This method is called only once in the lifecycle of filter and we should initialize any resources in this method. FilterConfig is used by container to provide init parameters and servlet context object to the Filter. We can throw ServletException in this method.

doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse, FilterChain paramFilterChain)
----------------------------------------------------------------------------------------------------------------

This is the method invoked every time by container when it has to apply filter to a resource. Container provides request and response object references to filter as argument. FilterChain is used to invoke the next filter in the chain. This is a great example of Chain of Responsibility Pattern.

void destroy()
--------------

When container offloads the Filter instance, it invokes the destroy() method. This is the method where we can close any resources opened by filter. This method is called only once in the lifetime of filter.
 
 
Execution
---------

http://localhost:8080/09WebFilter/login.html

User: admin
Password: password


Reference
---------

http://www.journaldev.com/1933/java-servlet-filter-example-tutorial