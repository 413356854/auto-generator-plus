package com.example.autogeneratorplus.generator;

import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.example.autogeneratorplus.demo.entity.BaseAccount;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 接口代码生成
 */
public class InterfaceGenerator {

    public static void main(String[] args) {
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.autogeneratorplus.demo");
        Class objClass = BaseAccount.class;
        //接口生成
        createList(pc,objClass);
    }

    private static void createList(PackageConfig pc,Class objClass){
        //根目录
        String projectPath = System.getProperty("user.dir");
        //模块路径
        String parentPath = "/src/main/java/"+pc.getParent().replace(".", "/");
        //dto文件路径
        String dtoPath = projectPath + parentPath + "/dto";
        //创建dto文件
        createFile(dtoPath,objClass.getSimpleName() + "Dto.java");

        System.out.println(dtoPath);
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            //过滤static修饰
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

    }

    public static boolean createFile(String path,String fileName){
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(path+"/"+fileName);
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
