package com.example.school.service;

import com.example.school.client.StudentClient;
import com.example.school.dto.FullSchoolResponse;
import com.example.school.dto.SchoolRequest;
import com.example.school.entity.School;
import com.example.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.process.internal.ScanningCoordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService{

    private final StudentClient studentClient;

    private final SchoolRepository schoolRepository;

    public void saveSchool(SchoolRequest schoolRequest){
        School school = mapToSchool(schoolRequest);

        schoolRepository.save(school);
    }

    public List<School> findAllSchool(){
        return schoolRepository.findAll();
    }


    private School mapToSchool(SchoolRequest schoolRequest) {
        return School.builder()
                .email(schoolRequest.getEmail())
                .name(schoolRequest.getName())
                .build();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId){
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build());

        var students = studentClient.findAllStudentBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
