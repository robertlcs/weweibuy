package com.weweibuy.support.service.impl;

import com.weweibuy.support.service.SmsCodeService;
import com.weweibuy.utils.CodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName SmsCodeServiceImpl
 * @Description
 * @Author durenhao
 * @Date 2019/1/19 22:13
 **/
@Slf4j
@Service
public class SmsCodeServiceImpl implements SmsCodeService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String KEY_PREFIX = "SMS:CODE:";

    private static final Integer CODE_LENGTH = 6;

    @Override
    public void sendSmsCode(String mobile) {
        redisTemplate.opsForValue().set(KEY_PREFIX + mobile, CodeUtils.getSmsCode(CODE_LENGTH));
    }

    @Override
    public String getSmsCode(String mobile) {
        return redisTemplate.opsForValue().get(KEY_PREFIX + mobile);
    }
}
