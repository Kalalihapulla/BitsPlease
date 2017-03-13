/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

/**
 *
 * @author samuelja
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet {
    private final Validate validate;

    public Login() {
        this.validate = new Validate();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        if (session == null || session.getAttribute("loggedInUser") == null) {
            if (validate.checkUser(email, pass)) {
                request.getSession().setAttribute("loggedInUser", email);
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.forward(request, response);
            } else {
                out.println("Username or Password incorrect");
                RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
                rs.include(request, response);
            }
        } else {
            request.getSession().setAttribute("loggedInUser", null);
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
        }

    }
}
