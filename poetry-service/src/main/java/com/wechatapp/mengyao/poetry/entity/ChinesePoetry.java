package com.wechatapp.mengyao.poetry.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wechatapp.mengyao.poetry.core.JsonUtils;
import com.wechatapp.mengyao.poetry.dto.ChinesePoetryDTO;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 表名：chinese_poetry
 */
@Data
@Table(name = "chinese_poetry")
public class ChinesePoetry implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 作者名称
     */
    private String author;

    /**
     * 作者id
     */
    @Column(name = "author_id")
    private Integer authorId;

    /**
     * 朝代
     */
    private String dynasty;

    /**
     * 作品标题
     */
    private String title;

    /**
     * 词牌名
     */
    private String rhythmic;

    /**
     * 篇章
     */
    private String chapter;

    /**
     * 注解
     */
    private String notes;

    /**
     * 分类 TS（唐诗） YDTS（御定全唐诗） SMTS（水墨唐诗） SS（宋诗） SC（宋词） HJJ（花间集） NTEZC（南唐二主词） YQ（元曲） SJ（诗经） SSWJ（四书五经） LY（论语） NLXD（纳兰性德诗集） MX（蒙学） CCSJ（曹操诗集） CC（楚辞） YMY（幽梦影）
     */
    private String collection;

    /**
     * 分章信息
     */
    private String section;

    /**
     * 全文
     */
    private String content;

    /**
     * 评论赏析
     */
    private String comment;

    /**
     * 标签
     */
    private String tags;

    public ChinesePoetryDTO convert() {
        ChinesePoetryDTO c = new ChinesePoetryDTO();
        c.setId(this.id);
        c.setAuthor(this.author);
        c.setAuthorId(this.authorId);
        c.setDynasty(this.dynasty);
        c.setTitle(this.title);
        c.setRhythmic(this.rhythmic);
        c.setChapter(this.chapter);
        c.setNotes(this.notes);
        c.setCollection(this.collection);
        c.setSection(this.section);
        c.setContent(JsonUtils.parseList(this.content, new TypeReference<List<String>>() {
        }));
        c.setComment(this.comment);
        if (StringUtils.hasText(this.tags)) {
            c.setTags(JsonUtils.parseList(this.tags, new TypeReference<List<String>>() {
            }));
        }
        return c;
    }

    private static final long serialVersionUID = 1L;
}