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
