package com.example.atlproject.Service.Impl;

import com.example.atlproject.Dto.UserRequestDto;
import com.example.atlproject.Dto.UserResponseDto;
import com.example.atlproject.Mapper.UserMapper;
import com.example.atlproject.Service.UserService;
import com.example.atlproject.dao.Entity.UserEntity;
import com.example.atlproject.dao.Repository.UserRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Getter
@Builder
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void addUser(UserRequestDto dto) {
        UserEntity entity = UserEntity.builder()
                .fname(dto.getFname())
                .lname(dto.getLname())
                .bday(dto.getBday())
                .gender(dto.getGender())
                .build();

        userRepository.save(entity);
    }

    @Override
    public UserResponseDto getUser(Long id) {
        var optionalUserEntity = userRepository.findById(id);
        var userEntity = UserEntity.builder().build();
        if (optionalUserEntity.isPresent()){
            userEntity = optionalUserEntity.get();
        }
        return userMapper.entityToDto(userEntity);

    }

    @Override
    public List<UserResponseDto> getUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.entityListToDtoList(userEntityList);

    }

    @Override
    public Long updateUser(Long id, UserRequestDto dto) {
        var optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isPresent()) {
            var user = optionalUserEntity.get();
            user.setBday(dto.getBday());
            user.setFname(dto.getFname());
            user.setLname(dto.getLname());
            user.setGender(dto.getGender());
            userRepository.save(user);
            return id;
        }
        return 0L;

    }
}
