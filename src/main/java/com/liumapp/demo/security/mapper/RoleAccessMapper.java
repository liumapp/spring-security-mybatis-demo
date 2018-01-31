package com.liumapp.demo.security.mapper;

import com.liumapp.demo.security.domain.RoleAccess;
import com.liumapp.demo.security.domain.RoleAccessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleAccessMapper {
    long countByExample(RoleAccessExample example);

    int deleteByExample(RoleAccessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleAccess record);

    int insertSelective(RoleAccess record);

    List<RoleAccess> selectByExample(RoleAccessExample example);

    RoleAccess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleAccess record, @Param("example") RoleAccessExample example);

    int updateByExample(@Param("record") RoleAccess record, @Param("example") RoleAccessExample example);

    int updateByPrimaryKeySelective(RoleAccess record);

    int updateByPrimaryKey(RoleAccess record);
}