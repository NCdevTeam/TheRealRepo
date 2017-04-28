package main.java.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dR34m3r on 27.04.2017.
 */

@Entity
@Table(name="authorities")
public class Role {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @Column(name = "authority")
    private String role;

    public Integer getId() {return this.id;}
    public void setId(Integer id) {this.id = id;}

    public User getUser() {return this.user;}
    public void setUser(User user) {this.user = user;}

    public String getRole() {return this.role;}
    public void setRole(String role) {this.role = role;}
}
