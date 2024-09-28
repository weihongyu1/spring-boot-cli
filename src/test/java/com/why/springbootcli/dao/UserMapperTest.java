package com.why.springbootcli.dao;

import com.alibaba.fastjson.JSON;
import com.why.springbootcli.common.entity.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserInfo() {
        UserPO user = userMapper.getUserInfo(1);
        assertNotNull(user);
        log.info("user:{}", JSON.toJSONString(user));
    }
}