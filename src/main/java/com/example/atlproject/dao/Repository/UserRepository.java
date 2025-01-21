package com.example.atlproject.dao.Repository;

import com.example.atlproject.dao.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long>{


    List<UserEntity> findAllByIsDeleted(Boolean isDeleted);


}
