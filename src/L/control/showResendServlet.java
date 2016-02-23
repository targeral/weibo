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

@WebServlet("/showResend.do")
public class showResendServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		try{
			int pid=Integer.parseInt(request.getParameter("postID"));
			Post post=dao.findByPid(pid);
			dao.addResend(pid);
			request.getSession().setAttribute("pm", post);
			response.sendRedirect("/JSP/resendPost.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
