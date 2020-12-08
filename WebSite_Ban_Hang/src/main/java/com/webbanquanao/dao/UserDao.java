package com.webbanquanao.dao;

import com.webbanquanao.model.User;

import java.util.List;

public interface UserDao {
    void insert(User user);

    void edit(User user);

    void delete(int id);

    User get(String userName);

    User get(int id);

    List<User> getAll();

    List<User> search(String userName);

    boolean checkExistEmail(String email);

    boolean checkExistUserName(String userName);
}
