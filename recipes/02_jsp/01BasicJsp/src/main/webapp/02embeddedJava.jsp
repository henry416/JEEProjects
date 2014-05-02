<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! Date currDate = null; %>
<% currDate = new Date(); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>02embeddedJava.jsp: Embedding Java in a JSP</title>
    </head>
    <body>
		<h1>02embeddedJava.jsp: Embedding Java in a JSP</h1>
        <br/>
		<h2> Although it works fine, it is not a good design.</h2>
        <br/>
        The current date and time is: <%= currDate %>
        
    </body>
</html>
