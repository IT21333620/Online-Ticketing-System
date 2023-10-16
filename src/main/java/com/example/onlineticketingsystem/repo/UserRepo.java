package com.example.onlineticketingsystem.repo;

import com.example.onlineticketingsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
