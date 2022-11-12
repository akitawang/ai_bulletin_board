package cn.bd.pub.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.Urgent_infoDAOImpl;
import cn.bd.manage.Urgent_info;
/**
 * Servlet implementation class Urgent_info_add
 */
public class Urgent_info_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Urgent_info_add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		String time = dateFormat.format(date);
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content= request.getParameter("content");
		String manager= request.getParameter("manager");
		
		Urgent_infoDAOImpl impl = new Urgent_infoDAOImpl();
		Urgent_info data = new Urgent_info();
		
	
		data.setTitle(title);
		data.setContent(content);
		data.setManager(manager);
		data.setTime(time);
		
		String info = time + "添加一项紧急事件" + "经办人：" + manager + "失败";
		int j = 0;
		boolean judge = impl.add(data);
		if(judge == true) {
			info = time + "添加一项紧急事件" + "经办人：" + manager + "成功";
			j = 1;
		}
		response.getWriter().println(j);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
