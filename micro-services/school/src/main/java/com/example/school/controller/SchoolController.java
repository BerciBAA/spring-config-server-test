package com.example.school.controller;

import com.example.school.dto.FullSchoolResponse;
import com.example.school.dto.SchoolRequest;
import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
    @RequestMapping("/api/v1/school")
public class SchoolController {


    private final SchoolService schoolServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody SchoolRequest schoolRequest){
        schoolServiceImpl.saveSchool(schoolRequest);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchool(){
        return ResponseEntity.ok(schoolServiceImpl.findAllSchool());
    }

    @GetMapping("with-student/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllSchool(@PathVariable("school-id") Integer schoolId){

        return ResponseEntity.ok(schoolServiceImpl.findSchoolsWithStudents(schoolId));
    }
}
