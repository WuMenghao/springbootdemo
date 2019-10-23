package com.example.xl.demo.service.impl;

import com.example.xl.demo.dao.UserRepository;
import com.example.xl.demo.entity.po.User;
import com.example.xl.demo.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insert(User user) {
        Date now=new Date();
        user.setPassword(getMD5Password(user.getPassword()));
        user.setCreateTime(now);
        user.setUpdateTime(now);
        return userRepository.save(user);
    }

    @Override
    public User selectByMobileAndPassword(String mobile,String password) {
        return userRepository.findUserByMobileEqualsAndPasswordEquals(mobile,getMD5Password(password));
    }

    @Override
    public List<User> selectAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateById(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private String getMD5Password(String password){
        return DigestUtils.md5Hex(password);
    }
}
