package henry416;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "JDBCServlet", urlPatterns = {"/JDBCServlet"})
public class JDBCServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
		String USER = "test";
		String PASS = "test";
		String URL = "jdbc:mysql://localhost/test";
		PrintWriter out = null;
		Connection connection = null;
		Statement statement;
		ResultSet rs;

		try {
		  Class.forName("com.mysql.jdbc.Driver");

		  connection = DriverManager.getConnection(URL, USER, PASS);
		  statement = connection.createStatement();
		  response.setContentType("text/html;charset=UTF-8");
		  out = response.getWriter();

		  rs = statement.executeQuery("select ID, NAME, GPA from STUDENT");

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
		} catch (ClassNotFoundException e) {
		  out.println("Driver Error");
		} catch (SQLException e) {
		  out.println("SQLException: " + e.getMessage());
		}
		  finally {
			try {
				connection.close();
			} catch (SQLException e) {
				out.println("SQLException: " + e.getMessage());
			}
			out.close();
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