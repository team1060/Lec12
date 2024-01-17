package com.study.springboot.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.dto.MycommentDto;
import com.study.springboot.service.MycommentService;

@RestController
public class MycommentApiController {
	
	@Autowired
	private MycommentService mycommentService;
	
	@GetMapping("/api/articles/{articleId}/comments")
	public ResponseEntity<List<MycommentDto>> mycomments(@PathVariable Long articleId){
		//서비스위임
		List<MycommentDto> dtos = mycommentService.mycomments(articleId);
		//결과응답
		if (dtos.isEmpty()) {
	        // 데이터가 없을 때 에러 응답
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    } else {
	        // 데이터가 있을 때 성공 응답
	        return ResponseEntity.status(HttpStatus.OK).body(dtos);
	    }
	}
	
	@PostMapping("/api/articles/{articleId}/commnets")
	public ResponseEntity<MycommentDto> create(
			@PathVariable Long articleId,
			@RequestBody MycommentDto dto
			){
		
		MycommentDto createDto = mycommentService.create(articleId, dto);
		return ResponseEntity.status(HttpStatus.OK).body(createDto);
	}
	
	@PatchMapping("/api/comments/{id}")
	public ResponseEntity<MycommentDto> update(
			@PathVariable Long id,
			@RequestBody MycommentDto dto
			){
		MycommentDto updateDto = mycommentService.update(id, dto);
		return ResponseEntity.status(HttpStatus.OK).body(updateDto);
	}
	
	@DeleteMapping("/api/comments/{id}")
	public ResponseEntity<MycommentDto> delete(@PathVariable Long id){
		MycommentDto deleteDto = mycommentService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleteDto);
	}
}
