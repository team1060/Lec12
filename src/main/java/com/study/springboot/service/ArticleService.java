package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dto.ArticleForm;
import com.study.springboot.entity.Article;
import com.study.springboot.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public List<Article> index(){
		return articleRepository.findAll();
	}
	
	public Article show(Long id) {
		return articleRepository.findById(id).orElse(null);
	}
	
	public Article create(ArticleForm dto) {
		Article article = dto.toEntity();
		if(article.getId() != null) {
			return null;
		}
		return articleRepository.save(article);
	}

	public Article update(Long id, ArticleForm dto) {
		//1 dto -> 엔티티로 변환
		Article article = dto.toEntity();
		
		//2. 타겟 조회
		Article target = articleRepository.findById(id).orElse(null);
		
		//3. 요청처리
		if(target == null || id != article.getId()) {
			return null;
		}
		
		//4. 업데이트
		target.patch(article);
		Article updated = articleRepository.save(target);
		return updated;
		
	}

	public Article delete(Long id) {
		// 대상 찾기
		Article target = articleRepository.findById(id).orElse(null);
		
		if(target == null) {
			return null;
		}
		
		// 삭제
		articleRepository.delete(target);
		return target;
	}
}
