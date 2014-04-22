
package henry416;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="InitParam", urlPatterns={"/InitParam"},
initParams={ @WebInitParam(name="name", value="Duke") }) 
public class InitParam extends HttpServlet {
  
        @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws IOException, ServletException {

		res.setContentType("text/html");

		PrintWriter out = res.getWriter();

		/* Display some response to the user */

		out.println("<html><head>");
		out.println("<title>Simple Servlet Context Example</title>");
		out.println("\t<style>body { font-family: 'Lucida Grande', " +
			"'Lucida Sans Unicode';font-size: 13px; }</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<p>This is a simple servlet to demonstrate context ((initParams))!  Hello " 
                                 + getServletConfig().getInitParameter("name") + "</p>");

		out.println("</body></html>");

		out.close();
	}
}  

