package com.example.xl.demo.service;

import com.example.xl.demo.entity.po.User;

import java.util.List;

public interface UserService {

    User insert(User user);

    User selectByMobileAndPassword(String mobile,String password);

    List<User> selectAll();

    User updateById(User user);

    void delete(Long id);
}
