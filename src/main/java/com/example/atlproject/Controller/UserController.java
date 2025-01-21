package com.example.atlproject.Controller;

import com.example.atlproject.Dto.UserRequestDto;
import com.example.atlproject.Dto.UserResponseDto;
import com.example.atlproject.Service.UserService;
import com.example.atlproject.dao.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    public final UserRepository userRepository;

    @PostMapping
    public void addUser(@RequestBody UserRequestDto dto){
        userService.addUser(dto);
    }

    @GetMapping
    public List<UserResponseDto> getUsers(){
       return userService.getUsers();
    }

    @GetMapping("{id}")
    public UserResponseDto getUser(@PathVariable Long id){
        return userService.getUser(id);

    }

    @PostMapping("set-is-deleted-true")
    public void updateIsDeletedTrue(){
        var userList = userRepository.findAllByIsDeleted(false);
        for (var e : userList){
            e.setIsDeleted(true);
        }

        userRepository.saveAll(userList);
    }

    @PostMapping("update/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto dto){
        return userService.updateUser(id, dto);

    }


}


