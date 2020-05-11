package com.itheima.code.builds;

import java.util.Map;

public class ServiceBuilder {


    /***
     * 构建Service
     * @param modelMap
     */
    public static void builder(Map<String, Object> modelMap) {
        //生成Service层文件
        BuilderFactory.builder(modelMap,
                "/template/service",
                "Service.java",
                TemplateBuilder.PACKAGE_SERVICE_INTERFACE,
                "Service.java");
    }

}
