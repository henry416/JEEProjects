06AsyncServlet
--------------

javax.servlet.AsyncEvent;
javax.servlet.AsyncListener;
javax.servlet.AsyncContext;


LongRunningServlet.java
-----------------------

http://localhost:8080/06AsyncServlet/LongRunningServlet?time=8000

Thread Starvation
-----------------

Since our servlet thread is blocked until all the processing is done, if server gets a lot of requests to process, it will hit the maximum servlet thread limit and further requests will get Connection Refused errors.

Prior to Servlet 3.0, there were container specific solution for these long running threads where we can spawn a separate worker thread to do the heavy task and then return the response to client. The servlet thread returns to the servlet pool after starting the worker thread. Tomcat’s Comet, WebLogic’s FutureResponseServlet and WebSphere’s Asynchronous Request Dispatcher are some of the example of implementation of asynchronous processing.

The problem with container specific solution is that we can’t move to other servlet container without changing our application code, that’s why Async Servlet support was added in Servlet 3.0 to provide standard way for asynchronous processing in servlets.

Async Servlets
--------------

1) AsyncLongRunningServlet.java
--------------------------------

the servlet @WebServlet annotation with asyncSupported value as true

2) AppAsyncListener.java
------------------------
get an instance ServletRequest.startAsync() and forward the request to another resource using dispatch() method.

3) AppContextListener.java
---------------------------

create thread pool using Executors framework and use servlet context listener to initiate the thread pool


4) AsyncRequestProcessor.java
-----------------------------

do the heavy processing and then use AsyncContext object to either dispatch the request to another resource or write response using ServletResponse object. Once the processing is finished, we should call AsyncContext.complete() method to let container know that async processing is finished.

5) 

add AsyncListener implementation to the AsyncContext object to implement callback methods – we can use this to provide error response to client incase of error or timeout while async thread processing. 

Execution
---------

http://localhost:8080/06AsyncServlet/AsyncLongRunningServlet?time=8000

Processing done for 8000 milliseconds!!

[2014-04-21T14:09:00.613-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=22 _ThreadName=Thread-3] [timeMillis: 1398103740613] [levelValue: 800] [[
  AsyncLongRunningServlet Start::Name=http-listener-1(5)::ID=22]]

[2014-04-21T14:12:16.739-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=18 _ThreadName=Thread-3] [timeMillis: 1398103936739] [levelValue: 800] [[
  AsyncLongRunningServlet Start::Name=http-listener-1(1)::ID=18]]

[2014-04-21T14:12:16.880-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=18 _ThreadName=Thread-3] [timeMillis: 1398103936880] [levelValue: 800] [[
  AsyncLongRunningServlet End::Name=http-listener-1(1)::ID=18::Time Taken=141 ms.]]

[2014-04-21T14:12:16.880-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=326 _ThreadName=Thread-3] [timeMillis: 1398103936880] [levelValue: 800] [[
  Async Supported? true]]

[2014-04-21T14:12:24.896-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=326 _ThreadName=Thread-3] [timeMillis: 1398103944896] [levelValue: 800] [[
  AppAsyncListener onComplete]]

http://localhost:8080/06AsyncServlet/AsyncLongRunningServlet?time=9999

TimeOut Error in Processing

[2014-04-21T14:15:25.959-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=23 _ThreadName=Thread-3] [timeMillis: 1398104125959] [levelValue: 800] [[
  AppAsyncListener onTimeout]]

[2014-04-21T14:15:25.959-0400] [glassfish 4.0] [INFO] [] [] [tid: _ThreadID=23 _ThreadName=Thread-3] [timeMillis: 1398104125959] [levelValue: 800] [[
  AppAsyncListener onComplete]]

[2014-04-21T14:15:26.881-0400] [glassfish 4.0] [SEVERE] [] [] [tid: _ThreadID=327 _ThreadName=Thread-4] [timeMillis: 1398104126881] [levelValue: 1000] [[
  Exception in thread "pool-145-thread-2"]]

[2014-04-21T14:15:26.881-0400] [glassfish 4.0] [SEVERE] [] [] [tid: _ThreadID=327 _ThreadName=Thread-4] [timeMillis: 1398104126881] [levelValue: 1000] [[
  java.lang.NullPointerException
	at henry416.async.AsyncRequestProcessor.run(AsyncRequestProcessor.java:27)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:744)]]

Reference
---------

http://www.journaldev.com/2008/async-servlet-feature-of-servlet-3

