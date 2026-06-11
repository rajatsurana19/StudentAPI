package com.rajat.restapi.controller;

import com.rajat.restapi.dto.AddStudentRequestDto;
import com.rajat.restapi.dto.StudentDto;
import com.rajat.restapi.entity.Student;
import com.rajat.restapi.repository.StudentRepository;
import com.rajat.restapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private  final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudents(){
//        return  ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
            return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public <addStudentRequestDto> ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return  ResponseEntity.status(HttpStatus.OK).body(studentService.createNewStudetn(addStudentRequestDto));
    }
}
