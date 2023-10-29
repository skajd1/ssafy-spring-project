package com.mvc.dao;

import java.util.ArrayList;

import com.mvc.vo.Board;

//BoardService를 위한 인터페이스
public interface BoardDao {
	public ArrayList<Board> selectAll();//모든 글정보
	public Board selectOne(String num);
	public void updateCount(String num);
	public void insert(Board b);
	public int delete(String num);
	public void modify(Board b);
}
