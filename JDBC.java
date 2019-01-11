package com.keji;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class WebJdbc {
	public void login(String name ,String password) throws ClassNotFoundException, SQLException {//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//连接数据库
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
		//sql语句
		String sql="select * from t_user where name=? and password=?";
		//预编译防止sql注入
		PreparedStatement ps=conn.prepareStatement(sql);
		//设置占位符
		ps.setString(1, name);
		ps.setString(2, password);
		//执行查询操作
		ResultSet rs=ps.executeQuery();
		//对结果进行处理
		if(rs.next()) {
			System.out.println("恭喜您"+name+"登录成功");
			System.out.println(rs.getObject(1));
		}else {
			System.out.println("账号或密码错误");
		}
		if(rs!=null) {
			rs.close();
		}
		if(ps!=null) {
			ps.close();
		}
		if(conn!=null) {
			conn.close();
		}
		
	}
	@Test
	public void test() {
		try {
			login("b","111111");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
