package foo;
import javax.ejb.*;
import javax.naming.*;
 
public class Client {
 public static void main(String[] args) throws Exception {
  Context ic = new InitialContext();
  Object obj = ic.lookup(FooRemote.class.getName());
  System.out.println("lookup returned " + obj);
 
  FooRemote foo = (FooRemote) obj;
  String input = (args.length > 0) ? args[0] :
              "No application arg specified.";
  String s = foo.echo(input);
  System.out.println("FooBean.echo returned => " + s);
 }
}
