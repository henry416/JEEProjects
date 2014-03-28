A SIMPLE CDI SAMPLE USING WELD SE

1. create project using maven
	mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

2. add weld-se dependency to pom.xml
    <dependency>
     <groupId>org.jboss.weld</groupId>
     <artifactId>weld-se</artifactId>
     <version>1.0.1-Final</version>
     <type>jar</type>
     <scope>compile</scope>
    </dependency>
    
 3. vi src/main/resources/META-INF/beans.xml 
<beans xmlns="http://xmlns.jcp.org/xml/ns/javaee"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/beans_1_1.xsd"
       version="1.1" bean-discovery-mode="all">
</beans>

4. A POJO class student.java
5. A client to simply injected the student class by using weld container: StudentCdiClient.java
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

6. compile
  mvn compile
  
7. execute
It's not executing "henry416.StudentCdiClient.Main". Instead, the starting point is "org.jboss.weld.environment.se.StartMain"

  mvn exec:java -Dexec.mainClass="org.jboss.weld.environment.se.StartMain"

8. package
  mvn package
  (Remember the jar file execution point is org.jboss.weld.environment.se.StartMain)
  
9. Further Exploration
http://cdi-spec.org/
http://weld.cdi-spec.org/

