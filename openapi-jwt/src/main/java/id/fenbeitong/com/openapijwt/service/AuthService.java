package id.fenbeitong.com.openapijwt.service;

import id.fenbeitong.com.openapijwt.entity.User;
import id.fenbeitong.com.openapijwt.vo.AuthParams;


/**
 * AuthService
 * <p>verify user auth
 *
 * @author Created by ivan on 上午11:55 18-11-8.
 * @version 1.0
 **/
public interface AuthService {

    /**
     * @param authParams :
     * @return id.fenbeitong.com.openapijwt.entity.User
     * @author Created by ivan on 上午11:56 18-11-8.
     * <p>auth User with parmas
     **/
    User authUser(AuthParams authParams);
}
