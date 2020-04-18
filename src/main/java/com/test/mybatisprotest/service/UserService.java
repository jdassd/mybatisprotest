package com.test.mybatisprotest.service;

import com.test.mybatisprotest.domain.User;
import com.test.mybatisprotest.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public User findOne(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public String testPost(String str){
        return "注册成功！";
    }
}
