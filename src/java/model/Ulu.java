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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Izymi
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "regularuser")
@XmlRootElement
public class Ulu implements Serializable {

    private Long id;
    private String email;
    private String password;
    private List notes;
    private boolean isAdmin;
    private String name;
    private String lul;

    public Ulu() {
    }

    public Ulu(String name, String lul) {
        this.name = name;
        this.lul = lul;
        this.email = "yyddaz";
        this.id = 1L;
        this.isAdmin = true;
        this.password = "wddw";
        this.notes = new ArrayList<>();

    }

    @XmlElement
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    @Basic
    public String getLul() {
        return lul;
    }

    public void setLul(String lul) {
        this.lul = lul;
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

    @XmlElement
    @Basic
    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean state) {
        this.isAdmin = state;
    }

    @XmlElement
    @OneToMany(targetEntity = Note.class,
            cascade = CascadeType.ALL)
    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void addNote(Note note) {
        notes.add(note);

    }

    @Override
    public String toString() {
        return this.email + this.password;
    }
}
