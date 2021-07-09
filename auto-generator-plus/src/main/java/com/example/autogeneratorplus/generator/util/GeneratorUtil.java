package com.example.autogeneratorplus.generator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 工程工具类：共性操作、通用业务
 */
public class GeneratorUtil {

    /**
     * 读取模板替换配置参数，生成新代码文件
     * @param tpfilePath 模板文件路径
     * @param map 模板配置参数 MapUtil.toMap(config)
     * @param dirPath 生成文件路径
     * @param fileName 生成文件名
     * @throws Exception
     */
    public static void generatorNewFile(String tpfilePath,Map<String, String> map,String dirPath,String fileName) throws Exception {
        //读取模板文本
        List<String> lines = FileUtil.readFile(tpfilePath);
        //替换模板参数
        List<String> codes = new ArrayList<>(lines.size());
        for (String line : lines) {
            line = StringUtil.tpTextReplace(line, map);
            codes.add(line);
        }
        //写目标文件
        boolean flag = FileUtil.createFile(dirPath, fileName);
        if (flag) {
            FileUtil.writeFile(dirPath+fileName,codes);
        } else {
            System.out.println("文件已存在：\n" + dirPath + fileName);
        }
    }


    public static void generatorAddLine(String tpfilePath,Map<String, String> map,String filePath) throws Exception {
        //读取模板文本
        List<String> lines = FileUtil.readFile(tpfilePath);
        //替换模板参数
        StringBuilder builder = new StringBuilder("\n");
        for (String line : lines) {
            line = StringUtil.tpTextReplace(line, map);
            builder.append(line);
            builder.append("\n");
        }
        //定位最后的}位置
        List<String> codes = FileUtil.readFile(filePath);
        for (int i = codes.size()-1; i > 0; i--) {
            String code = codes.get(i);
            if(code.contains("}")){
                int index = code.lastIndexOf("}");
                code = code.substring(0, index) + builder.toString() + code.substring(index);
                codes.set(i, code);
                break;
            }
        }
        FileUtil.writeFile(filePath,codes);
    }
    
}
