package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.vo.User;
//db
@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	DataSource ds;
	
	@Override
	public boolean check(User u) {
		boolean flag = false;
		try {
			Connection con = ds.getConnection();
			String q = "select id from user where id = ? and pw = ?";
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, u.getId());
			stat.setString(2, u.getPw());
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) flag = true; //로그인 성공했을 때
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
