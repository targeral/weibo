package L.control;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import L.dao.habitDao;
import L.dao.postDao;
import L.dao.replyDao;
import L.dao.userDao;
import L.db.Habit;
import L.db.Post;
import L.db.Reply;
import L.db.User;

@WebServlet("/showPic.do")
public class showPicServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		userDao dao=new userDao();
		String uu = request.getParameter("un");
        InputStream is = dao.getPicByName(uu);
        ServletOutputStream sos = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int n = -1;
        while ((n = is.read(buffer)) != -1) {
            sos.write(buffer, 0, n);
        }
        sos.flush();
        sos.close();	 
	}
}
