package com.study.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dto.MycommentDto;
import com.study.springboot.entity.Article;
import com.study.springboot.entity.Mycomment;
import com.study.springboot.repository.ArticleRepository;
import com.study.springboot.repository.MycommentRepository;

import jakarta.transaction.Transactional;

@Service	
public class MycommentService {
	
	@Autowired
	private MycommentRepository mycommentRepository;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public List<MycommentDto> mycomments(Long articleId){
//		//댓글조회
//		List<Mycomment> mycomments = mycommentRepository.findByArticleId(articleId);
//		//엔티티 -> DTO
//		List<MycommentDto> dtos = new ArrayList<MycommentDto>();
//		for(int i=0;i<mycomments.size();i++) {
//			Mycomment c = mycomments.get(i);
//			MycommentDto dto = MycommentDto.createMycommentDto(c);
//			dtos.add(dto);
//		}
		
		return mycommentRepository.findByArticleId(articleId)
				.stream()
				.map(mycomment -> MycommentDto.createMycommentDto(mycomment))
				.collect(Collectors.toList());
	
//		return dtos;
	}
	
	@Transactional
	public MycommentDto create(Long articleId, MycommentDto dto) {
		//  1. 게시글 조회 및 예외발생
		Article article =articleRepository.findById(articleId)
				.orElseThrow(()-> new IllegalArgumentException("댓글 생성 실패!"));
		//2. 댓글 엔티티 생성
		Mycomment mycomment = Mycomment.createMycomment(dto, article);
		//3. 댓글 엔티티를 db에 저장
		Mycomment created = mycommentRepository.save(mycomment);
		//4. DTo로 변환해 반환
		return MycommentDto.createMycommentDto(mycomment);
	}
	
	@Transactional
	public MycommentDto update(Long id,MycommentDto dto) {
		Mycomment target = mycommentRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("댓글 수정 실패!"));
		target.patch(dto);
		Mycomment updated = mycommentRepository.save(target);
		return MycommentDto.createMycommentDto(updated);
	}
	
	@Transactional
	public MycommentDto delete(Long id) {
		Mycomment target = mycommentRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("댓글 삭제 실패"));
		mycommentRepository.delete(target);
		return MycommentDto.createMycommentDto(target);
	}
	
	
}
