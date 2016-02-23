package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import L.dao.userDao;
import L.db.User;

@WebServlet("/checkAnswer.do")
public class checkAnswerServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		User u=(User)request.getSession().getAttribute("loginuser");
		String uname=u.getUserName();
		String answer=request.getParameter("answer");
		userDao dao=new userDao();
		User user=dao.findByName(uname);
		if(user.getPasswordAnswer().equals(answer)){
			response.sendRedirect("/JSP/changePassword.jsp");
		}
		else{
			String mes="¥∞∏¥ÌŒÛ£¨«Î÷ÿ ‘£°";
			request.setAttribute("mesa",mes);
			response.sendRedirect("/JSP/checkAnswer.jsp");
		}
	}
}
