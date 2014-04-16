package henry416;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
public class Student {

	private int id;

	private String name;
	
	private double gpa;
	
	public Student() {
        }

	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}

	@Id
	@GeneratedValue
	@Column(name = "STUDENTID")
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa="
				+ gpa + "]";
	}

}
