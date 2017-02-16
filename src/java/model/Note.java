/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author himelr
 */
@Entity
//@Table(name = "notebase")
public class Note implements Serializable, Comparable<Note> {

    private Long id;
    private String description;
    private String status;
    private String timeCreated;
    private Urgency urgency;

    public Note() {
        this("empty", Urgency.LOW);
    }

    public Note(String description, Urgency urgency) {
        this.timeCreated = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        this.urgency = urgency;
        this.id = 0L;
        this.status = Status.STATUS_APPROVED.toString();
        this.description = description;

    }

    @XmlElement
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement
    @Basic
    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @XmlElement

    public Urgency searchUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    @Override
    public int compareTo(Note t) {
        if (this.urgency.returnValue() == t.searchUrgency().returnValue()) {
            return 0;
        } else if (this.urgency.returnValue() > t.searchUrgency().returnValue()) {
            return 1;
        } else {
            return -1;
        }
    }

}
