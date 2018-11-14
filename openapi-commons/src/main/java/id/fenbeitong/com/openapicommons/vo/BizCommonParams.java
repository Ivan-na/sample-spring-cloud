package id.fenbeitong.com.openapicommons.vo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * CommonParams
 * <p>
 * TODO
 *
 * @author Created by ivan on 下午5:13 18-11-12.
 * @version 1.0
 **/

public class BizCommonParams<T> extends CommonParams<T> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@SuppressWarnings("rawtypes")
	public static BizCommonParams fromJson(String json, Class clazz) {
		Gson gson = new Gson();
		Type objectType = type(BizCommonParams.class, clazz);
		return gson.fromJson(json, objectType);

	}

	@SuppressWarnings("rawtypes")
	public static BizCommonParams fromJsonWithLowerCase(String json, Class clazz) {
		Gson gson = new Gson();
		gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		Type objectType = type(BizCommonParams.class, clazz);
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

	public String toJson(Class<T> clazz) {
		Gson gson = new Gson();
		Type objectType = type(BizCommonParams.class, clazz);
		return gson.toJson(this, objectType);
	}

	public String toJsonWithLowerCase(Class<T> clazz) {
		Gson gson = new Gson();
		Type objectType = type(BizCommonParams.class, clazz);
		gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		return gson.toJson(this, objectType);
	}
}
