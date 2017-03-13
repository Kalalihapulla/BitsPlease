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
import java.util.ArrayList;
import java.util.List;
import model.UserAccount;
import service.RestHelper;

public class Validate {

    private RestHelper helper;

    public Validate() {
        this.helper = new RestHelper();
    }

    public boolean checkUser(String email, String pass) {
       
        List<UserAccount> users = this.helper.findAll();

        try {
            for (UserAccount user : users) {
                if (user.getEmail().equals(email)) {
                    if (user.getPassword().equals(pass)) {
                        return true;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
