package henry416.jpa;
import java.util.List;

public interface StudentInterface {

 public Student createStudent(int id, String name, double gpa);
     
 public List listStudents();
     
 public Student updateStudent(int id, String name, double gpa);
     
 public void deleteStudent(int id);
     
 public Student retrieveStudent(int id);
     
}
