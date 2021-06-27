package com.example.autogeneratorplus.demo.controller;


import com.example.autogeneratorplus.demo.dto.UserDto;
import com.example.autogeneratorplus.demo.entity.User;
import com.example.autogeneratorplus.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author luolita
 * @since 2021-06-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户", response = User.class)
    @PostMapping("/add")
    public Object add(@RequestBody UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        userService.save(user);
        return user;
    }

}

