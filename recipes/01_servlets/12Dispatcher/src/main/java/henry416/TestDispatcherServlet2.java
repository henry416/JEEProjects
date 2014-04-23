package henry416;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "TestDispatcherServlet2", urlPatterns = {"/TestDispatcherServlet2"})
public class TestDispatcherServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		// displaying a link back to the first Servlet.

		out.print("<html><head><style>");
		out.print("p,a{font-family:tahoma;font-size:10pt;");
		out.print("color:black;}");
		out.print("input{width:20;height:20;}");
		out.print("</style></head><body>");
		out.print("<p><a ");
		out.print("href=\"TestDispatcherServlet1\">");
		out.print("Go to TestDispatcherServlet1</a>.</p>");
		out.print("</body></html>");

		out.close();
	}

	/*
	In doPost() we receive the HttpServletRequest attribute 'mode' 
	and display it's value to the user.
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {

		String mode = (String)req.getAttribute("mode");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.print("<html><head><style>");
		out.print("p,a{font-family:tahoma;font-size:10pt;");
		out.print("color:black;}");
		out.print("input{width:20;height:20;}");
		out.print("</style></head><body>");
		out.print("<p><b>");
		out.print("TestDispatcherServlet2</b> :</p>");

		if(mode != null) {
			out.print("<p>Attribute value received : ");
			out.print( mode );
			out.print("</p>");
		} else {
			out.print("<p>I have been invoked directly.</p>");
		}

		out.print("</body></html>");
		out.close();
	}
}