package com.example.atlproject.Mapper;

import com.example.atlproject.Dto.UserResponseDto;
import com.example.atlproject.dao.Entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    public List<UserResponseDto> entityListToDtoList(List<UserEntity> userEntityList){
        List<UserResponseDto> dtos = new ArrayList<>();
        for (UserEntity e: userEntityList){
            UserResponseDto dto = UserResponseDto.builder()
                    .fname(e.getFname())
                    .lname(e.getLname())
                    .bday(e.getBday())
                    .gender(e.getGender())
                    .build();
            dtos.add(dto);
        }

        return dtos;

    }

    public UserResponseDto entityToDto(UserEntity e){
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .fname(e.getFname())
                .lname(e.getLname())
                .gender(e.getGender())
                .bday(e.getBday())
                .isActive(e.getIsActive())
                .build();

        return userResponseDto;

    }

}
