package org.example.studentapp.Dao.Repository;

import org.example.studentapp.Dao.Entity.StudentEntity;
import org.example.studentapp.Dto.StudentResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query(value = "select * from students where name =:name", nativeQuery = true )
    List<StudentEntity> getStudentName(@Param("name") String name);
}
