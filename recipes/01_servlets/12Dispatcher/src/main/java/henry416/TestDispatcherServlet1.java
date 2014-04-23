package henry416;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "TestDispatcherServlet1", urlPatterns = {"/TestDispatcherServlet1"})
public class TestDispatcherServlet1 extends HttpServlet {

	private static final String forwardTo 
		= "TestDispatcherServlet2";
		
	private static final String includeIn 
		= "TestDispatcherServlet2";	

	/*
	In doGet() we display a Form to the user giving the option to either test the forward() method or the include() method. 
	To determine user clicked which button we provide a hidden input field with name of 'mode' 
	and a value of 'forward' ( for forwarding ) or 'include' ( for including ).
	*/

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.print("<html><head><style>");
		out.print("p,form{font-family:tahoma;font-size:10pt;}");
		out.print("input{width:20;height:20;}");
		out.print("</style></head><body>");

		// Displaying Form

		out.print("<form action=\"");
		out.print( req.getRequestURI() );
		out.print("\" method=\"post\">");
		out.print("<input type=\"hidden\" name=\"mode\" ");
		out.print("value=\"forward\">");
		out.print("<input type=\"submit\" value=\" \"");
		out.print("> ");
		out.print(" Forward to another Servlet ..");
		out.print("</form>");

		out.print("<form action=\"");
		out.print( req.getRequestURI() );
		out.print("\" method=\"post\">");
		out.print("<input type=\"hidden\" name=\"mode\" ");
		out.print("value=\"include\">");
		out.print("<input type=\"submit\" ");
		out.print("value=\" \"> ");
		out.print(" Include another Servlet ..");
		out.print("</form>");

		out.print("</body></html>");
		out.close();
	}

	/*
	We handle the user response in our doPost() method and depending on the type of button clicked 
	we either forward the request to the second Servlet or include it's response in the first Servlet.
	
	We also set the attribute "mode" in the HttpServletRequest object to a value 
	depending on which button user clicked. We will display this value in the second Servlet.
	*/
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {

		String mode = req.getParameter("mode");

		// Forwarding to Servlet2

		if(mode != null && mode.equals("forward")) {
			req.setAttribute("mode", "Forwarding Response..");
			req.getRequestDispatcher(forwardTo).forward(req, res);
		}

		// Including response from Servlet2

		if(mode != null && mode.equals("include")) {
			req.setAttribute("mode", "Including Response..");
			req.getRequestDispatcher(includeIn).include(req, res);
		}
	}
}