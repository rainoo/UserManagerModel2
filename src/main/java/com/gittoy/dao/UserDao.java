package com.gittoy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gittoy.bean.User;
import com.gittoy.util.Const;
import com.gittoy.util.DBHelper;
import com.gittoy.util.StringUtil;

/**
 * 和USER表相关的数据库操作
 *  
 * @author GaoYu
 */
public class UserDao {

	/**
	 * 根据查询条件查询用户列表
	 * 
	 * @param name 姓名
	 * @param mobile 手机
	 * @param email 邮箱
	 * @param idcard 身份证号
	 * @return 符合条件的用户列表
	 */
	public List<User> getUserList(String name, String mobile, String email, String idcard) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = DBHelper.getConnection();
			StringBuilder sql = new StringBuilder("select ID, USERNAME, PASSWORD, NAME, MOBILE, EMAIL, IDCARD, DELFLG from dl_user where DELFLG != '1'");

			// 获取动态SQL参数并保存。
			List<String> paramList = new ArrayList<String>();
			if (!StringUtil.isNullOrEmpty(name)) {
				sql.append(" AND NAME = ?");
				paramList.add(name);
			}
			if (!StringUtil.isNullOrEmpty(mobile)) {
				sql.append(" AND MOBILE LIKE '%' ? '%'");
				paramList.add(mobile);
			}
			if (!StringUtil.isNullOrEmpty(email)) {
				sql.append(" AND EMAIL LIKE '%' ? '%'");
				paramList.add(email);
			}
			if (!StringUtil.isNullOrEmpty(idcard)) {
				sql.append(" AND IDCARD LIKE '%' ? '%'");
				paramList.add(idcard);
			}
			int pageViewCnt = Const.NUMBER_OF_PAGES_DISPLAYED;
			// 从CONST中取得每页默认显示条数
			sql.append(" limit 0, ?");

			stmt = conn.prepareStatement(sql.toString());
			for(int i = 0; i < paramList.size(); i++) {
				stmt.setString(i+1, paramList.get(i));
			}
			stmt.setInt(paramList.size()+1, pageViewCnt);
			rs = stmt.executeQuery();

			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setMobile(rs.getString("MOBILE"));
				user.setEmail(rs.getString("EMAIL"));
				user.setIdcard(rs.getString("IDCARD"));
				user.setDelflg(rs.getString("DELFLG"));
				// 把一个商品加入集合
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

	// 查询数据库USER表的行数
	public int getUsersCout() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int userCount = 0;
		try {
			conn = DBHelper.getConnection();
			String sql = "select count(1) as cnt from dl_user where DELFLG != '1'";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			rs.next();
			userCount = rs.getInt("cnt");

			return userCount;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		System.out.println(ud.getUsersCout());
	}
}
