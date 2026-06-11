package com.rajat.restapi.service.impl;

import com.rajat.restapi.dto.AddStudentRequestDto;
import com.rajat.restapi.dto.StudentDto;
import com.rajat.restapi.entity.Student;
import com.rajat.restapi.repository.StudentRepository;
import com.rajat.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private  final StudentRepository studentRepository;
    private  final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(students,StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student= studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student Not found in DB"));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudetn(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);


        return modelMapper.map(student,StudentDto.class);
    }
}
