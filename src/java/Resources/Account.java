/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.sql.*;

public class Account {

    private String email;
    private String pass;

    /**
     * Sets the user parameters for a new user
     * @param email email of the user
     * @param pass password of the user
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public static void createUser(String email, String pass) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://bits.cqsscjueysvj.eu-west-1.rds.amazonaws.com:3306/project?" + "user=root&password=starbucks");
            PreparedStatement pst = con.prepareStatement("INSERT INTO login "
                    + "VALUES (?,?)");
            pst.setString(1, email);
            pst.setString(2, pass);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
