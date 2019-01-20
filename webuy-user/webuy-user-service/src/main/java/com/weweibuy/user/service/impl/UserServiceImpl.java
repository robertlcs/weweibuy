package com.weweibuy.user.service.impl;

import com.weweibuy.user.common.eum.UserWebMsgEum;
import com.weweibuy.user.common.model.dto.UserWebResult;
import com.weweibuy.user.common.model.po.WebuyUser;
import com.weweibuy.user.common.model.po.WebuyUserExample;
import com.weweibuy.user.mapper.WebuyUserMapper;
import com.weweibuy.user.service.UserService;
import com.weweibuy.user.service.impl.base.BaseCrudServiceImpl;
import com.weweibuy.user.utils.CodeUtil;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2018/11/25 17:07
 **/
@Service
public class UserServiceImpl extends BaseCrudServiceImpl<WebuyUser, WebuyUserExample> implements UserService {

    @Autowired
    private AsyncRabbitTemplate rabbitTemplate;

    @Autowired
    private WebuyUserMapper userMapper;

    public UserWebResult sendVerificationCode(String phoneNum) {
        rabbitTemplate.convertSendAndReceive("user_sms_code", "", phoneNum);
        return UserWebResult.success();
    }

    @Override
    public UserWebResult registerUser(String phone, String pwd) {
        WebuyUser user = new WebuyUser();
        user.setUsername(phone);
        user.setPhone(phone);
        user.setPassword(CodeUtil.getStrMD5(pwd));
        int i = userMapper.insertSelective(user);
        if(i > 0){
            return UserWebResult.success();
        }
        return UserWebResult.fail(UserWebMsgEum.DO_NOT_RESUBMIT);
    }

    /**
     * 验证账号是否存在
     * @param phoneNum 手机号
     * @return
     */
    @Override
    public UserWebResult checkAccountExist(String phoneNum) {
        WebuyUserExample example = new WebuyUserExample();
        example.createCriteria().andPhoneEqualTo(phoneNum);
        List<WebuyUser> userList = userMapper.selectByExample(example);
        if(userList == null || userList.size() > 0){
            return UserWebResult.fail();
        }
        return UserWebResult.success();
    }

    @Override
    public UserWebResult loadUserByUsername(String username) throws Exception {
        WebuyUserExample example = new WebuyUserExample();
        WebuyUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<WebuyUser> webuyUsers = userMapper.selectByExample(example);
        if(webuyUsers == null || webuyUsers.size() == 0){
            return UserWebResult.fail(UserWebMsgEum.USER_INFO_NOT_EXIST);
        }
        WebuyUser webuyUser = webuyUsers.get(0);
        return UserWebResult.success(webuyUser);
    }
}
