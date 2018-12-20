package com.joiest.market.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 将json字符串数组转换成List集合
     * @param str 要转换的json字符串数组
     * @param clazz 要转换的目标List集合泛型类
     * @param <T> 泛型
     * @return
     */
    public static <T> List<T> jsonStrToList(String str,Class<T> clazz){
        return (List<T>)JSONArray.parseArray(str,clazz);
    }
    
    /**
     * 将xml转换成json的方法
     * @param xml 要转换成的xml字符串
     * @return
     * @throws DocumentException
     */
    public static JSONObject xmlToJson(String xml) throws DocumentException {
        JSONObject jsonObject = new JSONObject();
        Document document = DocumentHelper.parseText(xml);
        Element rootElement = document.getRootElement();
        iterator(rootElement,jsonObject);
        return jsonObject;
    }

    /**
     * 递归调用遍历xml文件中的元素节点
     * @param rootElement
     * @param jsonObject
     */
    private static void iterator(Element rootElement, JSONObject jsonObject) {
        // 1.首先获取根节点的名称
        String nodeName = rootElement.getName();
        // 2.判断已遍历的JsonObject中是否已经有了该元素的名称
        if(jsonObject.containsKey(nodeName)){
            // 2.1 判断在某一元素在同级下是否有多个
            Object Object = jsonObject.get(nodeName);
            JSONArray jsonArray = null;
            if(Object instanceof JSONArray){
                jsonArray = (JSONArray) Object;
            }else{
                jsonArray = new JSONArray();
                jsonArray.add(Object);
            }
            // 2.2 获取根元素下所有子元素
            List<Element> listElement = rootElement.elements();
            // 2.3 若该元素无子元素，则获取该元素的值
            if(listElement.isEmpty()){
                String nodeValue = rootElement.getTextTrim();
                jsonArray.add(nodeValue);
                jsonObject.put(nodeName, jsonArray);
                return;
                // 2.4 若该元素有子元素，则获取该元素的值
            }else{
                JSONObject newJson = new JSONObject();
                // 2.4.1 遍历所有子元素，然后递归调用
                for (Element element:listElement) {
                    iterator(element,newJson);
                }
                jsonArray.add(newJson);
                jsonObject.put(nodeName,jsonArray);
                return;
            }
        }else{
            // 3.该元素同级下第一次遍历,获取该元素下所有子元素
            List<Element> elementList = rootElement.elements();
            if(elementList.isEmpty()){
                // 3.1 该元素无子元素，获取元素的值
                String nodeValue = rootElement.getTextTrim();
                jsonObject.put(nodeName,nodeValue);
                return;
            }else{
                // 3.2 该元素有子元素，新建一个JSONObject来存储该节点下子节点的值
                JSONObject jsonObjectInstance = new JSONObject();
                // 3.3 遍历所有一级子节点
                for (Element e:elementList) {
                    iterator(e,jsonObjectInstance);
                }
                jsonObject.put(nodeName,jsonObjectInstance);
                return;
            }
        }
    }

    /**
     * 将json转换成xml字符串的方法
     * @param json
     */
    public static String jsonToXml(String json){
        // TODO 将json转换成xml的方法，含层次结构
        String xml = "";
        if(StringUtils.isBlank(json)){
            return null;
        }
        return xml;
    }
}
