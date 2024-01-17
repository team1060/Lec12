package com.study.springboot.entity;

import com.study.springboot.dto.MycommentDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mycomment {
	@Id
	@SequenceGenerator (
			name = "mySequence02",
			sequenceName = "Mycomment_SEQ",
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue (generator = "mySequence02")
	private Long id;
	@ManyToOne
	@JoinColumn(name="article_id",referencedColumnName = "id")
	private Article article;
	@Column
	private String nickname;
	@Column
	private String body;
	
	public static Mycomment createMycomment(MycommentDto dto, Article article) {
		if(dto.getId() != null)
			throw new IllegalArgumentException("댓글 생성 실패! 댓글 id없어야 합니다.");
		if(dto.getArticleId() != article.getId())
			throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");
		
		return new Mycomment(
				dto.getId(),
				article,
				dto.getNickname(),
				dto.getBody()
				);
	}

	public void patch(MycommentDto dto) {
		if(this.id != dto.getId())
			throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력");
		
		if(dto.getNickname() != null)
			this.nickname = dto.getNickname();
		
		if(dto.getBody() != null)
			this.body = dto.getBody();
		
	}	
}
