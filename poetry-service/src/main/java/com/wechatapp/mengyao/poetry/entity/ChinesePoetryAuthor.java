package com.wechatapp.mengyao.poetry.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

/**
 * 表名：chinese_poetry_author
 */
@Data
@Table(name = "chinese_poetry_author")
public class ChinesePoetryAuthor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @Column(name = "short_description")
    private String shortDescription;

    private static final long serialVersionUID = 1L;
}