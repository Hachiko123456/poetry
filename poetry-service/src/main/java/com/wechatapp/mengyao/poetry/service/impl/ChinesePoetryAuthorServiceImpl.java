package com.wechatapp.mengyao.poetry.service.impl;

import com.github.pagehelper.PageHelper;
import com.wechatapp.mengyao.poetry.core.PageRequest;
import com.wechatapp.mengyao.poetry.core.PageResult;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetry;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetryAuthor;
import com.wechatapp.mengyao.poetry.mapper.ChinesePoetryAuthorMapper;
import com.wechatapp.mengyao.poetry.service.ChinesePoetryAuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yanghuaxu
 * @date 2025/5/11 18:09
 */
@Service
@Slf4j
public class ChinesePoetryAuthorServiceImpl implements ChinesePoetryAuthorService {

    @Autowired
    private ChinesePoetryAuthorMapper authorMapper;

    @Override
    public boolean saveOrUpdate(ChinesePoetryAuthor author) {
        ChinesePoetryAuthor p = getById(author.getId());
        int r = 0;
        if (p != null) {
            r = authorMapper.update(author);
        } else {
            r = authorMapper.insert(author);
        }
        return r > 0;
    }

    @Override
    public boolean deleteById(Integer id) {
        return authorMapper.deleteById(id) > 0;
    }

    @Override
    public ChinesePoetryAuthor getById(Integer id) {
        return authorMapper.selectById(id);
    }

    @Override
    public PageResult<ChinesePoetryAuthor> listByPage(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        return PageResult.build(authorMapper.selectAll());
    }

}
