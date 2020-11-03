package com.ratel.codegenerator.utils;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class Debugger {

    public static void printJson(String name, Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        System.out.println("******************************************************************************************************************************************");
        System.out.println(name + " : " + json);
        System.out.println("******************************************************************************************************************************************");
    }

    /**
     * description:
     * 打印键值对
     *
     * @param:
     * @return:
     */
    public static void sysprint(String name, String value) {
        System.out.println("******************************************************************************************************************************************");
        System.out.println(name + " : " + value);
        System.out.println("******************************************************************************************************************************************");
    }
}
