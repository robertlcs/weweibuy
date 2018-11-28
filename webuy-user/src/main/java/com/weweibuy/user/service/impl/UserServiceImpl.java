package com.weweibuy.user.service.impl;

import com.weweibuy.dto.WebResult;
import com.weweibuy.user.service.UserService;
import com.weweibuy.user.utils.VerificationCodeUtil;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:07
 **/
@Service
public class UserServiceImpl implements UserService {

    public WebResult sendVerificationCode(String phoneNum) {
        if(VerificationCodeUtil.canSendPhoneVerifyCode(phoneNum)){
            VerificationCodeUtil.sendVerificationCode(phoneNum);
            return WebResult.success("已发送");
        }
        return WebResult.fail("请稍后再试");
    }

    @Override
    public WebResult registerUser(String phone, String pwd) {
        // TODO 注册用户
        return null;
    }
}
