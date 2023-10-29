package com.mvc.vo;
//board 테이블 안의 레코드 1건의 정보를 저장하기 위한 용도

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Board {
	
	private String num;
	private String pass;
	private String name;
	private String wdate;
	private String title;
	private String content;
	private int count;	
		
}
