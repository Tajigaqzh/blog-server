package com.hp.blogserver.utils;

/**
 * @Author 20126
 * @Description
 * @Date 2023/11/5 17:31
 * @Version 1.0
 */
public class HpTools {
    public static boolean contains(String str,String ...args){
        for (String arg : args) {
            if(str.contains(arg)){
                return true;
            }
        }
        return false;
    }

}
