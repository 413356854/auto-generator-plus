package com.example.autogeneratorplus.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDto {

    @ApiModelProperty("姓名")
    private String name;

}
