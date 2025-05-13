package com.wechatapp.mengyao.poetry.service;

import com.wechatapp.mengyao.poetry.core.PageRequest;
import com.wechatapp.mengyao.poetry.core.PageResult;
import com.wechatapp.mengyao.poetry.dto.ChinesePoetryDTO;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetry;
import com.wechatapp.mengyao.poetry.entity.ChinesePoetryAuthor;

import java.util.List;
import java.util.Map;

/**
 * @author yanghuaxu
 * @date 2025/5/11 18:08
 */
public interface ChinesePoetryService {

    // 新增或更新诗词
    boolean saveOrUpdate(ChinesePoetry poetry);

    // 根据ID删除诗词
    boolean deleteById(Integer id);

    // 根据ID查询诗词
    ChinesePoetryDTO getById(Integer id);

    PageResult<ChinesePoetryDTO> listByPage(Map<String,String> map);

}
