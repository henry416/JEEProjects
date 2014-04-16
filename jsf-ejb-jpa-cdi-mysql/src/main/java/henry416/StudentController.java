package henry416;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

@Named("studentController")
@RequestScoped
public class StudentController implements Serializable {
	/*
		Private attributes
	*/
    @Inject
    private StudentEJB studentEJB;
    private Student student = new Student();
    private List<Student> studentList = new ArrayList<>();

	/*
		Public methods
	*/
	public List<Student> getStudentList() {
        studentList = studentEJB.findStudents();
        return studentList;
    }
 
	public String viewStudent(){
        return "studentList.xhtml";
    }
   
    public String addNewStudent() {
        student = studentEJB.addStudent(student);
        studentList = studentEJB.findStudents();
        return "studentList.xhtml";
    }
	
	/*
		Getters & Setters
		This is important to make student available for EL
		Like #{studentController.student.name}
	*/

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}