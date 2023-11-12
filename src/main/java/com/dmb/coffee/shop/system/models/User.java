package com.dmb.coffee.shop.system.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@NamedQuery(name = "User.findByEmailId", query = "select u from User u where u.email=:email")
@NamedQuery(name = "User.updateStatus", query = "update User u set u.status=:status where u.id=:id")
@NamedQuery(name = "User.getAllUser", query = "select new com.dmb.coffee.shop.system.wrapper.UserWrapper(u.id,u.name,u.email,u.contactNumber,u.status) from User u where u.role='user'")
@NamedQuery(name = "User.getAllAdmin", query = "select u.email from User u where u.role='admin'")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@Table(name = "_user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    private String email;

    private String password;

    private String status;

    private String role;

    private static final long serialVersionUID = 1L;

}
