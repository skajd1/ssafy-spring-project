package com.mvc.service;

import java.util.ArrayList;

import com.mvc.vo.User;

public interface UserService {
	//로그인 정보가 맞는지 검사해서 결과를 리턴해 주는 메소드
	public ArrayList<User> selectAll();
	public User selectOne(String id);
	public void insert(User u);
	public void modify(User u);
	public void delete(String id);
	public boolean check(User u);
}
