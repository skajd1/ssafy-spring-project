package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.vo.Board;

//dao객체: db작업 하는 객체(CRUD)
@Repository
public class BoardDaoImpl implements BoardDao{
	
	
	@Autowired
	DataSource ds;
	
	
	@Override
	public ArrayList<Board> selectAll() {
		String q = "select num, name, wdate,title,count from board order by num desc";
		ArrayList<Board> list = new ArrayList<>();
		
		try {
			Connection con = ds.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				int count = rs.getInt(5);
				
				Board b = new Board(num,null, name, wdate, title, null, count);
				list.add(b);
			}
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Board selectOne(String num) {
		String q = "select * from board where num=?";
		Board b = null;
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			
			ResultSet rs = stat.executeQuery();
			rs.next();
			
			String pass = rs.getString(2);
			String name = rs.getString(3);
			String wdate = rs.getString(4);
			String title = rs.getString(5);
			String content = rs.getString(6);
			int count = rs.getInt(7);
				
			b = new Board(num,pass, name, wdate, title, content, count);			
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void updateCount(String num) {
		String q = "update board set count = count+1 where num=?";
		
		try {
			Connection con = ds.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			
			stat.executeUpdate();					
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void insert(Board b) {
		String q = "insert into board(pass, name, wdate, title, content, count) "
				+ "values(?, ?, sysdate(), ?,?,0)";		
		try {
			Connection con = ds.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, b.getPass());
			stat.setString(2, b.getName());
			stat.setString(3, b.getTitle());
			stat.setString(4, b.getContent());
			
			stat.executeUpdate();					
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public int delete(String num) {
		String q = "delete from board where num=?";
		int x = 0;
		try {
			Connection con = ds.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			
			x = stat.executeUpdate();					
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return x;
	}

	@Override
	public void modify(Board b) {
		String q = "update board set title = ?, pass = ?, name = ?, content = ? where num = ?";
		try {
			Connection con  = ds.getConnection();
			PreparedStatement pstat = con.prepareStatement(q);
			pstat.setString(1, b.getTitle());
			pstat.setString(2, b.getPass());
			pstat.setString(3, b.getName());
			pstat.setString(4, b.getContent());
			pstat.setString(5, b.getNum());
			pstat.executeUpdate();					
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}









