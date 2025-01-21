package com.example.atlproject.Mapper;

import com.example.atlproject.Dto.StudentRequestDto;
import com.example.atlproject.Dto.StudentResponseDto;
import com.example.atlproject.Dto.UserResponseDto;
import com.example.atlproject.dao.Entity.StudentEntity;
import com.example.atlproject.dao.Repository.StudentRepository;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    private final StudentRepository studentRepository;

    public StudentMapper(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  List<StudentResponseDto> studentToEntity(List<StudentEntity> entityList) {

        List<StudentResponseDto> dtos = new ArrayList<>();

        for (StudentEntity e : entityList) {

            var dto = StudentResponseDto.builder()
                    .fname(e.getLname())
                    .lname(e.getLname())
                    .build();

            dtos.add(dto);
        }
        return dtos;
    }

    public StudentResponseDto studentEntityToDtoById (StudentEntity entity){
        return StudentResponseDto.builder()
                .fname(entity.getFname())
                .lname(entity.getLname())
                .build();

    }




}
