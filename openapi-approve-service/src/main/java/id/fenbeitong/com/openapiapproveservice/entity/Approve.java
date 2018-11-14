package id.fenbeitong.com.openapiapproveservice.entity;

import id.fenbeitong.com.openapicommons.entity.BizCommonEntity;

/**
 * Approve
 * <p> TODO
 *
 * @version 1.0
 * Created by ivan on 18-11-14 - 下午5:45.
 **/
public class Approve extends BizCommonEntity<Approve> {
    private String id;

    public Approve() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
