package com.mvc.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.User;

//BoardService를 위한 인터페이스
@Mapper
public interface UserMapper {
	public ArrayList<User> selectAll();
	public User selectOne(String id);
	public void insert(User u);
	public void modify(User u);
	public User check(HashMap<String,String> map);
	public void delete(String id);
}
