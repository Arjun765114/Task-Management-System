package com.task.TaskManagement.repository;

import com.task.TaskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public boolean existsByEmail(String email);

    public boolean existsByUserid(int userId);

    User findByUsernameAndPassword(String username, String password);
}
