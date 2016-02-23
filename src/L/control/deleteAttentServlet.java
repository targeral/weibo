package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.attentDao;
import L.dao.attentedDao;
import L.dao.userDao;
import L.db.Attented;
import L.db.User;

@WebServlet("/deleteAttent.do")
public class deleteAttentServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		attentDao dao=new attentDao();
		attentedDao dao2=new attentedDao();
		userDao dao3=new userDao();
		try{
			String uname=request.getParameter("username");
			String aname=request.getParameter("attentname");
			dao.deleteAttent(uname,aname);
			dao2.deleteAttented(aname,uname);
			dao3.deleteAttent(uname);
			dao3.deleteAttented(aname);
			this.doPost(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		attentedDao dao=new attentedDao();
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String uname=u.getUserName();
			ArrayList<Attented> ans=dao.findByUserName(uname);
			if(ans.isEmpty()){
				response.sendRedirect("/JSP/showNoAttent.jsp");
			}
			else{
				request.getSession().setAttribute("attentedList", ans);
				response.sendRedirect("/JSP/showAllAttent.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
