ANOTHER CDI SAMPLE USING WELD SE BOOTSTRAP API

CONCEPTS      
========

(1) LIFE CYCLE

The life cycle of a POJO is pretty simple: as a Java developer you create an instance of a class using the new keyword and wait for the Garbage Collector to get rid of it and free some memory. But if you want to run a CDI Bean inside a container, you are not allowed to use the new keyword. Instead, you need to inject the bean and the container does the rest, meaning, the container is the one responsible for managing the life cycle of the bean: it creates the instance; it gets rid of it. So how do you initialize a bean if you can’t call a constructor? Well, the container gives you a handle after
constructing an instance and before destroying it.

Managed Bean Life Cycle

===> new instance <calling class>

===> dependency injection <@Injected class object>

===> @PostConstruct <Injected class>

===> method invocation <object.method>

===> @PreDestory  <Injected class>

(2) WELD CDI SE Bootstrap API

WELD CDI SE also comes with a bootstrap API which can be called from within your application in order to initialize CDI and obtain references to your application's beans and events. The API consists of two classes: Weld and WeldContainer.

PROJECT 
=======
This project demonstrates @INJECTED a POJO class to a calling class by using WELD SE Container BootStrap API:

(1) beans.xml => enable CDI!

(2) Faculty.java => @PostConstruct

(3) Course.java => @Inject and @PostConstruct

(4) CourseClient.java => Using WELD SE Container bootstrap API

As a result, execution can go directly to CourseClient now instead of using "org.jboss.weld.environment.se.StartMain" as an entry point.

STEPS
=====

(1) compile

  mvn compile
  
(2) execute

  mvn exec:java -Dexec.mainClass="henry416.Course"
  
(3) package

  mvn package