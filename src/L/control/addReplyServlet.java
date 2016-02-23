package L.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import L.dao.postDao;
import L.dao.replyDao;
import L.dao.userDao;
import L.db.Post;
import L.db.Reply;
import L.db.User;

@WebServlet("/test/addReply.do")
public class addReplyServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		replyDao dao=new replyDao();
		Reply reply=new Reply();
		String message=null;
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String una=u.getUserName();
			
			int pid=Integer.parseInt(request.getParameter("nowpid"));
			reply.setPostID(pid);
			reply.setUserName(una);
			reply.setInstance(request.getParameter("instance"));
			
			boolean success=dao.addReply(reply);
			
			
			postDao dao2=new postDao();
			dao2.addReply(pid);
			
			if(success){
				response.getWriter().print(una);
			}
			else{
				response.getWriter().print("fail");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		replyDao dao=new replyDao();
		String message=null;
		try{
			int pid=Integer.parseInt(request.getParameter("nowpid"));
			ArrayList<Reply> r=dao.findByPostID(pid);
			
			request.getSession().setAttribute("nowpid", pid);
			
			if(r.isEmpty()){
				response.sendRedirect("/JSP/showNoReply.jsp");
			}
			else{
				request.getSession().setAttribute("replyList", r);
				response.sendRedirect("/JSP/showAllReply.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
