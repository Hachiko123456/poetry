package com.wechatapp.mengyao.poetry.mapper;

import com.wechatapp.mengyao.poetry.entity.ChinesePoetryAuthor;
import java.util.List;

public interface ChinesePoetryAuthorMapper {
    // 插入作者
    int insert(ChinesePoetryAuthor author);

    // 更新作者
    int update(ChinesePoetryAuthor author);

    // 根据ID删除作者
    int deleteById(Integer id);

    // 根据ID查询作者
    ChinesePoetryAuthor selectById(Integer id);

    // 查询所有作者
    List<ChinesePoetryAuthor> selectAll();
}