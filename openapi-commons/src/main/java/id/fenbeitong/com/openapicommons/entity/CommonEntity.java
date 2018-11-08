package id.fenbeitong.com.openapicommons.entity;

import id.fenbeitong.com.openapicommons.utils.LogUtils;
import org.slf4j.Logger;

import java.lang.reflect.ParameterizedType;

/**
 * CommonEntity
 * <p>General Entity, used for globe properties etc.
 *
 * @author Created by ivan on 上午11:35 18-11-8.
 * @version 1.0
 **/
public abstract class CommonEntity<T> {

    protected final Logger LOGGER = LogUtils.get(this.getRuntimeClass());

    /**
     * @return java.lang.Class
     * @author Created by ivan on 上午11:39 18-11-8.
     * <p>Locate runtime Class Type
     **/
    @SuppressWarnings("unchecked")
    private Class getRuntimeClass() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        return (Class<T>) pt.getActualTypeArguments()[0];
    }

}
