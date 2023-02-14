package com.amjadprojects.course.trainingcourse.Controllers;


import com.amjadprojects.course.trainingcourse.Services.EmployeesServices;
import com.amjadprojects.course.trainingcourse.Services.EmpsRep;
import com.amjadprojects.course.trainingcourse.Services.ManegersService;
import com.amjadprojects.course.trainingcourse.models.Employee;
import com.amjadprojects.course.trainingcourse.models.Manegers;
import com.lowagie.text.Document;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/emps")
public class ApiController {

    final
    EmpsRep empsRep;


    final
    ManegersService manegersReposity;

final
EmployeesServices employeesServices;

    public ApiController(EmpsRep empsRep, EmployeesServices employeesServices, ManegersService manegersReposity) {
        this.empsRep = empsRep;
        this.employeesServices = employeesServices;
        this.manegersReposity = manegersReposity;
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

        System.out.println("******************************************");

        System.out.println(employees.get(1).getSalary());

        System.out.println("******************************************");


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
       updatedEmp.setPassword(employee.getPassword());
       updatedEmp.setSalary(employee.getSalary());

        return empsRep.save(updatedEmp);

    }


    @GetMapping("/getbyid")
    public Employee GetEmpById(@RequestHeader Long id){

        System.out.println(id);

        Employee emp = empsRep.getReferenceById(id);

        System.out.println(emp.getSalary());

        return  emp;

    }


    @GetMapping("/updatesal/{id}")
    public  Employee updateSal(@PathVariable long id){


        Employee updatedEmp = empsRep.getReferenceById(id);

        Long salary = updatedEmp.getSalary();

        System.out.println("Old Salary:- "+salary);

        salary = employeesServices.updateSalary(salary);

        updatedEmp.setSalary( salary);

        System.out.println("New Salary :- "+salary);

        return empsRep.save(updatedEmp);
    }


    @GetMapping("/getempdoc/{id}")
    public Document getDoc(@PathVariable long id,HttpServletResponse response){


        Employee employee;

        try {

             employee = empsRep.getReferenceById(id);

        }catch (EntityNotFoundException e){

            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }




        System.out.println(employee.getFullName()+"************************");

       try {

           String headerkey = "Content-Disposition";
           String headervalue = "attachment; filename=EmployeeDetails" + employeesServices.gettime() + ".pdf";

           response.setStatus(HttpServletResponse.SC_OK);

           response.setContentType("application/pdf");
           response.setHeader(headerkey, headervalue);


           System.out.println(employee.getFullName()+"************************");


           return   employeesServices.generate(employee,response);

       }catch (Exception e){


           response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

           return null;

       }




    }



    @GetMapping("/takevac/{empid}/{numofdays}")
    public boolean takeVacation(@PathVariable Long empid,@PathVariable Long numofdays){


        return employeesServices.takevaction(empid,numofdays);


    }


    @GetMapping("/leaveHoues/{empid}/{numofhours}")
    public Double leavingHours(@PathVariable Long empid,@PathVariable Double numofhours){

        return  employeesServices.inseartLeaveingHours(empid,numofhours);

    }


    @PostMapping("/addempstomaneger/{man_id}")
    public Manegers inseartEmps(@PathVariable Long man_id, @RequestBody Set<Employee> employees){


        return manegersReposity.inseartEmps(man_id,employees);



    }


    @GetMapping("/getManegerDetalis/{id}")
    public Manegers manegers(@PathVariable Long id){
        try {

            return manegersReposity.getManegers(id);

        }catch (Exception e){

            System.out.println(e.getMessage());

            return new Manegers();

        }

    }

}