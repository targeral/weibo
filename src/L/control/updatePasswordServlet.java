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

@WebServlet("/updatePassword.do")
public class updatePasswordServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		userDao dao=new userDao();
		User user=new User();
		User u=(User)request.getSession().getAttribute("loginuser");
		String uname=u.getUserName();
		String pas1=(request.getParameter("password1"));
		String pas2=(request.getParameter("password2"));
		String message=null;
		try{
			if(!pas1.equals(pas2)){
				message="两次密码输入不正确！";
				request.setAttribute("mesn",message);
				response.sendRedirect("/JSP/changePassword.jsp");
			}
			
			user.setUserName(uname);
			user.setPassword(request.getParameter("password1"));
					
			boolean success=dao.updatePassword(user);
			
			if(success){
				response.sendRedirect("/JSP/homepage.jsp");
			}
			else{
				message="<li>注册失败！</li>";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
