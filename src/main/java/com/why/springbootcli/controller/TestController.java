package com.why.springbootcli.controller;

import com.why.springbootcli.common.entity.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Controller
 *
 * @DATE 2024/9/28
 * @Author why
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 测试方法
     * @return 响应信息
     */
    @RequestMapping("/test")
    public ResponseVO<Void> hello() {
        return ResponseVO.success();
    }
}
