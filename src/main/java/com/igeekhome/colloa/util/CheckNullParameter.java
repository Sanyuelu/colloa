package com.igeekhome.colloa.util;

public class CheckNullParameter {
    /**
     * 检查是否有参数为 null
     * @param parameters
     * @return
     */
    public static boolean haveNullParameter(Object... parameters){
        for (Object object : parameters){
            if (object == null){
                return true;
            }
        }
        return false;
    }
}
