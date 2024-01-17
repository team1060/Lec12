package com.study.springboot.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.entity.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
	@Override
	ArrayList<Article> findAll();
}
