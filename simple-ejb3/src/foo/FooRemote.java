package foo;
import javax.ejb.Remote;  
 
@Remote
public interface FooRemote {
   public String echo(String s);
}

