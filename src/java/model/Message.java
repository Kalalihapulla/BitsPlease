/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Izymi
 */
@Entity
@XmlRootElement
public class Message implements Serializable {

    private Long id;
    private String sender;
    private String receiver;
    private String body;
    private String timeCreated;
    private String subject;
    private boolean readStatus;

    public Message(String sender, String receiver, String body, String subject) {
        this.id = 0L;
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
        this.subject= subject;
        this.timeCreated = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date());
        this.readStatus = false;
    }

    public Message() {
        this("unknown", "unknown", "empty","empty");
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
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @XmlElement
    @Basic
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @XmlElement
    @Basic
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
    public boolean getReadStatus() {
        return this.readStatus;

    }
    @XmlElement
    @Basic
    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;

    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }

    @Override
    public String toString() {
       return this.body;
    }
    

}
