package org.example.studentapp.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.studentapp.Util.Gender;

@Getter
@Setter
@Builder
public class StudentResponseDto {
    private String name;
    private String surname;
    private Gender gender;
}
