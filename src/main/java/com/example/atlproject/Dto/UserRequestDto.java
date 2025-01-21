package com.example.atlproject.Dto;

import com.example.atlproject.Util.Enums.Gender;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserRequestDto {

    private String fname;
    private String lname;
    private LocalDate bday;
    private Gender gender;
}
