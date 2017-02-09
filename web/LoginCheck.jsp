<%-- 
    Document   : LoginCheck
    Created on : Feb 8, 2017, 12:21:07 PM
    Author     : samuelja
--%>
<%--
<%@page contentType="text/html" pageEncoding="UTF-8"%> <html> <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <title>JSP Page</title> </head> <body> <% String username = request.getParameter("username");
    String password = request.getParameter("password");
    if ((username.equals("samu@hotmail.com") && password.equals("best"))) {
        session.setAttribute("username", username);
        response.sendRedirect("Home.jsp");
    } else {
        response.sendRedirect("Error.jsp");
    }%> </body> </html>
--%>
<%@ page import ="java.sql.*" %>
<%

    try {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?" + "user=root&password=starbucks");
        PreparedStatement pst = conn.prepareStatement("Select user,pass from login where user=? and pass=?");
        pst.setString(1, username);
        pst.setString(2, password);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("Error.jsp");
        }
    } catch (Exception e) {
        response.sendRedirect("Error.jsp");
    }
%>