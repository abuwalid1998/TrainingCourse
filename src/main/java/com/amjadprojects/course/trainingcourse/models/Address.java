package com.amjadprojects.course.trainingcourse.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {



    private Long id;


    @Column(name = "city")
    private String city;

    @Column(name = "Street")
    private String Street;

    @Column(name = "building")
    private String building;


    @ManyToMany(mappedBy = "addresses")
    Set<Employee> employees;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
}
