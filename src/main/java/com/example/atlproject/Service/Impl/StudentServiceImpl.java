package com.example.atlproject.Service.Impl;

import com.example.atlproject.Dto.StudentRequestDto;
import com.example.atlproject.Dto.StudentResponseDto;
import com.example.atlproject.Mapper.StudentMapper;
import com.example.atlproject.Mapper.UserMapper;
import com.example.atlproject.Service.StudentService;
import com.example.atlproject.dao.Entity.StudentEntity;
import com.example.atlproject.dao.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Builder
@Service

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserMapper userMapper;
    private final StudentMapper studentMapper;


    @Override
    public void addStudent(StudentResponseDto dto) {
        StudentEntity studentEntity = StudentEntity.builder()
                .fname(dto.getFname())
                .lname(dto.getLname())
                .build();
        studentRepository.save(studentEntity);

    }

    @Override
    public List<StudentResponseDto> getAll() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        return studentMapper.studentToEntity(studentEntityList);
    }

    @Override
    public StudentResponseDto getById(Long id) {
        Optional <StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        StudentEntity studentEntity = StudentEntity.builder().build();
        if (optionalStudentEntity.isPresent()){
            studentEntity=optionalStudentEntity.get();
        }
        return studentMapper.studentEntityToDtoById(studentEntity);
    }

    @Override
    public Long update(Long id, StudentRequestDto dto) {
        Optional <StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (optionalStudentEntity.isPresent()){
            StudentEntity studentEntity = optionalStudentEntity.get();
            studentEntity.setFname(dto.getFname());
            studentEntity.setLname(dto.getLname());
            studentRepository.save(studentEntity);
            return id;
        }
        return 0L;
    }
}
