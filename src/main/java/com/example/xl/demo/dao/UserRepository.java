package com.example.xl.demo.dao;

import com.example.xl.demo.entity.po.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findUserByMobileEqualsAndPasswordEquals(String mobile,String password);
}
