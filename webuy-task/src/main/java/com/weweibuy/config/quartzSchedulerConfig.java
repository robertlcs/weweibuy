package com.weweibuy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.weweibuy.core.schedule.XxlJobDynamicScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName quartzSchedulerConfig
 * @Description
 * @Author durenhao
 * @Date 2018/10/16 22:43
 **/
@Configuration
public class quartzSchedulerConfig {

    private PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer propertyConfigurer = new PropertyPlaceholderConfigurer();
        propertyConfigurer.setFileEncoding("utf-8");
        Resource resource = resolver.getResource("classpath*:config/xxl-admin/xxl-job-admin.properties");
        propertyConfigurer.setLocations(resource);
        return propertyConfigurer;
    }

    @Bean
    @Autowired
    public SchedulerFactoryBean quartzScheduler(DruidDataSource druidDataSource) throws IOException {
        SchedulerFactoryBean quartzScheduler = new SchedulerFactoryBean();
        quartzScheduler.setDataSource(druidDataSource);
        quartzScheduler.setAutoStartup(true);  // <!--自动启动 -->
        quartzScheduler.setStartupDelay(20);  //<!--延时启动，应用启动成功后在启动 -->
        quartzScheduler.setOverwriteExistingJobs(true); // <!--覆盖DB中JOB：true、以数据库中已经存在的为准：false -->
        quartzScheduler.setApplicationContextSchedulerContextKey("applicationContextKey");
        Resource resource = resolver.getResource("classpath:config/quartz/quartz.properties");
        quartzScheduler.setConfigLocation(resource);
        return quartzScheduler;
    }

    @Bean
    @Autowired
    public XxlJobDynamicScheduler xxlJobDynamicScheduler(SchedulerFactoryBean quartzScheduler){
        XxlJobDynamicScheduler xxlJobDynamicScheduler = new XxlJobDynamicScheduler();
        xxlJobDynamicScheduler.setScheduler(quartzScheduler.getScheduler());
        return  xxlJobDynamicScheduler;
    }



}
