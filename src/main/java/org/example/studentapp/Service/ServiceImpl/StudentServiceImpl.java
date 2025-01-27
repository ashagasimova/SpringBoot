package org.example.studentapp.Service.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.example.studentapp.Dao.Entity.StudentEntity;
import org.example.studentapp.Dao.Repository.StudentRepository;
import org.example.studentapp.Dto.StudentRequestDto;
import org.example.studentapp.Dto.StudentResponseDto;
import org.example.studentapp.Mapper.StudentMapper;
import org.example.studentapp.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponseDto> getStudentName(String name) {
        return studentMapper.EntityListToDto(studentRepository.getStudentName(name));
    }

    @Override
    public void addStudents(StudentRequestDto dto) {
       StudentEntity studentEntity= StudentEntity.builder()
               .gender(dto.getGender())
               .name(dto.getName())
               .surname(dto.getSurname())
               .build();
       studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentResponseDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        return studentMapper.EntityListToDto(studentEntities);
    }

    @Override
    public void updateStudent(StudentRequestDto dto) {
        StudentEntity entity = StudentEntity.builder()
                .gender(dto.getGender())
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();

        studentRepository.save(entity);
    }

    @Override
    public void deleteStudent(Long id) {
            studentRepository.deleteById(id);

    }
}
