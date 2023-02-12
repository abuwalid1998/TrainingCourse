package com.amjadprojects.course.trainingcourse.Services;

import com.amjadprojects.course.trainingcourse.models.Manegers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManegersReposity extends JpaRepository<Manegers,Long> {
}
