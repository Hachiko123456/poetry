package com.wechatapp.mengyao.poetry.controller;

import com.wechatapp.mengyao.poetry.core.RestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanghuaxu
 * @date 2025/5/13 15:56
 */
@RestController
public class HealthController {

    @GetMapping("/actuator/health")
    public RestResponse<String> healthCheck() {

        return RestResponse.ok("success");
    }

}
