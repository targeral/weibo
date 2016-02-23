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



@WebServlet("/test/checkAttent.do")
public class checkAttentServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		attentDao dao=new attentDao();
		Attent attent=new Attent();
		try{			
			User u=(User)request.getSession().getAttribute("loginuser");
			String u1=u.getUserName();
			String u2=request.getParameter("attend");
			boolean flag=dao.checkAttent(u1,u2);
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(flag);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
