package com.example.autogeneratorplus.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDto {

    @ApiModelProperty("用户名称")
    private String name;

}