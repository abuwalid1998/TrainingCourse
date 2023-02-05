package com.amjadprojects.course.trainingcourse.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesServices

{
   final
   EmpsRep empsRep;


    public EmployeesServices(EmpsRep empsRep) {
        this.empsRep = empsRep;
    }

    public Long updatesalary(Long salary){

        return (long) (salary + (salary * 0.05));

    }

}
