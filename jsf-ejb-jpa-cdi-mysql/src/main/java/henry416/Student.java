package henry416;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "findAllStudents", query = "SELECT s FROM Student s")
public class Student {
	/*
		private attributes
	*/
	private static final long serialVersionUID = 1L; 
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private double gpa;
	
	/*
		constructors
	*/
	public Student() {
        }

	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	/*
		getters and setters
	*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	/*
		hash, equals, toString
	*/
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa="
				+ gpa + "]";
	}
}
