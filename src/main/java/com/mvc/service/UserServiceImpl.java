package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.UserMapper;
import com.mvc.vo.User;

@Service
public class UserServiceImpl implements UserService {
	private UserMapper mapper;
	@Autowired
	public UserServiceImpl(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public boolean check(User u) {
		HashMap<String,String> map = new HashMap<>();
		map.put("id", u.getId());
		map.put("pw", u.getPw());
		if(mapper.check(map) == null) return false;
		return true;
	}

	@Override
	public ArrayList<User> selectAll() {
		return mapper.selectAll();
	}

	@Override
	public User selectOne(String id) {
		return mapper.selectOne(id);
	}

	@Override
	public void insert(User u) {
		mapper.insert(u);
	}

	@Override
	public void modify(User u) {
		mapper.modify(u);
	}

	@Override
	public void delete(String id) {
		mapper.delete(id);
	}

}
