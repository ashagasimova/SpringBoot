package org.example.studentapp.Controller;

import lombok.RequiredArgsConstructor;
import org.example.studentapp.Dto.StudentRequestDto;
import org.example.studentapp.Dto.StudentResponseDto;
import org.example.studentapp.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("add")
    public void addStudents(@RequestBody StudentRequestDto dto){
        studentService.addStudents(dto);
    }

    @GetMapping("getStudents")
    public List<StudentResponseDto> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("search")
    public List<StudentResponseDto> getStudentName(@RequestParam("name") String name){
        return studentService.getStudentName(name);
    }

    @PutMapping("put")
    public void updateStudents(@RequestBody StudentRequestDto dto){
            studentService.updateStudent(dto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);

    }

}
