package com.example.school.service;

import com.example.school.dto.FullSchoolResponse;
import com.example.school.dto.SchoolRequest;
import com.example.school.entity.School;

import java.util.List;

public interface SchoolService {


    void saveSchool(SchoolRequest schoolRequest);
    List<School> findAllSchool();
    FullSchoolResponse findSchoolsWithStudents(Integer schoolId);
}
