package henry416;
 
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
@Stateless
@Local
public class StudentBean implements StudentServiceLocal, StudentServiceRemote{
 /*
 @PersistenceContext(unitName="persistenceUnit") annotation is used to inject the EntityManager object by container. In this case, the EntityManager object injected is Container Managed EntityManager object. The transaction type is JTA and the persistence scope is Transaction.
Since we have not declared any transactional attributes in the StudentBean, the default is Container Managed Transaction with transaction attribute being REQUIRED for the bean methods. So, the EntityManager object will join the EJB transaction whenever a method is called on the bean
 **/
 @PersistenceContext(unitName="StudentService")
 private EntityManager em;
     
 public Student createStudent(String name, double gpa){
  Student student = new Student();
         
  student.setName(name);
  student.setGpa(gpa);
 
  em.persist(student);

  return student;     
 }
  
 public Student updateStudent(int id, String name, double gpa) {
  if(em == null) System.out.println("em is null!!!");
         
  Student student = em.find(Student.class, id);
 
  if(student != null) {
 
    student.setName(name);
    student.setGpa(gpa);
  }

  return student;
          
 }
     
 public List<Student> listStudents() {
  if(em == null) System.out.println("em is null!!!");
 
  Query q = em.createQuery("SELECT s FROM Student s");
 
  List<Student> StudentList = q.getResultList();
 
  return StudentList;
 }
 
 public void deleteStudent(int id){
  if(em == null) System.out.println("em is null!!!");
 
  Student student1 = em.find(Student.class, id);
 
  if(student1 != null) em.remove(student1);
 }
 
 public Student retrieveStudent(int id) {
  Student student1 = em.find(Student.class, id);
  return student1;
 }

 public String doAction() {

	int lastid;

	String actionStr="\nCreating...\n";
	Student student = createStudent("Tom Thomas",3.50);
	actionStr=actionStr+"createStudent => "+student+"\n";
	student = createStudent("Nick Nickson",3.42);
	actionStr=actionStr+"createStudent => "+student+"\n";
	student = createStudent("Neil Nelson",2.89);
	actionStr=actionStr+"createStudent => "+student+"\n";

	lastid = student.getId();

        actionStr=actionStr+"\nUpdating...\n";
	student = updateStudent(lastid, "New Name", 4.00);
	actionStr=actionStr+"updateStudent => "+student+"\n";

	actionStr=actionStr+"\nlistStudents...\n";
    	List<Student> resultList = listStudents();
    	for (Student next : resultList) {
		actionStr=actionStr+"=> " + next+"\n";
    	}

        actionStr=actionStr+"\ndeleting...\n";
	deleteStudent(lastid);
	actionStr=actionStr+"deleteStudent => id="+lastid+"\n";

 	actionStr=actionStr+"\nlistStudents...\n";
        resultList = listStudents();
    	for (Student next : resultList) {
		actionStr=actionStr+"=> " + next+"\n";
    	}

	return actionStr;
 }
     
}
