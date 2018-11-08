package id.fenbeitong.com.openapijwt.entity;


import id.fenbeitong.com.openapicommons.entity.CommonEntity;

/**
 * User
 * <p>User Object
 *
 * @author Created by ivan on 上午11:54 18-11-8.
 * @version 1.0
 **/
public class User extends CommonEntity {
    // Use for JWT compact
    private Long id;

    // Constructor
    private User() {
    }

    public User(Long id) {
        this.id = id;
    }

    // Getter/Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


