package org.example.studentapp.Service;

import org.example.studentapp.Dto.StudentRequestDto;
import org.example.studentapp.Dto.StudentResponseDto;

import java.util.List;

public interface StudentService {
    List<StudentResponseDto> getStudentName(String name);

    void addStudents(StudentRequestDto dto);

    List<StudentResponseDto> getStudents();

    void updateStudent(StudentRequestDto dto);

    void deleteStudent(Long id);
}
