package com.example.autogeneratorplus.generator;

import com.example.autogeneratorplus.generator.model.InterfaceConfig;
import com.example.autogeneratorplus.generator.util.FileUtil;
import com.example.autogeneratorplus.generator.util.GeneratorUtil;
import com.example.autogeneratorplus.generator.util.MapUtil;
import com.example.autogeneratorplus.generator.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * 接口代码生成
 */
public class InterfaceGenerator {

    public static void main(String[] args) throws Exception {
        // 参数配置
        InterfaceConfig config = new InterfaceConfig();
        String basePath = System.getProperty("user.dir");
        config.setBasePath(basePath);
        config.setParentPackage("com.example.autogeneratorplus");
        config.setModule("demo");
        config.setEntityName("BaseAccount");

        //生成接口代码
        generateAdd(config);
    }

    private static void generateAdd(InterfaceConfig config) throws Exception {
        //参数
        Map<String, String> map = MapUtil.toMap(config);
        //读取entity参数复制到dto
        String entityFilePath = config.getBasePath() + "/src/main/java/"
                + config.getParentPath()+"/"+config.getModule()+"/entity/"
                + config.getEntityName() + ".java";
        readParamsToLine(entityFilePath, map);

        //读取dto模板文本
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/java/com/example/autogeneratorplus/generator/template/Dto.tp";
        //写目标文件
        String dirPath = config.getBasePath() + "/src/main/java/"
                + config.getParentPath()+"/"+config.getModule()+"/dto/";
        String fileName = config.getEntityName()+"Dto.java";
        //写Dto
        GeneratorUtil.generatorNewFile(filePath,map,dirPath,fileName);

        //添加controller代码
        String dtFilePath = basePath + "/src/main/java/com/example/autogeneratorplus/generator/template/ControllerAdd.tp";
        String cnFilePath = config.getBasePath() + "/src/main/java/"
                + config.getParentPath()+"/"+config.getModule()+"/controller/"
                + config.getEntityName()+"Controller.java";
        GeneratorUtil.generatorAddLine(dtFilePath,map,cnFilePath);
    }

    //读取entity，生成字段代码段
    public static void readParamsToLine(String entityFilePath, Map<String, String> map){
        StringBuilder importBuilder = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        List<String> strings = FileUtil.readFile(entityFilePath);
        String annoTemp,anno = null,parem;
        boolean hasBigDecimal=false,hasDate=false;
        for (String javaText : strings) {
            //     * 用户ID
            annoTemp = StringUtil.matcher("\\s+\\*\\s*(.{2,})\\s*", javaText);
            if (annoTemp!=null) {
                anno = annoTemp;
            }
            parem = StringUtil.matcher("\\s+(private\\s+\\w+\\s+\\w+)\\s*;\\s*", javaText);
            if (parem!=null
                    &&!parem.contains("createTime")
                    &&!parem.contains("updateTime")) {
                builder.append("\n    @ApiModelProperty(\"");
                builder.append(anno);
                builder.append("\")\n    ");
                builder.append(parem);
                builder.append(";\n");
                anno = null;

                if (parem.contains(" BigDecimal ")) {
                    hasBigDecimal = true;
                }
                if (parem.contains(" Date ")) {
                    hasDate = true;
                }
            }
        }
        map.put("dtoParamsLine",builder.toString());
        //引用
        if (hasBigDecimal) {
            importBuilder.append("\n");
            importBuilder.append("import java.math.BigDecimal;");
        }
        if (hasDate) {
            importBuilder.append("\n");
            importBuilder.append("import java.util.Date;");
        }
        map.put("import",importBuilder.toString());
    }

}
