package com.wechatapp.mengyao.poetry.controller;

import com.wechatapp.mengyao.poetry.core.PageRequest;
import com.wechatapp.mengyao.poetry.core.PageResult;
import com.wechatapp.mengyao.poetry.core.RestResponse;
import com.wechatapp.mengyao.poetry.dto.ChinesePoetryDTO;
import com.wechatapp.mengyao.poetry.service.ChinesePoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yanghuaxu
 * @date 2025/5/11 20:43
 */
@RestController
@RequestMapping("/api/v1/poetry")
public class PoetryController {

    @Autowired
    private ChinesePoetryService chinesePoetryService;

    @GetMapping("/{id}")
    public RestResponse<ChinesePoetryDTO> getById(@PathVariable Integer id) {

        return RestResponse.ok(chinesePoetryService.getById(id));
    }

    @GetMapping("/page")
    public RestResponse<PageResult<ChinesePoetryDTO>> listByPage(@RequestParam Map<String, String> map) {

        return RestResponse.ok(chinesePoetryService.listByPage(map));
    }

}
