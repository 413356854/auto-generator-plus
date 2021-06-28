package com.example.autogeneratorplus.generator.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String filePath){
        try {
            List<String> list = new ArrayList<>();
            FileReader reader = new FileReader(filePath);
            BufferedReader buffered = new BufferedReader(reader);
            String line;
            while ((line=buffered.readLine())!=null) {
                list.add(line);
            }
            buffered.close();
            reader.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(String filePath,List<String> lines){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter buffered = new BufferedWriter(writer);
            for (String line : lines) {
                buffered.write(line);
                buffered.newLine();
            }
            buffered.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/java/com/example/autogeneratorplus/generator/template/DataSourceConfig.tp";
        List<String> strings = readFile(filePath);
        filePath = basePath + "/src/main/java/com/example/autogeneratorplus/demo/test/";
        String fileName = "DataSourceConfig.java";
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        file = new File(filePath+fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        writeFile(filePath+fileName,strings);


    }

}
