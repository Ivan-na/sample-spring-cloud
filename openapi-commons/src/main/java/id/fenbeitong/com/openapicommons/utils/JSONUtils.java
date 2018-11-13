package id.fenbeitong.com.openapicommons.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * JSONUtils
 * <p> json util
 *
 * @author Created by ivan on 下午4:14 18-11-8.
 * @version 1.0
 **/
public class JSONUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static String toString(Object obj) {
        return toJson(obj);
    }

    public static String toJson(Object obj) {
        try {
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, obj);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("序列化对象【" + obj + "】时出错", e);
        }
    }

    public static <T> T toBean(Class<T> entityClass, String jsonString) {
        try {
            return mapper.readValue(jsonString, entityClass);
        } catch (Exception e) {
            throw new RuntimeException("JSON【" + jsonString + "】转对象时出错", e);
        }
    }

    public static <T> T toList(String jsonString) {
        try {
            return mapper.readValue(jsonString, new TypeReference<List>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("JSON【" + jsonString + "】转列表时出错", e);
        }
    }

    public static <T> T toBeanList(Class<T> entityClass, String jsonString) {
        try {
            mapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, entityClass));
        } catch (Exception e) {
            throw new RuntimeException("JSON【" + jsonString + "】转对象列表时出错", e);
        }
    }

    /**
     * 用于对象通过其他工具已转为JSON的字符形式，这里不需要再加上引号
     *
     * @param obj
     * @param isObject
     */
    public static String getJsonSuccess(String obj, boolean isObject) {
        String jsonString = null;
        if (obj == null) {
            jsonString = "{\"success\":true}";
        } else {
            jsonString = "{\"success\":true,\"data\":" + obj + "}";
        }
        return jsonString;
    }

    public static String getJsonSuccess(Object obj) {
        return getJsonSuccess(obj, null);
    }

    public static String getJsonSuccess(Object obj, String message) {
        if (obj == null) {
            return "{\"success\":true,\"message\":\"" + message + "\"}";
        } else {
            try {
                return "{\"success\":true," + toString(obj) + ",\"message\":\"" + message + "\"}";
            } catch (Exception e) {
                throw new RuntimeException("序列化对象【" + obj + "】时出错", e);
            }
        }
    }

    public static String getJsonError(Object obj) {
        return getJsonError(obj, null);
    }

    public static String getJsonError(Object obj, String message) {
        if (obj == null) {
            return "{\"success\":false,\"message\":\"" + message + "\"}";
        } else {
            try {
                obj = parseIfException(obj);
                return "{\"success\":false,\"data\":" + toString(obj) + ",\"message\":\"" + message + "\"}";
            } catch (Exception e) {
                throw new RuntimeException("序列化对象【" + obj + "】时出错", e);
            }
        }
    }

    public static Object parseIfException(Object obj) {
        if (obj instanceof Exception) {
            return getErrorMessage((Exception) obj, null);
        }
        return obj;
    }

    public static String getErrorMessage(Exception e, String defaultMessage) {
        return defaultMessage != null ? defaultMessage : null;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }
}
