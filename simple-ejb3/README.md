This is a simple EJB 3 project to demonstrate 

1)a simple EJB bean with @Remote interface

2)a java client to call the EJB in Glassfish

1. Create Directory / Files
===========================
mkdir simple-ejb3
cd simple-ejb3/
mkdir classes
mkdir src
cd src
mkdir foo
cd foo/
gedit FooRemote.java&
gedit FooBean.java&
gedit Client.java&

2. Compile, Package, and Deploy to Glassfish
============================================
export JAVAEE_HOME=~/App/glassfish4/glassfish
cd ../../classes
javac -d . -classpath $JAVAEE_HOME/lib/javaee.jar:. ../src/foo/*.java
jar cvf $JAVAEE_HOME/domains/domain1/autodeploy/foo-ejb.jar foo/FooBean.class foo/FooRemote.class
asadmin list-applications

3. Run the client to call the remote EJB
=========================================
java -cp $JAVAEE_HOME/lib/javaee.jar:$JAVAEE_HOME/lib/appserv-rt.jar:. foo.Client
java -cp $JAVAEE_HOME/lib/javaee.jar:$JAVAEE_HOME/lib/appserv-rt.jar:. foo.Client "THIS IS MY EJB REMOTE TEST!"

4. Undeploy the EJB from Glassfish
==================================
asadmin undeploy foo-ejb

Directory
=========
ls -ld $(find .)
drwxr-xr-x 4 henry henry 4096 2014-04-05 22:09 .
drwxr-xr-x 3 henry henry 4096 2014-04-05 21:57 ./classes
drwxr-xr-x 2 henry henry 4096 2014-04-05 21:52 ./classes/foo
-rw-r--r-- 1 henry henry  576 2014-04-05 22:09 ./README.md
drwxr-xr-x 3 henry henry 4096 2014-04-05 21:15 ./src
drwxr-xr-x 2 henry henry 4096 2014-04-05 21:51 ./src/foo
-rw-r--r-- 1 henry henry  489 2014-04-05 21:17 ./src/foo/Client.java
-rw-r--r-- 1 henry henry  137 2014-04-05 21:17 ./src/foo/FooBean.java
-rw-r--r-- 1 henry henry  115 2014-04-05 21:37 ./src/foo/FooRemote.java


./src/foo/FooRemote.java
=========================
package foo;
import javax.ejb.Remote;  
 
@Remote
public interface FooRemote {
   public String echo(String s);
}

./src/foo/FooBean.java
======================
package foo;
import javax.ejb.*;
 
@Stateless
public class FooBean implements FooRemote {
  public String echo(String s) {
    return s;
  }
}

./src/foo/Client.java
=====================
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

