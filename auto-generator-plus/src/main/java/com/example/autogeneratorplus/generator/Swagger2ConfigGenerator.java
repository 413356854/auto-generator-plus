package com.example.autogeneratorplus.generator;

import com.example.autogeneratorplus.generator.model.Swagger2ConfigConfig;
import com.example.autogeneratorplus.generator.util.GeneratorUtil;

public class Swagger2ConfigGenerator {

    public static void main(String[] args) throws Exception {
        Swagger2ConfigConfig config = new Swagger2ConfigConfig();
        String basePath = System.getProperty("user.dir");
        config.setBasePath(basePath);
        config.setParentPackage("com.example.autogeneratorplus");
        config.setModule("demo");

        //生成代码文件
        generate(config);

    }

    //生成数据源mybatis-plus配置
    public static void generate(Swagger2ConfigConfig config) throws Exception {
        //读取模板文本
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/java/com/example/autogeneratorplus/generator/template/Swagger2Config.tp";
        //写目标文件
        String dirPath = config.getBasePath() + "/src/main/java/"
                + config.getParentPath()+"/"+config.getModule()+"/config/";
        String fileName = "Swagger2Config.java";

        GeneratorUtil.generatorNewFile(filePath,config,dirPath,fileName);
    }


}
