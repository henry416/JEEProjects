package henry416;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "JDBCDataSourceServlet", urlPatterns = {"/JDBCDataSourceServlet"})
public class JDBCDataSourceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 		try {	
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("jdbc/testMySQL");			
			Connection conn = ds.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select ID, NAME, GPA from STUDENT");
			
			// generate HTML output
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<HTML><HEAD><style>TABLE,th,td  { border:1px solid black; border-collapse:collapse;} th,td { padding:5px;}</style><TITLE>STUDENT LISTING</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<h2>Student Records: </h2>");
			out.println("<TABLE style=\"width:300px\">");
			out.println("<tr><th>ID</th><th>NAME</th><th>GPA</th></tr>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString("ID") + "</td><td>"
					+ rs.getString("NAME") + "</td><td>" + rs.getString("GPA")+"</td></tr>");
			}
			out.println("</TABLE>");
			out.println("</BODY></HTML>");
			out.close();
			statement.close();
			conn.close();
		} 	catch (NamingException | SQLException ex) {
				ex.printStackTrace();
			}
		finally {
		}
	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}