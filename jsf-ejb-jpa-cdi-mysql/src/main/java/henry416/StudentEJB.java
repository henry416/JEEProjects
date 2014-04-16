package henry416;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
 
@Stateless
public class StudentEJB {
 /*
 @PersistenceContext(unitName="StudentService") annotation is used to inject the EntityManager object by container. 
 In this case, the EntityManager object injected is Container Managed EntityManager object. 
 The transaction type is JTA and the persistence scope is Transaction.
 Since we have not declared any transactional attributes in the StudentBean, 
 the default is Container Managed Transaction with transaction attribute being REQUIRED for the bean methods. 
 So, the EntityManager object will join the EJB transaction whenever a method is called on the bean
 **/
 @PersistenceContext(unitName="StudentService")
 private EntityManager em;
     
 public Student addStudent(Student student){ 
  em.persist(student);
  return student;     
 }  
     
 public List<Student> findStudents() {
   TypedQuery<Student> query = em.createNamedQuery("findAllStudents", Student.class);        
   return query.getResultList();
 }  
}
