package com.sawitpro.assignment.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "M_Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phoneNumber;
    private String name;
    private String password;
    private Date createdDate;
    private Date updatedDate;


    @ElementCollection(fetch = FetchType.EAGER)
    List<UserRole> userRoles;
}
