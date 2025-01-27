package org.example.studentapp.Mapper;

import org.example.studentapp.Dao.Entity.StudentEntity;
import org.example.studentapp.Dto.StudentResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {
    public List<StudentResponseDto> EntityListToDto(List<StudentEntity> entity){
        List<StudentResponseDto> dtos = new ArrayList<>();
        for (StudentEntity e: entity){
            StudentResponseDto dto = StudentResponseDto.builder()
                    .gender(e.getGender())
                    .name(e.getName())
                    .surname(e.getSurname())
                    .build();
            dtos.add(dto);

        }
        return dtos;
    }

}
