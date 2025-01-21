package com.example.atlproject.Controller;

import com.example.atlproject.Dto.StudentRequestDto;
import com.example.atlproject.Dto.StudentResponseDto;
import com.example.atlproject.Dto.UserResponseDto;
import com.example.atlproject.dao.Repository.StudentRepository;
import com.example.atlproject.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("api/v1/student")
@RequiredArgsConstructor

public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @PostMapping
    public void addStudent(@RequestBody StudentRequestDto dto){
    }

    @GetMapping
    public List<StudentResponseDto> getStudents(){

        return  studentService.getAll();
    }

    @GetMapping("{id}")
    public StudentResponseDto getStudent(@PathVariable Long id){
        return studentService.getById(id);
    }
}
