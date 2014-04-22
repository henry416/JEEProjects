02ServletNoDD
--------------
Create a standard HTML-based web form, and when the submit button is clicked, invoke a servlet to process the
end-user input and post a response.

Web Form
--------

04SimpleMathForm\src\main\webapp\index.html

Servlet
-------

04SimpleMathForm\src\main\java\henry416\MathServlet.java\henry416\MathServlet.java

servlet named MathServlet. This is the Java code that receives the input from the HTML code listed earlier, processes it accordingly, and posts a response

To get the para from web form html

        // Store the input parameter values into Strings
        String numA = req.getParameter("numa");
        String numB = req.getParameter("numb");
		
http://localhost:8080/04SimpleMathForm/