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

import net.sf.json.JSONObject;
import L.dao.postDao;
import L.dao.replyDao;
import L.dao.userDao;
import L.db.Post;
import L.db.Reply;
import L.db.User;

@WebServlet("/test/showReply.do")
public class showReplyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		replyDao dao=new replyDao();
		postDao dao2=new postDao();
		String message=null;
		try{
			int pid=Integer.parseInt(request.getParameter("postID"));
			Post po=dao2.findByPid(pid);
			ArrayList<Reply> r=dao.findByPostID(pid);
			
			String data = "{}";
			JSONObject jsonObj = JSONObject.fromObject(data);
			jsonObj.put("ans", r);
			//System.out.println(jsonObj);
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(jsonObj.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
