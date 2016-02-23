package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.attentedDao;
import L.db.Attented;
import L.db.User;

@WebServlet("/showAttented.do")
public class showAttentedServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		attentedDao dao=new attentedDao();
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String uname=u.getUserName();
			ArrayList<Attented> ans=dao.findByUserName(uname);
			if(ans.isEmpty()){
				response.sendRedirect("/JSP/showNoAttented.jsp");
			}
			else{
				request.getSession().setAttribute("attentedList", ans);
				response.sendRedirect("/JSP/showAllAttented.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
