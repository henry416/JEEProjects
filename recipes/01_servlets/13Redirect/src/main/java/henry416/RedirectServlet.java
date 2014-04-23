package henry416;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name="RedirectServlet", urlPatterns={"/redirect"}) 
public class RedirectServlet extends HttpServlet {
  
        @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws IOException, ServletException {
                String site = "http://henry416.wordpress.com";
                
		res.sendRedirect(site);
	}
}  
