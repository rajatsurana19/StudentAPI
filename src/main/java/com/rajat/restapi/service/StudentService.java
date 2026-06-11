package com.rajat.restapi.service;

import com.rajat.restapi.dto.AddStudentRequestDto;
import com.rajat.restapi.dto.StudentDto;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudetn(AddStudentRequestDto addStudentRequestDto);
}
