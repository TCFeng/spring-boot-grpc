package com.tcfeng.starter.app.utils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ObjectMapperUtils {
   
    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        // 有對應不到的 properties 也不失敗
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Ignore Null Fields
        mapper.setSerializationInclusion(Include.NON_NULL);
        mapper.setSerializationInclusion(Include.NON_EMPTY);
        return mapper;
    }

    /**
     * Convert object to specific Class
     */
    public static <T> T convertObjectToClass(Object obj, Class<? extends T> clazz) {
        if (obj == null) {
            log.warn("convertObjectToClass object is null, ckazz:{}", clazz);
            return null;
        }
        ObjectMapper mapper = getMapper();
        try {
            return (T) mapper.convertValue(obj, clazz);
        } catch (Exception e) {
            log.error("convertObjectToClass:{} Exception:{}", obj, e);
        }
        return null;
    }

    /**
     * convert Object To ClassList
     */
    public static <T> List<T> convertObjectToClassList(Object obj, Class<? extends T> clazz) {
        if (obj == null) {
            log.warn("convertObjectToClassList object is null, ckazz:{}", clazz);
            return new ArrayList<>();
        }
        ObjectMapper mapper = getMapper();
        try {
            return mapper.convertValue(obj, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            log.error("convertObjectToClassList:{} Exception:{}", obj, e);
        }
        return new ArrayList<>();
    }
}
