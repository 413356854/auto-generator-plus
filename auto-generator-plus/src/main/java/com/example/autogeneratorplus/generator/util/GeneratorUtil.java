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
     * @param config 模板配置参数
     * @param dirPath 生成文件路径
     * @param fileName 生成文件名
     * @throws Exception
     */
    public static void generatorNewFile(String tpfilePath,Object config,String dirPath,String fileName) throws Exception {
        //读取模板文本
        List<String> lines = FileUtil.readFile(tpfilePath);
        //替换模板参数
        Map<String, String> map = MapUtil.toMap(config);
        List<String> codes = new ArrayList<>(lines.size());
        for (String line : lines) {
            line = StringUtil.tpTextReplace(line, map);
            codes.add(line);
        }
        //写目标文件
        boolean flag = FileUtil.createFile(dirPath, fileName);
        if (!flag) {
            System.out.println("文件已存在：\n"+dirPath+fileName);
        }
        FileUtil.writeFile(dirPath+fileName,codes);
    }


    public static void main(String[] args) {
        String filePath = "C:\\Users\\ljf\\Documents\\git-exworth_chainwallet\\chainwallet\\wallet_chainwallet\\chainwallet\\provider\\executor\\src\\main\\java\\com\\chain\\chainwallet\\entity\\RechargeWallet.java";
        List<String> strings = FileUtil.readFile(filePath);

        String className = null;
        for (String javaText : strings) {
            className = StringUtil.matcher(".*class\\s+(\\w+)[\\s+extends.*|\\s+implements.*|\\s*\\{]", javaText);
            if (className!=null) {
                break;
            }
        }
        System.out.println(className);
        String annoTemp,anno = null,parem;
        for (String javaText : strings) {//     * 平台表ID
            annoTemp = StringUtil.matcher("\\s+\\*\\s*(.{2,})\\s*", javaText);
            if (annoTemp!=null) {
                anno = annoTemp;
            }
            parem = StringUtil.matcher("\\s+(private\\s+\\w+\\s+\\w+)\\s*;\\s*", javaText);
            if (parem!=null) {
                System.out.println(anno);
                System.out.println(parem);
                anno = null;
            }
        }
    }
    
}
