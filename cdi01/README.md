A SIMPLE CDI SAMPLE USING WELD SE

CONCEPTS      
========

Java SE has JavaBeans
---------------------
(1) POJOs are just Java classes that run inside the Java Virtual Machine (JVM).

(2) JavaBeans are just POJOs that follow certain patterns (e.g., a naming convention for accessors/mutators (getters/setters) for a property, a default constructor . . .) and are executed inside the JVM.

Java EE has Enterprise JavaBeans
--------------------------------
(3) All the other Java EE components also follow certain patterns (e.g., an Enterprise JavaBean must have metadata, a default constructor can’t be final . . .) and are executed inside a container (e.g., the EJB container) that supplies some services (e.g., transaction, pooling, security . . .).

(4) Managed Beans are container-managed objects that support only a small set of basic services: resource injection, life-cycle management, and interception.

(5) Beans are CDI objects that are build on this basic Managed Bean model. Beans have an improved life cycle for stateful objects; are bound to well-defined contexts; bring a typesafe approach to dependency injection, interception, and decoration; are specialized with qualifier annotations; and can be used in expression language (EL). In fact, with very few exceptions, potentially every Java class that has a default constructor and runs inside a container is a bean.

CDI
---
(6) DI: Dependency Injection (DI) is a design pattern that decouples dependent components. Instead of an object looking up other objects, the container injects those dependent objects for you. 

(7) LIFE CYCLE: The life cycle of a POJO is pretty simple: as a Java developer you create an instance of a class using the new keyword and wait for the Garbage Collector to get rid of it and free some memory. But if you want to run a CDI Bean inside a container, you are not allowed to use the new keyword. Instead, you need to inject the bean and the container does the rest, meaning, the container is the one responsible for managing the life cycle of the bean: it creates the instance; it gets rid of it. So how do you initialize a bean if you can’t call a constructor? Well, the container gives you a handle after
constructing an instance and before destroying it.

Managed Bean Life Cycle
===> new instance <calling class>
===> dependency injection <@Injected class object>
===> @PostConstruct <Injected class>
===> method invocation <object.method>
===> @PreDestory  <Injected class>

(8) SCOPES & CONTEXT: CDI Beans may be stateful and are contextual, meaning that they live in a well-defined scope (CDI comes with predefined scopes: request, session, application, and conversation scopes).

(9) INTERCEPTION: Most applications have common code that is repeated across components.
Interceptors are automatically triggered by the container when a Managed Bean method is invoked. when a client invokes a method on your EJB, the container
intercepts the invocation and applies different services (life-cycle management, transaction, security, etc.). 

(10) Loose Coupling and Strong Typing: CDI uses strongly typed annotations (e.g., qualifiers, stereotypes, and interceptor bindings) to wire beans together. Usage of XML descriptors is minimized to truly deployment-specific information.

(11) Deployment Descriptor: With CDI, the deployment descriptor is called beans.xml and is mandatory. It can be used to configure certain functionalities (interceptors, decorators, alternatives, etc.), but it is essential to enable CDI. That’s because CDI needs to identify the beans in your class path (this is called bean discovery). It is during the bean discovery phase that the magic happens: that’s when CDI turns POJOs into CDI Beans.
At deployment time, CDI checks all of your application’s jar and war files and each time it finds a beans.xml deployment descriptor it manages all the POJOs, which then become CDI Beans. Without a beans.xml file in the class path (under
the META-INF or WEB-INF directory), CDI will not be able to use injection, interception, decoration, and so forth. Without this markup file CDI will not work. If your web application contains several jar files and you want to have CDI enabled across the entire application, each jar will need its own beans.xml to trigger CDI and bean discovery for each jar.

PROJECT 
=======
This project demonstrates @INJECT a POJO class to a calling class by using WELD SE.

(1) beans.xml => enable CDI (bean-discovery-mode)

(2) @INJECTED => inject the POJO class

(3) @Observes ContainerInitialized event => A method to observe ContainerInitialized event to boostrap CDI SE (@observe anotation)

STEPS
=====
1. create project using maven

	mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart

2. add weld-se dependency to pom.xml

http://mvnrepository.com/artifact/org.jboss.weld/weld-se/1.0.1-Final
    
3. add src/main/resources/META-INF/beans.xml 

4. A POJO class student.java
5. A client to simply @injected Student by using weld container: StudentCdiClient.java

6. compile

  mvn compile
  
7. execute

  mvn exec:java -Dexec.mainClass="org.jboss.weld.environment.se.StartMain"
  
  The Weld SE module comes with a built-in main method which will bootstrap CDI for you and then fire a ContainerInitialized event. The entry point for your application code would therefore be a simple bean which observes the ContainerInitialized event. The application can be started by calling method "
java org.jboss.weld.environment.se.StartMain". For detail, refer to https://docs.jboss.org/weld/reference/latest/en-US/html/environments.html

8. package

  mvn package
  
  (Remember the jar file execution point is org.jboss.weld.environment.se.StartMain)
  
9. Further Exploration

http://cdi-spec.org/

http://weld.cdi-spec.org/

