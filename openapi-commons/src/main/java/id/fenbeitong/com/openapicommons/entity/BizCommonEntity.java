package id.fenbeitong.com.openapicommons.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * CommonEntity
 * <p>General Entity, used for globe properties etc.
 *
 * @author Created by ivan on 上午11:35 18-11-8.
 * @version 1.0
 **/
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BizCommonEntity<T> extends CommonEntity<T> implements java.io.Serializable {
    private String requestId;
    private String code;
    private String msg;
    private T data;

    @SuppressWarnings("rawtypes")
    public static BizCommonEntity fromJson(String json, Class clazz) {
        Gson gson = new Gson();
        Type objectType = type(BizCommonEntity.class, clazz);
        return gson.fromJson(json, objectType);

    }

    public static BizCommonEntity fromJsonWithLowerCase(String json, Class clazz) {
        Gson gson = new Gson();
        gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        Type objectType = type(BizCommonEntity.class, clazz);
        return gson.fromJson(json, objectType);

    }

    @SuppressWarnings("rawtypes")
    static ParameterizedType type(final Class raw, final Type... args) {
        return new ParameterizedType() {
            public Type getRawType() {
                return raw;
            }

            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toJson(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(BizCommonEntity.class, clazz);
        return gson.toJson(this, objectType);
    }

    public String toJsonWithLowerCase(Class<T> clazz) {
        Gson gson = new Gson();
        Type objectType = type(BizCommonEntity.class, clazz);
        gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        return gson.toJson(this, objectType);
    }
}
