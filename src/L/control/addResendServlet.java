package L.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import L.dao.postDao;
import L.dao.userDao;

import L.db.Post;
import L.db.User;

@WebServlet("/addResend.do")
public class addResendServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		Post post=new Post();
		String message="";
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String una=u.getUserName();
			
			post.setUserName(una);
			post.setInstance(request.getParameter("instance"));
			post.setDateTime(new Date().toString());
			post.setResendFlag(1);
			boolean success=dao.addPost(post);
			
			userDao dao2=new userDao();
			dao2.addPost(una);
			
			if(success){
				this.doGet(request, response);
			}
			else{
				message="<li>∑¢±Ì ß∞‹£°</li>";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		try{
			ArrayList<Post> ans=dao.findByOrder();
			request.getSession().setAttribute("allpostList", ans);
			response.sendRedirect("/JSP/homepage.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
