package com.why.springbootcli.dao;

import com.why.springbootcli.common.entity.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户信息Mapper
 *
 * @DATE 2024/9/28
 * @Author why
 */
@Mapper
public interface UserMapper {

    /**
     * 模拟查询用户信息
     * @param id 用户ID
     * @return User
     */
    UserPO getUserInfo(@Param("id") Integer id);
}
