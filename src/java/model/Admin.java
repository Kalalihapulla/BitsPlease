/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author himelr
 */
public class Admin extends UserAccount {

    public Admin(String email, String password) {
        super(email, password);
        super.setIsAdmin(true);
    }
    public void createNote(){
        
    }
    public void deleteNote(){
        
    }
    
}
