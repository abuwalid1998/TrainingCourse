package com.amjadprojects.course.trainingcourse.Controllers;


import com.amjadprojects.course.trainingcourse.Services.EmpsRep;
import com.amjadprojects.course.trainingcourse.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emps")
public class ApiController {

    final
    EmpsRep empsRep;


    public ApiController(EmpsRep empsRep) {
        this.empsRep = empsRep;
    }

    @GetMapping("/findall")
    public ArrayList<Employee> getall() {
        return (ArrayList<Employee>) empsRep.findAll();
    }

    @PostMapping("/savenewemp")
    public Employee SaveEmp(@RequestBody Employee employee) {

        try {

            return empsRep.save(employee);

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return new Employee();

        }
    }

    @PostMapping("/saveall")
    public List<Employee> SaveallEmp(@RequestBody List<Employee> employees) {

        try {

            return empsRep.saveAll(employees);

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return empsRep.findAll();

        }
    }


    @PutMapping("{id}")
    public Employee updateEmp(@RequestBody Employee employee ,@PathVariable long id){

       Employee updatedEmp = empsRep.getReferenceById(id);

       updatedEmp.setFullName(employee.getFullName());
       updatedEmp.setBirthdate(employee.getBirthdate());
       updatedEmp.setSalary(employee.getSalary());

        return empsRep.save(updatedEmp);

    }


}