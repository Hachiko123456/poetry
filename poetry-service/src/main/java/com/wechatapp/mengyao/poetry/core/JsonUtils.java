package com.wechatapp.mengyao.poetry.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author yanghuaxu
 * @date 2025/5/11 21:40
 */
@Slf4j
public class JsonUtils {


    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 基础配置
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略未知字段
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);         // 空对象不序列化
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));          // 统一日期格式
        objectMapper.registerModule(new JavaTimeModule());                                 // 支持 Java8 时间类型
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);                           // 美化输出（可选）
    }

    /**
     * 对象转 JSON 字符串
     *
     * @param obj 任意对象
     * @return JSON 字符串
     */
    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("对象转JSON失败: {}", e.getMessage());
            throw new RuntimeException("JSON转换异常", e);
        }
    }

    /**
     * JSON 字符串转对象
     *
     * @param jsonStr JSON 字符串
     * @param clazz   目标对象类型
     * @return 目标对象
     */
    public static <T> T parseObject(String jsonStr, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            log.error("JSON转对象失败: {}", e.getMessage());
            throw new RuntimeException("JSON转换异常", e);
        }
    }

    /**
     * JSON 字符串转泛型对象列表 (如 List<User>)
     *
     * @param jsonStr JSON 字符串
     * @param typeRef 类型引用 (如 new TypeReference<List<User>>() {})
     * @return 目标对象列表
     */
    public static <T> T parseList(String jsonStr, TypeReference<T> typeRef) {
        try {
            return objectMapper.readValue(jsonStr, typeRef);
        } catch (IOException e) {
            log.error("JSON转列表失败: {}", e.getMessage());
            throw new RuntimeException("JSON转换异常", e);
        }
    }

    /**
     * JSON 字符串转 Map
     *
     * @param jsonStr JSON 字符串
     * @return Map<String, Object>
     */
    public static Map<String, Object> parseMap(String jsonStr) {
        try {
            return objectMapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            log.error("JSON转Map失败: {}", e.getMessage());
            throw new RuntimeException("JSON转换异常", e);
        }
    }

    /**
     * 格式化 JSON 字符串（美化输出）
     *
     * @param jsonStr 原始JSON字符串
     * @return 格式化后的JSON字符串
     */
    public static String formatJson(String jsonStr) {
        try {
            Object obj = objectMapper.readValue(jsonStr, Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            log.error("JSON格式化失败: {}", e.getMessage());
            return jsonStr; // 原样返回
        }
    }

}
