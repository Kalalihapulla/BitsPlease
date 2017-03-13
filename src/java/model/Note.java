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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author himelr
 */
@Entity
//@Table(name = "notebase")
@XmlRootElement
public class Note implements Serializable, Comparable<Note> {

    private Long id;
    private String description;
    private Status status;
    private String timeCreated;
    private int urgency;
    private String worker;

    public Note() {
        this("empty", 0, "Cashier");
    }

    public Note(String description, int urgency, String worker) {
        this.timeCreated = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        this.urgency = urgency;
        this.id = 0L;
        this.status = Status.STATUS_APPROVED;
        this.description = description;
        this.worker = worker;

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
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
    @Basic
    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    @XmlElement
    @Basic
    public String getWorker() {
        return this.worker;

    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public int compareTo(Note t) {
        if (this.urgency == t.getUrgency()) {
            return 0;
        } else if (this.urgency > t.getUrgency()) {
            return 1;
        } else {
            return -1;
        }
    }

}
