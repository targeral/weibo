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


@WebServlet("/showUser.do")
public class showUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		userDao dao=new userDao();
		try{
			String uname=request.getParameter("uname");
			User ans=dao.findByName(uname);

			request.getSession().setAttribute("userm", ans);
			response.sendRedirect("/JSP/showUser.jsp");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
