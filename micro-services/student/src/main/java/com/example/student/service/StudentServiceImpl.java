package com.example.student.service;


import com.example.student.dto.StudentRequest;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(StudentRequest studentRequest){

        Student student = mapToStudent(studentRequest);

        studentRepository.save(student);
    }

    private Student mapToStudent(StudentRequest studentRequest) {
        return Student.builder()
                .email(studentRequest.getEmail())
                .firstname(studentRequest.getFirstname())
                .lastname(studentRequest.getLastname())
                .schoolId(studentRequest.getSchoolId())
                .build();
    }

    public List<Student> findAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentBySchool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }


}
