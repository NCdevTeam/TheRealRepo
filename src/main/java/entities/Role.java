package main.java.entities;

import javax.persistence.*;

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

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "authority")
    private String role;

    public Integer getId() {return this.id;}
    public void setId(Integer id) {this.id = id;}

    public Integer getUserId() {return this.userId;}
    public void setUserId(Integer userId) {this.userId = userId;}

    public String getRole() {return this.role;}
    public void setRole(String role) {this.role = role;}
}
