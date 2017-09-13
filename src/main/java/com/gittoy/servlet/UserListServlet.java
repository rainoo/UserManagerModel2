package com.gittoy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gittoy.service.UserListService;

/**
 * 用户列表页面初始化控制
 * @author GaoYu
 */
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		// 接受页面的值
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String idcard = request.getParameter("idcard");
		// 向页面传值
		request.setAttribute("name", name);
		request.setAttribute("mobile", mobile);
		request.setAttribute("email", email);
		request.setAttribute("idcard", idcard);
		// 调用service业务方法
		UserListService userListService = new UserListService();
		// 查询用户列表并传递给页面
		request.setAttribute("userList", userListService.getUserList(name, mobile, email, idcard));
		// 向页面跳转
		request.getRequestDispatcher("/WEB-INF/views/userlist.jsp").forward(request, response);;
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
