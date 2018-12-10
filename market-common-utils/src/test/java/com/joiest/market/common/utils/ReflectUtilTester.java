package com.joiest.market.common.utils;

import com.joiest.market.common.model.request.JdbcConnRequest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * 反射工具类测试类
 * @author admin 
 */
public class ReflectUtilTester {
    
    private Logger logger = LoggerFactory.getLogger(ReflectUtilTester.class);
    
    @Test
    public void test_getClassField(){
        Field[] fields = ReflectUtils.getClassField(JdbcConnRequest.class);
        for (Field field : fields){
            System.out.println(field.getName());
        }
    }
}
