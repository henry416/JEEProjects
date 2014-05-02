01BasicJsp
--------------

1 01basic.jsp and B01basic.java
--------------------------------

	A simple JSP page and A simple Backing Bean (A typical POJO class)
	Good design (MVC)
	
	http://localhost:8080/01BasicJsp/01basic.jsp
	
	1) JSP Tag (scope: page or request or session or application)
	<jsp:useBean id="dateBean" scope="application" class="henry416.B01basic"/>
	2) EL (Expression Language) ${ bean.value }
	${dateBean.currentDate}!
	3) EL refer to Java Class (Backing Bean)
		3.1) any public fields or methods within the class 
		3.2) private fields through public “getter” methods
	
	
2 02embeddedJava.jsp
--------------------

Not a good design!

	A jsp page to embed Java 
	http://localhost:8080/01BasicJsp/02embeddedJava.jsp
	
	1) import page directive
	<%@page import="java.util.Date"%>
	
	2) declaration
	<%! Date currDate = null; %>
	<% currDate = new Date(); %>
	
	you cannot <%! Date currDate = new Date(); %>

	3) use scriptlet (<%...%>)
	<%= currDate %>
	
