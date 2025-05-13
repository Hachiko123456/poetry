package com.wechatapp.mengyao.poetry.service;

import com.wechatapp.mengyao.poetry.core.PageRequest;
import com.wechatapp.mengyao.poetry.core.PageResult;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetryAuthor;

import java.util.List;

/**
 * @author yanghuaxu
 * @date 2025/5/11 18:08
 */
public interface ChinesePoetryAuthorService {

    // 新增或更新作者
    boolean saveOrUpdate(ChinesePoetryAuthor author);

    // 根据ID删除作者
    boolean deleteById(Integer id);

    // 根据ID查询作者
    ChinesePoetryAuthor getById(Integer id);

    PageResult<ChinesePoetryAuthor> listByPage(PageRequest pageRequest);

}
