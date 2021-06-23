package com.example.autogeneratorplus.generator;

import com.example.autogeneratorplus.demo.entity.User;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 接口代码生成
 */
public class InterfaceGenerator {

    public static void createDto(){
        
    }


    public static void main(String[] args) {
        Class objClass = User.class;
        Field[] fields = objClass.getDeclaredFields();
//        Field[] fields = objClass.getFields();
        for (Field field : fields) {
            //过滤static修饰
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            System.out.println(field.getName());
        }
    }
}
