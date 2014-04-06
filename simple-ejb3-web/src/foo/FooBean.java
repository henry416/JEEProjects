package foo;
import javax.ejb.*;
 
@Stateless
public class FooBean implements FooRemote {
public String echo(String s) {
  return s;
}
}
