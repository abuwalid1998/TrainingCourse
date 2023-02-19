package com.amjadprojects.course.trainingcourse.Controllers;


import com.amjadprojects.course.trainingcourse.Services.EmployeesServices;
import com.amjadprojects.course.trainingcourse.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/add")
public class AddressController {

    final
    EmployeesServices employeesServices;


    public AddressController(EmployeesServices employeesServices) {
        this.employeesServices = employeesServices;
    }


    @GetMapping("/getbyadd/{id}")
    public List<Employee> getbyadd(@PathVariable Long id){
        return employeesServices.getbyaddress(id);
    }
}
