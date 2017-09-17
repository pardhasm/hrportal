package com.hrportal.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


public class JsonUtils {

    private static final Logger logger = Logger.getLogger(JsonUtils.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String serializeObject(Object object) throws IOException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    public static <T> T readObject(String source, Class<T> objectClass) {
        T result = null;
        try {
            result = OBJECT_MAPPER.readValue(source, objectClass);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public static <T> List<T> readObjectList(String json, Class<T> objectClass) {
        List<T> result = null;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(json)) {
            try {
                JavaType javaType = TypeFactory.defaultInstance().constructArrayType(objectClass);
                result = OBJECT_MAPPER.readValue(json, javaType);
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        } else {
            result = Collections.emptyList();
        }

        return result;
    }

    public static boolean isJSONValid(String source) {
        try {
            OBJECT_MAPPER.readValue(source, Object.class);
            return true;
        } catch (IOException e) {
            return false;
        }

    }

}