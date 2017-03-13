<%-- 
    Document   : Logout
    Created on : Feb 8, 2017, 12:23:09 PM
    Author     : samuelja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> <html> <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>JSP Page</title> </head> <body> <% session.removeAttribute("username");
    session.removeAttribute("password");
    session.invalidate();%> <h1>Logout was done successfully.</h1> </body> </html>
