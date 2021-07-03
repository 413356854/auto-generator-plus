package com.example.autogeneratorplus.generator.model;

import lombok.Data;

@Data
public class SuperConfig {
    //src的父目录 C:\\user\\git-auto
    private String basePath;
    //模块的父包名 com.example.autogeneratorplus
    private String parentPackage;
    //模块父包名的路径
    private String parentPath;
    //模块名 demo
    private String module;

    //父目录：parentPackage.replace(".","/")
    private void setParentPath(String parentPath){
        this.parentPath = parentPath;
    }

    public void setParentPackage(String parentPackage) {
        this.parentPackage = parentPackage;
        if(parentPackage!=null){
            this.setParentPath(parentPackage.replace(".","/"));
        }else{
            this.setParentPath(null);
        }
    }


}
