This is a simple EJB 3 project to demonstrate 

1)a simple EJB bean with @Remote interface

2)a web client using Servlet 3 to call the EJB in Glassfish

1. Create Directory / Files
===========================

mkdir simple-ejb3
cd simple-ejb3/
mkdir target
mkdir target/WEB-INF
mkdir target/WEB-INF/classes
mkdir src
mkdir src/foo
gedit src/foo/FooRemote.java&
gedit src/foo/FooBean.java&
gedit src/foo/FooServlet.java&
gedit target/WEB-INF/web.xml

2. Compile, Package, and Deploy to Glassfish
============================================

export JAVAEE_HOME=~/App/glassfish4/glassfish

cd target/WEB-INF/classes

javac -d . -classpath $JAVAEE_HOME/lib/javaee.jar:. ../src/foo/*.java

jar cvf $JAVAEE_HOME/domains/domain1/autodeploy/simple-ejb3-web.war *

asadmin list-applications

3. Run the client to call the remote EJB
=========================================

http://localhost:8080/simple-ejb3-web/fooServlet

4. Undeploy the EJB from Glassfish
==================================

asadmin undeploy simple-ejb3-web

Directory
=========

ls -ld $(find .)
-rw-r--r-- 1 henry henry 2671 2014-04-06 12:02 ./README.md
drwxr-xr-x 3 henry henry 4096 2014-04-06 10:57 ./src
drwxr-xr-x 2 henry henry 4096 2014-04-06 11:09 ./src/foo
-rw-r--r-- 1 henry henry  137 2014-04-06 10:57 ./src/foo/FooBean.java
-rw-r--r-- 1 henry henry  115 2014-04-06 10:57 ./src/foo/FooRemote.java
-rw-r--r-- 1 henry henry 1238 2014-04-06 11:06 ./src/foo/FooServlet.java
drwxr-xr-x 3 henry henry 4096 2014-04-06 11:22 ./target
drwxr-xr-x 3 henry henry 4096 2014-04-06 11:31 ./target/WEB-INF
drwxr-xr-x 3 henry henry 4096 2014-04-06 10:57 ./target/WEB-INF/classes
drwxr-xr-x 2 henry henry 4096 2014-04-06 11:57 ./target/WEB-INF/classes/foo
-rw-r--r-- 1 henry henry  365 2014-04-06 11:57 ./target/WEB-INF/classes/foo/FooBean.class
-rw-r--r-- 1 henry henry  220 2014-04-06 11:57 ./target/WEB-INF/classes/foo/FooRemote.class
-rw-r--r-- 1 henry henry 1565 2014-04-06 11:57 ./target/WEB-INF/classes/foo/FooServlet.class
-rw-r--r-- 1 henry henry  416 2014-04-06 11:31 ./target/WEB-INF/web.xml

./src/foo/FooRemote.java
=========================

package foo;
import javax.ejb.Remote;  
 
@Remote
public interface FooRemote {
   public String echo(String s);
}

./src/foo/FooBean.java
======================
package foo;
import javax.ejb.*;
 
@Stateless
public class FooBean implements FooRemote {
  public String echo(String s) {
    return s;
  }
}

./src/foo/FooServlet.java
==========================

package foo;
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/fooServlet"})  
public class FooServlet extends HttpServlet {
   @EJB(mappedName="foo.FooRemote")
   private FooRemote foo;
   
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Servlet FooServlet</title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>FooRemote.echo returned: " + foo.echo("From FooServlet") + "</h1>");
       out.println("</body>");
       out.println("</html>");
   }
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
       processRequest(request, response);
   }
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
       processRequest(request, response);
   }
}

