package henry416.jpa;
 
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
 
@Stateless
@Local
public class StudentBean implements StudentInterface{
 /*
 @PersistenceContext(unitName="persistenceUnit") annotation is used to inject the EntityManager object by container. In this case, the EntityManager object injected is Container Managed EntityManager object. The transaction type is JTA and the persistence scope is Transaction.
Since we have not declared any transactional attributes in the StudentBean, the default is Container Managed Transaction with transaction attribute being REQUIRED for the bean methods. So, the EntityManager object will join the EJB transaction whenever a method is called on the bean
 **/
 @PersistenceContext(unitName="persistenceUnit")
 private EntityManager em;
     
 public Student createStudent(int id, String name, double gpa){
         
  Student student1 = em.find(Student.class, id);
 
  if(student1 != null)
   throw new IllegalArgumentException ("Student already exists: Id = "+id);
 
  Student student = new Student();
         
  student.setId(id);
  student.setName(name);
  student.setGpa(gpa);
 
  em.persist(student);

  return student;     
 }
  
 public Student updateStudent(int id, String name, double gpa) {
  if(em == null) System.out.println("em is null!!!");
         
  Student student1 = em.find(Student.class, currencyName);
 
  if(student1 == null) throw new IllegalArgumentException ("Student not found: Id"+id);
 
  student1.setName(name);
  student1.setGpa(gpa);
 
  return student1;
          
 }
     
 public List listStudents() {
  if(em == null) System.out.println("em is null!!!");
 
  Query q = em.createQuery("SELECT s FROM Student s");
 
  List StudentList = q.getResultList();
 
  return StudentList;
 }
 
 public void deleteStudent(int id){
  if(em == null) System.out.println("em is null!!!");
 
  Student student1 = em.find(Student.class, id);
 
  if(student1 == null) throw new IllegalArgumentException ("Student not found: Id"+id);;
 
  em.remove(student1);
 }
 
 public Student retrieveStudent(int id) {
  Student student1 = em.find(Student.class, id);
  return student1;
 }
     
}
