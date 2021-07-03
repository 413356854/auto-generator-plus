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

    public static boolean writeFile(String filePath,List<String> lines){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter buffered = new BufferedWriter(writer);
            for (String line : lines) {
                buffered.write(line);
                buffered.newLine();
            }
            buffered.close();
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createFile(String dirPath,String fileName) throws IOException {
        File file = new File(dirPath);
        if(!file.exists()){
            file.mkdirs();
        }
        if (dirPath.lastIndexOf("/")!=dirPath.length()-1) {
            dirPath += "/";
        }
        file = new File(dirPath+fileName);
        if(!file.exists()){
            file.createNewFile();
            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + "/src/main/java/com/example/autogeneratorplus/generator/template/DataSourceConfig.tp";
        List<String> strings = readFile(filePath);
        String dirPath = basePath + "/src/main/java/com/example/autogeneratorplus/demo/test/";
        String fileName = "DataSourceConfig.java";
        createFile(dirPath, fileName);
        writeFile(dirPath+fileName,strings);



    }

}
