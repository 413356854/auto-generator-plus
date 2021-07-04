package com.example.autogeneratorplus.generator.util;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassUtil {

    public static void main(String[] args) throws Exception {
        String javaPath = "C:\\Users\\Documents\\Dto.java";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int run = compiler.run(null, null, null, javaPath);
        if (run!=0) {
            System.out.println("编译失败："+javaPath);
            return;
        }
        String classPath = javaPath.substring(0,javaPath.lastIndexOf("java"))+"class";
        System.out.println(classPath);
        File file = new File(classPath);
        if (file.exists()) {
            System.out.println("exists :"+file.toURI().toURL().toString());
        }
        URL[] urls = {file.toURI().toURL()};

        URLClassLoader loader = new URLClassLoader(urls);
        Class clazz = loader.loadClass("com.example.autogeneratorplus.generator.demo.entity.User");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
//        file.deleteOnExit();
    }
}
