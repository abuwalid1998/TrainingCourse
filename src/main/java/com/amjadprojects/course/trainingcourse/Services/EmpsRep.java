package com.amjadprojects.course.trainingcourse.Services;

import com.amjadprojects.course.trainingcourse.models.Employee;
import com.amjadprojects.course.trainingcourse.models.Manegers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpsRep extends JpaRepository<Employee,Long> {

    List<Employee> findBymaneger(Manegers id);
}
