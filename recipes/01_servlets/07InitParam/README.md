07InitParam
--------------
Set the servlet initialization parameters using the @WebInitParam annotation. 

Two way for initial params
--------------------------

1) Annotation

@WebServlet(name="InitParam", urlPatterns={"/InitParam"},
initParams={ @WebInitParam(name="name", value="Duke") }) 

2) web.xml

<web-app>
	<servlet>
		<servlet-name>InitParam</servlet-name>
		<servlet-class>henry416.InitParam</servlet-class>
		<init-param>
			<param-name>name</param-name>
			<param-value>Duke</param-value>
		</init-param>
	. . .
	</servlet>
. . .
</web-app>


How to get initParams
---------------------

out.println("<p>This is a simple servlet to demonstrate context! Hello "
+ getServletConfig().getInitParameter("name") + "</p>");

Execution
----------

http://localhost:8080/07InitParam/InitParam