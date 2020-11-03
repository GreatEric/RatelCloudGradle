package com.ratel.common.core.utils;

import com.google.gson.Gson;
import com.ratel.common.core.properties.DebuggerProperties;
import org.springframework.stereotype.Component;

@Component
public class Debugger {
    /*private static DebuggerProperties properties;

    private static Debugger instance = new Debugger();

    private Debugger(){}

    public static Debugger getInstance(DebuggerProperties properties){
        Debugger.properties = properties;
        return instance;
    }*/

    public static void printJson(String name,Object o){
        Gson gson = new Gson();
        String json = gson.toJson(o);

        /*if(properties.getShowPrint()) {

        }*/

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
    public static void sysprint(String name, String value){
        /*if(properties.getShowPrint()) {

        }*/

        System.out.println("******************************************************************************************************************************************");
        System.out.println(name +" : "+ value);
        System.out.println("******************************************************************************************************************************************");
    }
}
