package com.joiest.market.common.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 * @author admin 
 */
public class ReflectUtils {

    /**
     * 获取一个类的所有get方法
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> List<Method> getMethodNameOfGet(T tClass){
        Field[] fields = tClass.getClass().getDeclaredFields();
        PropertyDescriptor propertyDescriptor = null;
        List<Method> methodList = new ArrayList<>();
        try {
            for(Field field : fields){
                propertyDescriptor = new PropertyDescriptor(field.getName(),tClass.getClass());
                methodList.add(propertyDescriptor.getReadMethod());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return methodList;
    }

    /**
     * 获取类的所有属性
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Field [] getClassField(Class<T> clazz) {
        return clazz.getDeclaredFields();
    }
}
