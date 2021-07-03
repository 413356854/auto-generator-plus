package com.example.autogeneratorplus.generator;

import com.example.autogeneratorplus.generator.model.DataSourceConfigConfig;
import com.example.autogeneratorplus.generator.util.FileUtil;
import com.example.autogeneratorplus.generator.util.MapUtil;
import com.example.autogeneratorplus.generator.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
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
        List<String> lines = FileUtil.readFile(filePath);
        //替换模板参数
        Map<String, String> map = MapUtil.toMap(config);
        List<String> codes = new ArrayList<>(lines.size());
        for (String line : lines) {
            line = StringUtil.tpTextReplace(line, map);
            codes.add(line);
        }
        //写目标文件
        String dirPath = config.getBasePath() + "/src/main/java/"
                + config.getParentPath()+"/"+config.getModule()+"/config/";
        String fileName = "DataSourceConfig.java";
        FileUtil.createFile(dirPath, fileName);
        FileUtil.writeFile(dirPath+fileName,codes);
    }


}
