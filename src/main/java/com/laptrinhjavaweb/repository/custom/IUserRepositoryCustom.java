package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

public interface IUserRepositoryCustom {
    List<UserEntity> loadStaffWithBuildingID(Long id);
}
