package com.study.springboot.dto;

import com.study.springboot.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

//@AllArgsConstructor
//@ToString

@Data
public class ArticleForm {
	private Long id;
	private String title; 
	private String content;
	
	public Article toEntity() {
//		return new Article(null,title,content);
		return new Article(id,title,content);
	}
	
}
