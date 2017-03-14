/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resources;

import java.util.List;
import model.UserAccount;
import service.RestHelper;

public class Validate {

    private RestHelper helper;

    public Validate() {
        this.helper = new RestHelper();
    }

    /**
     * Checks if the user email already exists when registering a new account.
     * Also checks if the password exists.
     * @param email email to compare with database
     * @param pass password to compare with database
     * @return 
     */
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
