package com.amjadprojects.course.trainingcourse.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    private Long id;

    @Column(name = "fullName")
    private String fullName;


    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private long Salary;

    @Column(name = "password")
    private String password;

    @Column
    private  Long vacationBalance;

    @Column
    private  Double leavingHours;


    @JoinColumn(name = "maneger_id",nullable = false)
    @ManyToOne
    private Manegers maneger;



    @ManyToMany()
    @JoinTable(
           name = "emps_adresses",
           joinColumns = @JoinColumn(name = "emp_id"),
           inverseJoinColumns = @JoinColumn(name = "address_id")
     )
    public List<Address> addresses;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
