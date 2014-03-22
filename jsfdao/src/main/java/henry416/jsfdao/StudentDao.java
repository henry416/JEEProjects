package henry416.jsfdao;

import java.util.List;
import henry416.jsfdao.Student;

public interface StudentDao {
   public List<Student> getAllStudents();
   public void createStudent(Student student);
   public void updateStudent(Student student);
   public void deleteStudent(Student student);
}
