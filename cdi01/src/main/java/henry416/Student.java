package henry416;

import java.util.Date;

public class Student {
  // ======================================
  // =             Attributes             =
  // ======================================

  private int id = 1;
  private String name = "Tom";
  private double gpa=3.03;


  // ======================================
  // =            Constructors            =
  // ======================================

	public Student() {}

	
	public Student(int id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

  // ======================================
  // =          Getters & Setters         =
  // ======================================
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
