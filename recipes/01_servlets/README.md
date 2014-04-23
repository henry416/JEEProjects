01SimpleServlet
---------------

1) mvn archetype:generate -DgroupId=henry416 -DartifactId=01SimpleServlet -DarchetypeArtifactId=maven-archetype-webapp

2) pom.xml

    <dependencies>
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>7.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
    <properties>
        <maven.compiler.source>1.7</maven.compiler.source>
        <maven.compiler.target>1.7</maven.compiler.target>
        <failOnMissingWebXml>false</failOnMissingWebXml>
    </properties>
    <build>
        <finalName>${project.artifactId}</finalName>
    </build>
	
3) mkdir src\main\java\henry416

4) src\main\java\henry416\SimpleServlet.java

5) mvn clean package

6) asadmin deploy target\01SimpleServlet.war

7) asadmin list-applications

8) http://localhost:8080/01SimpleServlet/SimpleServlet
host:port/war_name/url_pattern

9) asadmin undeploy 01SimpleServlet

10) mvn clean

02ServletNoDD
--------------

1) copy the above clean directories/files as 02ServletNoDD

2) modify pom.xml to 02ServletNoDD

3) rename SimpleServlet.java to ServletNoDD.java, and modify as the following

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletNoDD", urlPatterns = {"/ServletNoDD"})
public class ServletNoDD extends HttpServlet {

4) remove web.xml

5) http://localhost:8080/02ServletNoDD/ServletNoDD

6) undploy and clean

03TimeServlet
-------------

1) copy directories / files from 02ServletNoDD to 03TimeServlet

2) modify pom.xml to 03TimeServlet

3) rename ServletNoDD.java to TimeServlet.java

replace ServletNoDD with TimeServlet

add
import java.util.Date;

add
		Date now = new Date();

add
			out.println("<br/>The current date and time is: " + now);

4) mvn clean package

5) asadmin deploy target\03TimeServlet.war

6) http://localhost:8080/03TimeServlet/TimeServlet

7) asadmin undeploy 03TimeServlet

04SimpleMathForm
----------------

1) 04SimpleMathForm\src\main\webapp\index.html

<html>
	<head>
	<title>Simple Math Servlet</title>
	</head>
	<body>
		<h1>This is a simple Math Servlet</h1>
		<form method="POST" action="MathServlet">
		    <label for="numa">Enter Number A: </label>
		    <input type="text" id="numa" name="numa"/><br><br>
            <label for="numb">Enter Number B: </label>
            <input type="text" id="numb" name="numb"/><br/><br/>
		    <input type="submit" value="Submit Form"/>
		    <input type="reset" value="Reset Form"/>
		</form>
	</body>
</html>

2) 04SimpleMathForm\src\main\java\henry416\MathServlet.java\henry416\MathServlet.java

To get the para from web form html

        // Store the input parameter values into Strings
        String numA = req.getParameter("numa");
        String numB = req.getParameter("numb");
		
3) http://localhost:8080/04SimpleMathForm/

05ServletEventListener
----------------------

see README.md.

06AsyncServlet
--------------

see README.md.

07InitParam
------------

@WebServlet(name="InitParam", urlPatterns={"/InitParam"},
initParams={ @WebInitParam(name="name", value="Duke") }) 

...

out.println("<p>This is a simple servlet to demonstrate context! Hello "
+ getServletConfig().getInitParameter("name") + "</p>");

08UrlAccessLog
--------------

@WebFilter(urlPatterns="/*", asyncSupported=true)
public class UrlAccessLog implements Filter {

    private FilterConfig filterConf = null;

    public void init(FilterConfig filterConf) {
        this.filterConf = filterConf;
    }

    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        String userAddy = request.getRemoteHost();
        filterConf.getServletContext().log("Vistor User IP: " + userAddy);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

09WebFilter
------------

README.md

10SessionServlet
----------------

Make use of session attributes to retain session-based information

11DownloadServlet
-----------------

Download a file from server

12Dispatcher
-------------

Dispatcher to be used to forward or include the control from one servlet to another without letting the client (browser) know URL changes

13Redirect
----------

redirect client request to some other location (URL changes)

14Cookie
--------

An example of using cookies

