14Cookie
--------------

A cookie is a small piece of information that is persisted between the multiple client requests.

A cookie has a name, a single value, and optional attributes such as a comment, path and domain qualifiers, a maximum age, and a version number.

How?
----

By default, each request is considered as a new request. In cookies technique, we add cookie with response from the servlet. 
So cookie is stored in the cache of the browser. After that if request is sent by the user, cookie is added with request by default. 
Thus, we recognize the user as the old user.

Create
------

        Cookie cookie = new Cookie("myId","12345");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-30);
        response.addCookie(cookie);
		cookie = new Cookie("myName","TestUser");
		response.addCookie(cookie);
		
Retrieve
---------

		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
                out.println("<p>");
                out.println("Cookie Name: " + cookie.getName());
                out.println("<br/>");
                out.println("Value: " + cookie.getValue());
                out.println("</p>");
        }
		
Instruction
-----------

mvn clean package

asadmin deploy target\14Cookie.war

http://localhost:8080/14Cookie/SetCookieServlet

chrome->Setting->(Privacy->Content Setting)-Cookies->All Cookies and Site Data-Search for 'localhost'->

you'll see myId and myName cookies

asadmin undeploy 14Cookie

mvn clean

Reference
----------

http://www.javatpoint.com/cookies-in-servlet

http://www.javatpoint.com/servlet-login-and-logout-example-using-cookies

http://www.journaldev.com/1956/servlet-cookie-example-tutorial

