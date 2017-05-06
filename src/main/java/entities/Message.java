package main.java.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dR34m3r on 05.05.2017.
 */

@Entity
@Table(name="messages")
public class Message {

    @Id
    @Column(name="Id")
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name="fromUserId")
    private User sender;

    @ManyToOne
    @JoinColumn(name="whomUserId")
    private User receiver;

    @Column(name="when")
    private Date msgDateTime;

    @Column(name="text")
    private String text;

    public Integer getId() { return this.id; }
    public void setId(Integer Id) {this.id = id;}

    public User getSender() {return this.sender; }
    public void setSender(User sender) {this.sender = sender; }

    public User getReceiver() {return this.receiver; }
    public void setReceiver(User receiver) { this.receiver = receiver; }

    public Date getMsgDateTime() {return this.msgDateTime; }
    public void setMsgDateTime(Date msgDateTime) {this.msgDateTime = msgDateTime; }

    public String getText() {return this.text;}
    public void setText(String text) {this.text = text; }
}
