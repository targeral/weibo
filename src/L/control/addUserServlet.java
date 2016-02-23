package L.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import L.dao.userDao;
import L.db.User;

@WebServlet("/test/addUser.do")
public class addUserServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		userDao dao=new userDao();
		User user=new User();
		try{
			user.setUserName(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setRealName(request.getParameter("realname"));
			user.setSex(request.getParameter("sex"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setSummary(request.getParameter("summary"));
			user.setSign(request.getParameter("sign"));
			user.setEmail(request.getParameter("email"));
			user.setAddress(request.getParameter("address"));
			user.setPhoneNumber(request.getParameter("phonenumber"));
			boolean flag=dao.addUser(user);
			request.getSession().setAttribute("loginuser", user);
			response.sendRedirect("home.html");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
