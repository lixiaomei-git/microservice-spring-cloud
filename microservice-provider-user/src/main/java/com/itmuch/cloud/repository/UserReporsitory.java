package com.itmuch.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itmuch.cloud.entity.User;

@Repository
public interface UserReporsitory extends JpaRepository<User, Long> {

}
