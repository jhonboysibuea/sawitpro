package com.sawitpro.assignment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "M_Users")
public class User {
    @Id
    private Integer id;
    private String phoneNumber;
    private String name;
    private String password;
    private Date createdDate;
    private Date updatedDate;
}
