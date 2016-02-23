package L.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import L.dao.userDao;
import L.db.User;

@WebServlet("/test/checklogin.do")
public class checkPasswordServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(request.getParameter("password"));
		userDao dao=new userDao();
		ArrayList<User> userList=new ArrayList<User>();
		userList=dao.findAllUser();
		System.out.println(password);
		String tmpps="-1";
		for(int i=0;i<userList.size();i++){
			if(username.equals(userList.get(i).getUserName())){
				tmpps=userList.get(i).getPassword();
				break;
			}
		}
		if(tmpps.equals("-1")){
			out.print("<script>alert('√ª”–’‚∏ˆ’ ∫≈ ,«Î÷ÿ ‘£°'); window.location='/JSP/login.jsp' </script>");
			out.flush();
			out.close();
		}
		if(tmpps.equals(password)){
			if((request.getParameter("checkbox")!=null) && 
				(request.getParameter("checkbox").equals("checkbox"))){
				Cookie nameCookie=new Cookie("username",username);
				Cookie pswdCookie=new Cookie("password",password);
				nameCookie.setMaxAge(60*60);
				pswdCookie.setMaxAge(60*60);
				response.addCookie(nameCookie);
				response.addCookie(pswdCookie);
			}
			User loginuser=dao.findByName(username);
			request.getSession().setAttribute("loginuser", loginuser);
			response.sendRedirect("/JSP/test/home.html");
		}
		else{
			out.print("<script>alert('√‹¬Î¥ÌŒÛ£¨«Î÷ÿ ‘£°'); window.location='/JSP/login.jsp' </script>");
			out.flush();
			out.close();
		}
	}
}
