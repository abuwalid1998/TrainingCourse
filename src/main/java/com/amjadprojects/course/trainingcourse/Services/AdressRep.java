package com.amjadprojects.course.trainingcourse.Services;

import com.amjadprojects.course.trainingcourse.models.Address;
import com.amjadprojects.course.trainingcourse.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdressRep extends JpaRepository<Address,Long> {


}
