10SessionServlet
----------------
maintain some information regarding an individual session on a per-session basis

How
---

Make use of session attributes to retain session-based information. To do so, use the HttpServletRequest object to obtain
access to the session, and then use the getAttribute() and setAttribute() methods accordingly.

// Obtain the Session object
HttpSession session = req.getSession(true);
// Set up a session attribute
String email = (String) session.getAttribute ("session.email");
if (email == null) {
email = req.getParameter("email");
session.setAttribute ("session.email", email);
}

Programs
--------

index.html
SessionServlet.java

Instruction
-----------
mvn clean package
asadmin deploy target\10SessionServlet.war
http://localhost:8080/10SessionServlet/
asadmin undeploy 10SessionServlet
mvn clean

