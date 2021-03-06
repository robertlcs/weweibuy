package com.weweibuy.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @ClassName WebSecurityConfig
 * @Description
 * @Author durenhao
 * @Date 2019/1/21 23:28
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl("/");

        http.authorizeRequests()
                .antMatchers( "/assets/**").permitAll()
                .antMatchers( "/login",
                        "/instances/**",
                        "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage( "/login").successHandler(successHandler).and()
                .logout().logoutUrl( "/logout").and()
                .httpBasic().disable()
                .csrf().disable();
    }

}
