package com.dmb.coffee.shop.system.dao;

import com.dmb.coffee.shop.system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findByEmailId(String email);
}
