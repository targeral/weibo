package L.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import L.dao.postDao;
import L.dao.userDao;

import L.db.Post;
import L.db.User;

@WebServlet("/test/addPost.do")
public class addPostServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		postDao dao=new postDao();
		Post post=new Post();
		String message=null;
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String una=u.getUserName();
			
			post.setUserName(una);
			System.out.println(una);
			post.setInstance(request.getParameter("instance"));
			post.setDateTime(new Date().toString());
			post.setResendFlag(0);
			boolean success=dao.addPost(post);
			
			ArrayList<Post> tmp=dao.findByOrder();
			int postId=tmp.get(0).getPostID();
			
			
			userDao dao2=new userDao();
			dao2.addPost(una);
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			System.out.println(postId);
			String data = "{}";
			JSONObject jsonObj = JSONObject.fromObject(data);
			jsonObj.put("username", una);
			jsonObj.put("postId", postId);
			if(success){
				System.out.println("ddd");
				response.getWriter().print(jsonObj);
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
		String value1="",value2="";
		Cookie cookie=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				cookie=cookies[i];
				if(cookie.getName().equals("username"))
					value1=cookie.getValue();
				if(cookie.getName().equals("password"))
					value2=cookie.getValue();
			}
			userDao dao=new userDao();
			ArrayList<User> userList=new ArrayList<User>();
			userList=dao.findAllUser();
			String tmpps="-1";
			for(int i=0;i<userList.size();i++){
				if(value1.equals(userList.get(i).getUserName())){
					tmpps=userList.get(i).getPassword();
					break;
				}
			}
			if(value2.equals(tmpps)){
				User loginuser=dao.findByName(value1);
				request.getSession().setAttribute("loginuser", loginuser);
				response.sendRedirect("/JSP/index.jsp");
			}
		}
		
		
		postDao dao=new postDao();
		try{
			ArrayList<Post> ans=dao.findByOrder();
			
			String data = "{}";
			JSONObject jsonObj = JSONObject.fromObject(data);
			jsonObj.put("ans", ans);
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonObj.toString());
			//response.sendRedirect("/JSP/test/index.html");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
