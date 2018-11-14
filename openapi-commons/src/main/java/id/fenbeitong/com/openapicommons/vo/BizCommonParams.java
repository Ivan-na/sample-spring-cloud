package id.fenbeitong.com.openapicommons.vo;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * CommonParams
 * <p>TODO
 *
 * @author Created by ivan on 下午5:13 18-11-12.
 * @version 1.0
 **/
public class BizCommonParams<T> extends CommonParams<T> implements java.io.Serializable {
    private ObjectNode data;

    public ObjectNode getData() {
        return data;
    }

    public void setData(ObjectNode data) {
        this.data = data;
    }
}
