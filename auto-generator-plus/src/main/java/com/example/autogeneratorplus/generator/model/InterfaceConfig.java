package com.example.autogeneratorplus.generator.model;

import lombok.Data;

@Data
public class InterfaceConfig extends SuperConfig {

    //
    private String entityName;

    //代码赋值
    private String dtoParamsLine;
}
