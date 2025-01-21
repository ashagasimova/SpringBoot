package com.example.atlproject.Service;

import com.example.atlproject.Dto.UserRequestDto;
import com.example.atlproject.Dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
     void addUser(UserRequestDto dto);

     UserResponseDto getUser(Long id);

     List<UserResponseDto> getUsers();

     Long updateUser(Long id, UserRequestDto dto);


}
