package com.weweibuy.user.mapper;

import com.weweibuy.user.common.model.po.WebuyUser;
import com.weweibuy.user.common.model.po.WebuyUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WebuyUserMapper {
    long countByExample(WebuyUserExample example);

    int deleteByExample(WebuyUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebuyUser record);

    int insertSelective(WebuyUser record);

    List<WebuyUser> selectByExample(WebuyUserExample example);

    WebuyUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebuyUser record, @Param("example") WebuyUserExample example);

    int updateByExample(@Param("record") WebuyUser record, @Param("example") WebuyUserExample example);

    int updateByPrimaryKeySelective(WebuyUser record);

    int updateByPrimaryKey(WebuyUser record);
}