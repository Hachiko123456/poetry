package com.wechatapp.mengyao.poetry.service.impl;

import com.github.pagehelper.PageHelper;
import com.wechatapp.mengyao.poetry.core.PageRequest;
import com.wechatapp.mengyao.poetry.core.PageResult;
import com.wechatapp.mengyao.poetry.dto.ChinesePoetryDTO;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetry;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetryAuthor;
import com.wechatapp.mengyao.poetry.mapper.ChinesePoetryMapper;
import com.wechatapp.mengyao.poetry.service.ChinesePoetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yanghuaxu
 * @date 2025/5/11 18:09
 */
@Service
@Slf4j
public class ChinesePoetryServiceImpl implements ChinesePoetryService {

    @Autowired
    private ChinesePoetryMapper poetryMapper;

    @Override
    public boolean saveOrUpdate(ChinesePoetry poetry) {
        ChinesePoetryDTO p = getById(poetry.getId());
        int r = 0;
        if (p != null) {
            r = poetryMapper.update(poetry);
        } else {
            r = poetryMapper.insert(poetry);
        }
        return r > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return poetryMapper.deleteById(id) > 0;
    }

    @Override
    public ChinesePoetryDTO getById(Integer id) {
        ChinesePoetry poetry = poetryMapper.selectById(id);
        return poetry.convert();
    }

    @Override
    public PageResult<ChinesePoetryDTO> listByPage(Map<String, String> map) {
        int pageNum = Integer.parseInt(map.getOrDefault("pageNum", "1"));
        int pageSize = Integer.parseInt(map.getOrDefault("pageSize", "10"));
        PageHelper.startPage(pageNum, pageSize);
        List<ChinesePoetry> poetryList = poetryMapper.selectByCondition(map);
        return PageResult.build(poetryList.stream().map(ChinesePoetry::convert).collect(Collectors.toList()));
    }

}
