/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author himelr
 */
@Entity
@DiscriminatorValue("adminuser")
@XmlRootElement
public class AdminAccount extends UserAccount {

    public AdminAccount() {
    }

    public AdminAccount(String email, String password, String description, String firstName, String lastName) {
        super(email, password, description, firstName, lastName);
        super.setIsAdmin(true);
    }

    public void createNote() {

    }

    public void deleteNote() {

    }

}
