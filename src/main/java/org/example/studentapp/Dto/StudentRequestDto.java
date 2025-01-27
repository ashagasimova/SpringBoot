package org.example.studentapp.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.studentapp.Util.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
public class StudentRequestDto {

    private String name;
    private String surname;
    private Gender gender;

}
