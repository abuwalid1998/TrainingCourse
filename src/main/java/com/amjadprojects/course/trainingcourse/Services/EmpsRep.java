package com.amjadprojects.course.trainingcourse.Services;

import com.amjadprojects.course.trainingcourse.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpsRep extends JpaRepository<Employee,Long> {
}
