package com.example.autogeneratorplus.generator.enums;

import lombok.Getter;

/**
 * @author: lujf
 * @date: 2021/7/15 12:05
 */
public enum DtoTypeEnum {
    DTO("Dto","dto"),
    REQUEST("Request","request"),
    ;

    //类名
    @Getter
    private String className;
    //包名
    @Getter
    private String packageName;

    DtoTypeEnum(String className, String packageName) {
        this.className = className;
        this.packageName = packageName;
    }
}
