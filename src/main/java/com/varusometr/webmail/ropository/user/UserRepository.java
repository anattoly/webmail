package com.varusometr.webmail.ropository.user;

import com.varusometr.webmail.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserRepository {

    void createUser(User user);

    void removeUserById(Long id);

    void updateUserById(Long id, User user);

    User findUserById(Long id);

    User findByUsername(String username);

    Page<User> findAll(int page, int size);

    List<User> findAll();
}
