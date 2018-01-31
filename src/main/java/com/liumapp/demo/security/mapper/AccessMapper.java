package com.liumapp.demo.security.mapper;

import com.liumapp.demo.security.domain.Access;
import com.liumapp.demo.security.domain.AccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessMapper {
    long countByExample(AccessExample example);

    int deleteByExample(AccessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Access record);

    int insertSelective(Access record);

    List<Access> selectByExample(AccessExample example);

    Access selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Access record, @Param("example") AccessExample example);

    int updateByExample(@Param("record") Access record, @Param("example") AccessExample example);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);
}