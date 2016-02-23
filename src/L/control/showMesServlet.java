package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.userDao;
import L.db.User;


@WebServlet("/showMes.do")
public class showMesServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		userDao dao=new userDao();
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String uname=u.getUserName();
			User user=dao.findByName(uname);
			request.getSession().setAttribute("um", user);
			response.sendRedirect("/JSP/changeMessage.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
