package L.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.attentDao;
import L.dao.attentedDao;
import L.dao.userDao;
import L.db.Attent;
import L.db.Attented;
import L.db.User;



@WebServlet("/test/addAttent1.do")
public class addAttent1Servlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		attentDao dao=new attentDao();
		Attent attent=new Attent();
		String message=null;
		try{
			userDao dao2=new userDao();
			
			User u=(User)request.getSession().getAttribute("loginuser");
			String una=u.getUserName();
			
			boolean success=dao2.addAttent(una);
			success=success && dao2.addAttented(request.getParameter("aname"));
			
			User user=dao2.findByName(request.getParameter("aname"));
			User user2=dao2.findByName(una);
					
			attent.setUserName(una);
			attent.setAttentName(user.getUserName());
			attent.setSummary(user.getSummary());
			attent.setSign(user.getSign());
			attent.setPostNumber(user.getPostNumber());
			attent.setAttentNumber(user.getAttentNumber());
			attent.setAttentedNumber(user.getAttentedNumber());
			success=success && dao.addAttent(attent);
			
			
			
			
			attentedDao dao3=new attentedDao();
			Attented attented=new Attented();
			attented.setUserName(user.getUserName());
			attented.setAttentName(user2.getUserName());
			attented.setSummary(user2.getSummary());
			attented.setSign(user2.getSign());
			attented.setPostNumber(user2.getPostNumber());
			attented.setAttentNumber(user2.getAttentNumber());
			attented.setAttentedNumber(user2.getAttentedNumber());
			success=success && dao3.addAttented(attented);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(success){
				out.print("<script>alert('添加关注成功！'); window.location='/JSP/showUser.jsp' </script>");
				out.flush();
				out.close();
			}
			else{
				out.print("<script>alert('添加关注失败！'); window.location='/JSP/showUser.jsp' </script>");
				out.flush();
				out.close();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
