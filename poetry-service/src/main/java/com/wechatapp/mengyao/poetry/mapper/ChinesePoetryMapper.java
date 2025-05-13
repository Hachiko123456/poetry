package com.wechatapp.mengyao.poetry.mapper;

import com.wechatapp.mengyao.poetry.entity.ChinesePoetry;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ChinesePoetryMapper extends Mapper<ChinesePoetry> {

    // 插入诗词
    int insert(ChinesePoetry poetry);

    // 更新诗词
    int update(ChinesePoetry poetry);

    // 根据ID删除诗词
    int deleteById(Integer id);

    // 根据ID查询诗词
    ChinesePoetry selectById(Integer id);

    // 查询所有诗词
    List<ChinesePoetry> selectByCondition(Map<String, String> map);

    // 根据作者ID查询诗词
    List<ChinesePoetry> selectByAuthorId(Integer authorId);

}