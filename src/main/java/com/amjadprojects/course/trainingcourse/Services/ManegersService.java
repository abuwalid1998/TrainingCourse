package com.amjadprojects.course.trainingcourse.Services;


import com.amjadprojects.course.trainingcourse.models.Employee;
import com.amjadprojects.course.trainingcourse.models.Manegers;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManegersService {

    final
    ManegersReposity manegersReposity;


    final
    EmpsRep empsRep;


    public ManegersService(ManegersReposity manegersReposity, EmpsRep empsRep) {
        this.manegersReposity = manegersReposity;
        this.empsRep = empsRep;
    }


    public boolean addEmployeeToDepartmnet(Long man_id,Employee employee){

        Optional<Manegers>optionalManegers = manegersReposity.findById(man_id);
        if (optionalManegers.isPresent()){
            Manegers maneger = optionalManegers.get();
            employee.setManeger(maneger);
            empsRep.save(employee);
            return true;
        }
        return false;
    }


    public List<Employee> getManegers(Long id){

        Manegers manegers = manegersReposity.getReferenceById(id);

        return empsRep.findBymaneger(manegers);

    }
}
