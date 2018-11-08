package id.fenbeitong.com.openapijwt.service.impl;

import id.fenbeitong.com.openapijwt.entity.User;
import id.fenbeitong.com.openapijwt.service.AuthService;
import id.fenbeitong.com.openapijwt.vo.AuthParams;
import org.springframework.stereotype.Service;

/**
 * AuthServiceImpl
 * <p>Service Implementation
 *
 * @author Created by ivan on 上午11:56 18-11-8.
 * @version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    /**
     * @return id.fenbeitong.com.openapijwt.entity.User
     * @author Created by ivan on 下午2:42 18-11-8.
     * @see id.fenbeitong.com.openapijwt.service.AuthService
     **/
    @Override
    public User authUser(AuthParams authParams) {
        //TODO 数据库校验，远端校验,异常处理
        return new User(999L);
    }
}
