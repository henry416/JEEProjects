02_jsp
------

	This is a store of projects using JavaServerPage (*.jsp).

What is JSP?
------------
	
	1) JavaServer Pages (JSP) web framework: create dynamic web content,like ASP/PHP
	2) JSP pages can contain a mix of XML and HTML :
		HTML markup
		special JSP tags
		page directives
		JavaScript
		embedded Java code, and more.
	3) Translate to the Java Servlet API
	
Life Cycle
----------
	The life cycle of a JSP page is very much the same as that of a Java servlet. This is because a JSP page is translated to a servlet (the HttpJspBase JSP servlet class) behind the scenes by a special servlet. When a request
	is sent to a JSP page, the special servlet checks to ensure that the JSP page’s servlet is not older than the page
	itself. If it is, the JSP is retranslated into a servlet class and compiled. The JSP-to-servlet translation is automatic,
	which is one of the most productive reasons to use JSP.

	When a JSP page is translated, a servlet with a name such as 0002fjspname_jsp.java is created, where
	jspname is the name of the JSP page. If errors result during the translation, they will be displayed when the JSP
	page response is displayed.
	
	Different portions of the JSP page are treated differently during the translation to a Java servlet.
	
	• Template data is translated into code.
	• JSP scripting elements are inserted into the JSP page’s servlet class.
	• <jsp:XXX .../> elements are converted into method calls.
	
	After translation, the life cycle works similarly to the servlet life cycle:
	
	• If the JSP page’s servlet does not already exist, then the container does the following:
		1. Loads the servlet class
		2. Instantiates the servlet class
		3. Initializes the servlet instance with a call to the jspInit method	