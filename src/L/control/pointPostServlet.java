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

@WebServlet("/pointPost.do")
public class pointPostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		Post post=new Post();
		String message=null;
		try{
			int pid=Integer.parseInt(request.getParameter("postID"));
			boolean success=dao.pointPost(pid);
			
			if(success){
				this.doPost(request, response);
			}
			else{
				message="<li>∑¢±Ì ß∞‹£°</li>";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		try{
			ArrayList<Post> ans=dao.findByOrder();
			
			request.getSession().setAttribute("allpostList", ans);
			response.sendRedirect("/JSP/index.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
