package henry416;

import javax.inject.Inject;
import javax.enterprise.event.Observes;
import org.jboss.weld.environment.se.events.ContainerInitialized;

public class StudentCdiClient {

 @Inject private Student student;
 
 public void main(@Observes ContainerInitialized event){
     System.out.println("Injected object=>"+student);
     student.setId(5);
     student.setName("James");
     student.setGpa(3.55);
     System.out.println("Injected object=>"+student);    
 }
}
