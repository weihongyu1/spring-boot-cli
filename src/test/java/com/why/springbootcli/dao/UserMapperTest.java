package com.why.springbootcli.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.why.springbootcli.common.entity.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class UserMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger("BUSINESS_LOG");

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserInfo() {
        UserPO user = userMapper.getUserInfo(1);
        assertNotNull(user);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(user));
        jsonObject.put("msg", "查询用户信息");
        LOGGER.info(jsonObject.toJSONString());
    }
}