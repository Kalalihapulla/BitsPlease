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
import java.sql.*;

public class Validate {

    public static boolean checkUser(String email, String pass) {
        boolean st = false;
        try {

            //loading drivers for mysql
            Class.forName("com.mysql.jdbc.Driver");

            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?" + "user=root&password=starbucks");
            PreparedStatement pst = con.prepareStatement("Select email,pass from login where email=? and pass=?");
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                st = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
