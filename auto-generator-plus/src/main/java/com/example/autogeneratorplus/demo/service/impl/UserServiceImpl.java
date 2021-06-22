package com.example.autogeneratorplus.demo.service.impl;

import com.example.autogeneratorplus.demo.entity.User;
import com.example.autogeneratorplus.demo.mapper.UserMapper;
import com.example.autogeneratorplus.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author luolita
 * @since 2021-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
