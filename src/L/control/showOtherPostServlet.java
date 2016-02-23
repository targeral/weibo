package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import net.sf.json.JSONObject;
import L.dao.postDao;
import L.db.Post;;
@WebServlet("/test/showOtherPost.do")
public class showOtherPostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		try{
			String uname=request.getParameter("username");
			ArrayList<Post> ans=dao.findByUserName(uname);
			String data = "{}";
			JSONObject jsonObj = JSONObject.fromObject(data);
			jsonObj.put("ans", ans);
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
