/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author himelr
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "regularuser")
@XmlRootElement
//@Table(name = "userbase") 
public class UserAccount implements Serializable {

    private Long id;
    private String email;
    private String password;
    private List notes;
    private List messages;
    private String jobDescription;
    private String firstName;
    private String lastName;
    private boolean isAdmin;

    public UserAccount() {
        this("unknown", "unknown", "unknown","unknown","unknown");
        this.isAdmin = false;
    }

    public UserAccount(String email, String password, String description, String firstName, String lastName) {
        this.isAdmin = false;
        this.notes = new ArrayList<>();
        this.id = 0L;
        this.email = email;
        this.password = password;
        this.jobDescription = description;
        this.firstName = firstName;
        this.lastName = lastName;
        this.messages = new ArrayList<>();
    }

    @XmlElement
    @GeneratedValue
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(name = "note")
    @OneToMany(targetEntity = Note.class,
            cascade = CascadeType.ALL)
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @XmlElement(name = "message")
    @ManyToMany(targetEntity = Message.class,
            cascade = CascadeType.ALL)
    public List<Message> getMessages() {
        return this.messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void addNote(Note note) {
        notes.add(note);

    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    @XmlElement
    @Basic
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean state) {
        this.isAdmin = state;
    }

    @XmlElement
    @Basic
    public String getJobDescription() {
        return this.jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @XmlElement
    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement
    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.email;
    }

}
