package com.amjadprojects.course.trainingcourse.Controllers;


import com.amjadprojects.course.trainingcourse.Services.EmployeesServices;
import com.amjadprojects.course.trainingcourse.models.Address;
import com.amjadprojects.course.trainingcourse.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
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


    @PostMapping("/addaddresstouser/{userid}")
    public Boolean add(@PathVariable Long userid , @RequestBody Address address){
        return employeesServices.addAddresstoEmp(userid,address);
    }
}
