package henry416.jsfdao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/*
 * MVC Pattern: Controller
 * class name: StudentController
 * Bean Name: studentBean
 * three attrs: list, student, edit
 * methods: init, add, edit, save, cancel, getList, getStudent, isEdit
 */

@ManagedBean(name="studentBean")
@ViewScoped
public class StudentController implements Serializable {

    private List<Student> list;
    private Student student = new Student();
    private boolean edit;
    private StudentDao studentDao = new StudentDaoImpl();
    
    @PostConstruct
    public void init() {
        // list = dao.list();
        // Actually, you should retrieve the list from DAO. This is just for demo.
	   list = studentDao.getAllStudents();
	   /*
        list = new ArrayList<Student>();
        list.add(new Student(1, "Tom Thomas", 3.50));
        list.add(new Student(2, "Jim Jimson", 3.45));
        list.add(new Student(3, "Will Wilson", 3.87));
        */
    }
    
    public void add() {
        // dao.create(student);
        // Actually, the DAO should already have set the ID from DB. This is just for demo.

        student.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        studentDao.createStudent(student); 
        list.add(student);
        student = new Student(); // Reset placeholder.
    }

    public void edit(Student student) {
        this.student = student;
        edit = true;
    }

    public void save() {
        // dao.update(student);
        studentDao.updateStudent(student); 
        student = new Student(); // Reset placeholder.
        edit = false;
    }


    public void delete(Student student) {
        // dao.delete(student);
        studentDao.deleteStudent(student);
        list.remove(student);

    }

    public List<Student> getList() {
        return list;
    }

    public Student getStudent() {
        return student;
    }

    public boolean isEdit() {
        return edit;
    }

    // Other getters/setters are actually unnecessary. Feel free to add them though.

}
