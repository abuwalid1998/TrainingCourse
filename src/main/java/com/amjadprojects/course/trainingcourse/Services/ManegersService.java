package com.amjadprojects.course.trainingcourse.Services;


import com.amjadprojects.course.trainingcourse.models.Employee;
import com.amjadprojects.course.trainingcourse.models.Manegers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ManegersService {

    final
    ManegersReposity manegersReposity;


    public ManegersService(ManegersReposity manegersReposity) {
        this.manegersReposity = manegersReposity;
    }


    public Manegers inseartEmps(Long id , Set<Employee> employees){


        Manegers maneger  = manegersReposity.getReferenceById(id);


        System.out.println("************************");
        System.out.println(maneger.toString());
        System.out.println("************************");


        maneger.setEmployees(employees);


        System.out.println("************************");
        System.out.println(maneger.toString());
        System.out.println("************************");

      return   manegersReposity.save(maneger);

    }
}
