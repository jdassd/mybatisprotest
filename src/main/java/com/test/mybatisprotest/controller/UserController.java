package com.test.mybatisprotest.controller;

import com.domain.User;
import com.service.UserService;
import com.utils.AjaxModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll.do")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/findOne.do")
    public User findOne(@RequestParam Integer id){
        return userService.findOne(id);
    }

    @PostMapping("/testPost.do")
    public AjaxModel<String> testPost(@RequestParam @NotEmpty(message = "不能为空") String str){
        return AjaxModel.<String>builder()
                .code(1)
                .data(userService.testPost(str))
                .msg("testPost suc").build();
    }
}
