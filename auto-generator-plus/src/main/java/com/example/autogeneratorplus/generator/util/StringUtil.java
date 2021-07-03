package com.example.autogeneratorplus.generator.util;

import java.util.Map;

public class StringUtil {


    //从map取value替换文本{{key}}
    public static String tpTextReplace(String ptString, Map<String,String> map) {
        String key,value;
        int start,end;
        while (true) {
            start = ptString.indexOf("{{");
            if (start == -1) {
                break;
            }
            end = ptString.indexOf("}}");
            if (end == -1) {
                throw new RuntimeException("格式有误：}}缺失");
            }
            key = ptString.substring(start+2, end);
            value = map.get(key);
            if (value == null) {
                break;
            }
            ptString = ptString.replace("{{"+key+"}}",value);
        }
        return ptString;
    }


}
