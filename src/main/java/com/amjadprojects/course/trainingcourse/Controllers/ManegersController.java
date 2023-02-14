package com.amjadprojects.course.trainingcourse.Controllers;


import com.amjadprojects.course.trainingcourse.Services.ManegersService;
import com.amjadprojects.course.trainingcourse.models.Employee;
import com.amjadprojects.course.trainingcourse.models.Manegers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mans")
public class ManegersController {


    @Autowired
    ManegersService manegersService;

    @PostMapping("/addnew/{manId}")
    public boolean addItems(@PathVariable Long manId , @RequestBody Employee employee){
        return manegersService.addEmployeeToDepartmnet(manId,employee);
    }

    @GetMapping("/getitmes/{manegersId}")
    public List<Employee> getItems(@PathVariable Long manegersId ){

        return manegersService.getManegers(manegersId);

    }




}
