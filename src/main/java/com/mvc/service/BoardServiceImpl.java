package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.mapper.BoardMapper;
import com.mvc.vo.Board;
//dao로 보내기 전에 해야 할 전처리
//tx 처리(하나의 단위로 묶여서 처리되어야 하는 쿼리)
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper mapper;
	

	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = mapper.selectAll();
		return list;
	}

	@Override
	@Transactional
	public Board selectOne(String num) {
		mapper.updateCount(num);//조회수 증가
		return mapper.selectOne(num);
	}

	@Override
	public void insert(Board b) {
		mapper.insert(b);		
	}

	@Override
	public int delete(String num) {
		return mapper.delete(num);
	}

	@Override
	public void modify(Board b) {
		mapper.modify(b);
		
	}

	@Override
	public ArrayList<Board> search(HashMap<String, String> map) {
		return mapper.search(map);
	}

	@Override
	//@Transactional
	public void txtest() {
		mapper.txtest();
		mapper.txtest();
	}

}






