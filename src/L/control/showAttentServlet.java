package L.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import L.dao.attentDao;
import L.db.Attent;
import L.db.User;

@WebServlet("/showAttent.do")
public class showAttentServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		attentDao dao=new attentDao();
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String uname=u.getUserName();
			ArrayList<Attent> ans=dao.findByUserName(uname);
			if(ans.isEmpty()){
				response.sendRedirect("/JSP/showNoAttent.jsp");
			}
			else{
				request.getSession().setAttribute("attentList", ans);
				response.sendRedirect("/JSP/showAllAttent.jsp");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
