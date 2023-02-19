package com.amjadprojects.course.trainingcourse.Services;


import com.amjadprojects.course.trainingcourse.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdressService {

    final
    AdressRep adressRep;


    public AdressService(AdressRep adressRep) {
        this.adressRep = adressRep;
    }
}
