package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.mvc.vo.Board;

//Controller를 위한 인터페이스
public interface BoardService {
	public ArrayList<Board> selectAll();//모든 글정보
	public Board selectOne(String num);//모든 글정보
	public void insert(Board b);
	public int delete(String num);
	public void modify(Board b);
	public ArrayList<Board> search(HashMap<String, String> map);
	public void txtest();
}
