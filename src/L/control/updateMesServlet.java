package L.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import L.dao.habitDao;
import L.dao.userDao;
import L.db.Habit;
import L.db.User;

@WebServlet("/updateMes.do")
public class updateMesServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		userDao dao=new userDao();
		habitDao dao2=new habitDao();
		Habit habit=new Habit();
		User user=new User();
		String message=null;
		try{
			User u=(User)request.getSession().getAttribute("loginuser");
			String una=u.getUserName();
			user.setUserName(una);
			user.setPasswordHint(request.getParameter("passwordhint"));
			user.setPasswordAnswer(request.getParameter("passwordanswer"));
			user.setRealName(request.getParameter("realname"));
			user.setFalseName(request.getParameter("falsename"));
			user.setSex(request.getParameter("sex"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setEmail(request.getParameter("email"));
			user.setPhoneNumber(request.getParameter("phonenumber"));
			user.setAddress(request.getParameter("address"));
			user.setSummary(request.getParameter("summary"));
			user.setSign(request.getParameter("sign"));
		
			
			boolean success=dao.updateUser(user);	
			success=success && dao2.deleteAllHabitByUserName(una);
			
			for(int i=0;i<request.getParameterValues("habit").length;i++){
				habit.setHabit(request.getParameterValues("habit")[i]);
				habit.setUserName(una);
				success=success && dao2.addHabit(habit);
			}			
			
			if(success){
				HttpSession session=request.getSession();
				response.sendRedirect("/JSP/homepage.jsp");
			}
			else{
				message="<li>¸üÐÂÊ§°Ü£¡</li>";
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
