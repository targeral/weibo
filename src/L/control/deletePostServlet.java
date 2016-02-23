package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.postDao;
import L.dao.userDao;
import L.db.Post;
import L.db.User;

@WebServlet("/deletePost.do")
public class deletePostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		userDao dao2=new userDao();
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String una=u.getUserName();
			
			int pid=Integer.parseInt(request.getParameter("postID"));
			dao.deletePost(pid);
			dao2.deletePost(una);
			this.doPost(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		try{
			String uname="";
			ArrayList<Post> ans=dao.findByUserName(uname);
			if(ans.isEmpty()){
				response.sendRedirect("/JSP/showNoPost.jsp");
			}
			else{
				request.getSession().setAttribute("postList", ans);
				response.sendRedirect("/JSP/showAllPost.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
