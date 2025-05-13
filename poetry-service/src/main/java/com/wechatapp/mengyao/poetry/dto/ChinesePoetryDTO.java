package com.wechatapp.mengyao.poetry.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class ChinesePoetryDTO {

    private Integer id;

    private String author;

    private Integer authorId;

    private String dynasty;

    private String title;

    private String rhythmic;

    private String chapter;

    private String notes;

    private String collection;

    private String section;

    private List<String> content;

    private String comment;

    private List<String> tags;

}