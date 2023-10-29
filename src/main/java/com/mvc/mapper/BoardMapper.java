package com.mvc.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.Board;

//BoardService를 위한 인터페이스
@Mapper
public interface BoardMapper {
	public ArrayList<Board> selectAll();//모든 글정보
	public Board selectOne(String num);
	public void updateCount(String num);
	public void insert(Board b);
	public int delete(String num);
	public void modify(Board b);
	public ArrayList<Board> search(HashMap<String, String> map);
	public void txtest();
}
