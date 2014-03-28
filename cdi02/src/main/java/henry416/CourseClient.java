package henry416;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/*
WELD CDI SE also comes with a bootstrap API which can be called from within your application 
in order to initialize CDI and obtain references to your application's beans and events. 
The API consists of two classes: Weld and WeldContainer.

You don't need @Inject here.
*/

public class CourseClient {
 public static void main(String[] args) {
   // Weld Container Initialization
   Weld weld = new Weld();
   WeldContainer container = weld.initialize();

   // obtain references to beans (like @Inject)
   final Course course = container.instance().select(Course.class).get();

   // Was a Faculty instance injected into Course?
   final Faculty faculty = course.getFaculty();

   // getter from beans
   System.out.println("course.name="+course.getCourseName());
   System.out.println("course.capacity="+course.getCapacity());
   System.out.println("course.faculty="+faculty.getFacultyName());
   System.out.println("course.faculty="+faculty.getFacultyMembers());

   // setter to beans
   course.setCourseName("ECE 001 - Computer Organization");
   course.setCapacity(75);

   System.out.println("course.name="+course.getCourseName());
   System.out.println("course.capacity="+course.getCapacity());

   // weld container shutdown
   weld.shutdown();
 }
}
