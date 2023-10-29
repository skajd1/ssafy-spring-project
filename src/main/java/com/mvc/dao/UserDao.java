package com.mvc.dao;

import com.mvc.vo.User;

public interface UserDao {
	//로그인 정보가 맞는지 검사해서 결과를 리턴해 주는 메소드
	public boolean check(User u);
}
