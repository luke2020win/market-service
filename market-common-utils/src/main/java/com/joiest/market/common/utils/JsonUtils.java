package com.joiest.market.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * json工具类
 * @author zhouchaowei
 */
public class JsonUtils {
    
    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    
    private static final ObjectMapper objectMapper;
    
    static {
        objectMapper = new ObjectMapper();
        objectMapperConfiguration();
    }

    /**
     * 配置objectMapper的一些参数
     */
    private static void objectMapperConfiguration() {
        // 去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        // 空值不序列化
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        // 序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 将异常以json并base64的方式返回
     * @param exceptionCode
     * @param exceptionInfo
     * @param data
     * @param <T>
     * @return
     */
    public static<T> String toJsonBase64(String exceptionCode, String exceptionInfo, T data){
        Map<String ,Object> responseMap = new HashMap<>(3);
        responseMap.put("code",exceptionCode);
        responseMap.put("info",exceptionInfo);
        if(data != null){
            responseMap.put("data",data);
        }
        return Base64CustomUtils.base64Encoder(toJson(responseMap)).replaceAll("\r","").replaceAll("\n","");
    }

    /**
     * 将map转换为json的方法
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> String toJson(T entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
