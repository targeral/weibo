package L.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.userDao;
import L.db.User;

@WebServlet(name="validationServlet",urlPatterns={"/validation.do"})
public class checkUsernameServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-control", "no-cache");
		userDao dao=new userDao();
		ArrayList<User> userList=new ArrayList<User>();
		userList=dao.findAllUser();
		
		String username=request.getParameter("username");
		String message="用户名可以使用!";
		PrintWriter out=response.getWriter();
		for(int i=0;i<userList.size();i++){
			if(username.equals(userList.get(i).getUserName())){
				message="用户名已经被占用!";
				break;
			}
		}
		out.println("<response>");
		out.println("<message>"+message+"</message>");
		out.println("</response>");
	}
}
