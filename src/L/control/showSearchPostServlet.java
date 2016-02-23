package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.postDao;
import L.db.Post;

@WebServlet("/showSearchPost.do")
public class showSearchPostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		try{
			int pid=Integer.parseInt(request.getParameter("pid"));
			Post p=dao.findByPid(pid);
			request.getSession().setAttribute("pp", p);
			response.sendRedirect("/JSP/showSearchPost.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
