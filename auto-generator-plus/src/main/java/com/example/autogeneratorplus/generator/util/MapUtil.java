package com.example.autogeneratorplus.generator.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lujf
 * @date: 2021/7/2 14:29
 */
public class MapUtil {

    public static Map<String,String> toMap(Object obj) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        Class aClass = obj.getClass();
        Field[] declaredFields;
        Object valueObj;
        while (aClass!=null) {
            declaredFields = aClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                valueObj = declaredField.get(obj);
                if (valueObj != null) {
                    map.put(declaredField.getName(), valueObj.toString());
                }
            }
            aClass = aClass.getSuperclass();
        }
        return map;
    }


}


