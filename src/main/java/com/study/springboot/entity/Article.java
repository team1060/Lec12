package com.study.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {
	
	@Id
	@SequenceGenerator (
			name = "mySequence01",
			sequenceName = "Article_SEQ",
			initialValue = 1,
			allocationSize = 1
	)
	@GeneratedValue (generator = "mySequence01")
	private Long id;
	
	@Column
	private String title;
	@Column
	private String content;
	
	public void patch(Article article) {
		if(article.title != null) {
			this.title = article.title;
		}
		if(article.content != null) {
			this.content = article.content;
		}
		
	}
}
