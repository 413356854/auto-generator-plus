package com.example.autogeneratorplus.demo.controller;


import com.example.autogeneratorplus.demo.service.BaseAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 基础账户 前端控制器
 * </p>
 *
 * @author luolita
 * @since 2021-06-23
 */
@RestController
@RequestMapping("/base-account")
public class BaseAccountController {

    @Autowired
    private BaseAccountService baseAccountService;

    
}
