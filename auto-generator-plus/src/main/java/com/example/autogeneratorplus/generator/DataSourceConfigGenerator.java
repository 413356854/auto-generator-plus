package com.example.autogeneratorplus.generator;

import com.example.autogeneratorplus.generator.model.DataSourceConfigConfig;
import com.example.autogeneratorplus.generator.util.GeneratorUtil;
import com.example.autogeneratorplus.generator.util.MapUtil;

import java.util.Map;

public class DataSourceConfigGenerator {

    public static void main(String[] args) throws Exception {
        DataSourceConfigConfig config = new DataSourceConfigConfig();
        String basePath = System.getProperty("user.dir");
        config.setBasePath(basePath);
        config.setParentPackage("com.example.autogeneratorplus");
        config.setModule("demo");

        //生成代码文件
        generate(config);

    }

    //生成数据源mybatis-plus配置
    public static void generate(DataSourceConfigConfig config) throws Exception {
        //读取模板文本
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/java/com/example/autogeneratorplus/generator/template/DataSourceConfig.tp";
        //写目标文件
        String dirPath = config.getBasePath() + "/src/main/java/"
                + config.getParentPath()+"/"+config.getModule()+"/config/";
        String fileName = "DataSourceConfig.java";

        Map<String, String> map = MapUtil.toMap(config);
        GeneratorUtil.generatorNewFile(filePath,map,dirPath,fileName);
    }


}
