package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.IUserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long>, IUserRepositoryCustom {
    UserEntity findOneByUserNameAndStatus(String name, int status);
    List<UserEntity> findByStatusAndRoles_Code(Integer status, String roleCode);
}
