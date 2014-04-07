package henry416;
import javax.ejb.*;
import javax.naming.*;


public class Main {

  public static void main(String[] a) throws Exception {
    Context ic = new InitialContext();
    Object obj = ic.lookup(StudentServiceRemote.class.getName());
    System.out.println("Lookup Return => " + obj);
 

    StudentServiceRemote service = (StudentServiceRemote) obj;
    System.out.println("Action Return => " + service.doAction());

  }

}
