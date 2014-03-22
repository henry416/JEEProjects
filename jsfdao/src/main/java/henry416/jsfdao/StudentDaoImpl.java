package henry416.jsfdao;

import java.sql.*;
import java.util.List;
import henry416.jsfdao.Student;

public class StudentDaoImpl implements StudentDao {

   //list is working as a database
   List<Student> students;

   public StudentDaoImpl(){
   } 
 
   @Override
   public List<Student> getAllStudents(){
      Connection con = null;
      PreparedStatement pst = null;
      String stm = "Select id,name,gpa from student";
      ResultSet rs = null;
      //List<Author> records = new ArrayList<Student>();
      try {   
         con = getConnection();
         pst = con.prepareStatement(stm);
         pst.execute();
         rs = pst.getResultSet();

         while(rs.next()){
            Student student = new Student();
            student.setId(rs.getInt(1));
            student.setName(rs.getString(2));
            student.setGpa(rs.getDouble(3));
            students.add(student);				
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
 		try {
			if (pst != null) {
				pst.close();
			}
 
			if (con != null) {
				con.close();
			}
		    } catch (SQLException e) {
         		e.printStackTrace();
      	    }
	 }
      return students;
   }
   
   @Override
   public void createStudent(Student student) {
   
      Connection con = null;
      PreparedStatement pst = null;      			
      String stm = "insert into student (id,name,gpa) values (?,?,?)";

      try {   
         	con = getConnection();
         	pst = con.prepareStatement(stm);
         	pst.setInt(1, student.getId());
	  	pst.setString(2, student.getName());
		pst.setDouble(3, student.getGpa());
        	pst.executeUpdate();         			
        
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
 		try {
			if (pst != null) {
				pst.close();
			}
 
			if (con != null) {
				con.close();
			}
		    } catch (SQLException e) {
         		e.printStackTrace();
      	    }
	 }
   }

   @Override
   public void updateStudent(Student student) {
      Connection con = null;
      PreparedStatement pst = null;      			
      String stm = "update student set name=?,gpa=? where id=?";

      try {   
         	con = getConnection();
         	pst = con.prepareStatement(stm);
         	pst.setInt(3, student.getId());
	  	pst.setString(1, student.getName());
		pst.setDouble(2, student.getGpa());
        	pst.executeUpdate();         			
        
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
 		try {
			if (pst != null) {
				pst.close();
			}
 
			if (con != null) {
				con.close();
			}
		    } catch (SQLException e) {
         		e.printStackTrace();
      	    }
	 }
   }

   @Override
   public void deleteStudent(Student student) {
      Connection con = null;
      PreparedStatement pst = null;      			
      String stm = "delete from student where id=?";

      try {   
         	con = getConnection();
         	pst = con.prepareStatement(stm);
         	pst.setInt(1, student.getId());
/*	  	pst.setString(1, student.getName());
		pst.setDouble(2, student.getGpa());
		*/
        	pst.executeUpdate();         			
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
 		try {
			if (pst != null) {
				pst.close();
			}
 
			if (con != null) {
				con.close();
			}
		    } catch (SQLException e) {
         		e.printStackTrace();
      	    }
	 }
   }
   
   public Connection getConnection(){
      Connection con = null;

      String url = "jdbc:derby://localhost/testdb";
      String user = "test1";
      String password = "test1";
      try {
         con = DriverManager.getConnection(url, user, password);
         System.out.println("Connection completed.");
      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      }
      finally{
      }
      return con;
   }

}
