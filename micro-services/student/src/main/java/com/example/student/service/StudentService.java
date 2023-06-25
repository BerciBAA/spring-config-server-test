package com.example.student.service;

import com.example.student.dto.StudentRequest;
import com.example.student.entity.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(StudentRequest student);

    List<Student> findAllStudent();

    List<Student> findAllStudentBySchool(Integer schoolId);
}
