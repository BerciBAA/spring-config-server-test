package com.example.student.controller;

import com.example.student.dto.StudentRequest;
import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService StudentServiceImpl;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody StudentRequest studentRequest){
        StudentServiceImpl.saveStudent(studentRequest);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> findALlStudent(){
        return ResponseEntity.ok( StudentServiceImpl.findAllStudent());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findALlStudent(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok( StudentServiceImpl.findAllStudentBySchool(schoolId));
    }
}
