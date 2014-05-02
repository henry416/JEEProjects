
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>01basic: JSP Page Example</title>
    </head>
    <body>
        <jsp:useBean id="dateBean" scope="application" class="henry416.B01basic"/>
        <h1>A Basic JSP page from 01basic.jsp!</h1>
        <br/>
		<p> From Backing Bean : B01basic.java (POJO Class: henry416.B01basic) </p>
		<br/>
        <p>
            The current date is: ${dateBean.currentDate}!
        </p>
    </body>
</html>
