/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.io.*;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

public class Signup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        if (!Validate.checkUser(email, pass)) {
            try {
                Account.createUser(email, pass);
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.forward(request, response);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            out.println("Account already exists!");
            RequestDispatcher rs = request.getRequestDispatcher("Error.jsp");
            rs.include(request, response);
        }
    }
}
