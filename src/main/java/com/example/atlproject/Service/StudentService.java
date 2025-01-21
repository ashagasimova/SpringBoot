package com.example.atlproject.Service;

import com.example.atlproject.Dto.StudentRequestDto;
import com.example.atlproject.Dto.StudentResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void addStudent(StudentResponseDto dto);

    List<StudentResponseDto> getAll();

    StudentResponseDto getById(Long id);

    Long update(Long Id, StudentRequestDto dto);

}

