package com.example.atlproject.Dto;

import com.example.atlproject.Util.Enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter
@Getter
@Builder

public class UserResponseDto {

    private String fname;
    private String lname;
    private LocalDate bday;
    private Gender gender;
    private Boolean isActive;
}
