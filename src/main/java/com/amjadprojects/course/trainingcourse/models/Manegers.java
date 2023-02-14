package com.amjadprojects.course.trainingcourse.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Manegers implements Serializable {


    @Id
    private Long id;


    @Column
    private String depName;


    @Column(length = 100000)
    @OneToMany(mappedBy = "maneger")
    private Set<Employee> employees;


    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
