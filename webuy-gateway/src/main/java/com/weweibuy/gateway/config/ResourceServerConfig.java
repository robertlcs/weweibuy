package com.weweibuy.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器配置，这里zuul代理了所有资源服务
 * @ClassName ResourceServerConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/5 22:02
 **/
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    /**
     * TODO这里的http  不能使用WebSecurityConfigurerAdapter的http配置; 必须这在配
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() /* .antMatchers().hasAnyRole("ADMIN") */
            .antMatchers("/auth/**","/*/hello", "*.css", "*.js", "*.fonts")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and().
                csrf().disable()
                //Spring Security默认将header response里的X-Frame-Options属性设置为DENY。
                //页面里有需要通过iframe/frame引用的页面，需要配置Spring Security允许iframe frame加载同源的资源，方法为在Spring Security的配置类里将header response的X-Frame-Options属性设置为SAMEORIGIN
                .headers().frameOptions().sameOrigin(); //

    }


}
