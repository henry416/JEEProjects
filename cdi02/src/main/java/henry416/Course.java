package henry416;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class Course {

    @Inject
    private Faculty faculty;

    private String courseName;

    private int capacity;

    @PostConstruct
    private void init() {
        this.courseName = "CDI 101 - Introduction to CDI";
        this.capacity = 100;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Faculty getFaculty() {
        return faculty;
    }
}
