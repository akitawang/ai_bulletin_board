package cn.bd.pub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.Urgent_infoDAOImpl;
import cn.bd.manage.Urgent_info;

/**
 * Servlet implementation class Urgent_info_rectify
 */
public class Urgent_info_rectify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Urgent_info_rectify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int id =  Integer.parseInt(request.getParameter("id"));
		String title =  request.getParameter("title");
		String content =  request.getParameter("content");
		String manager =  request.getParameter("manager");
		String time =  request.getParameter("time");
		Urgent_info data = new Urgent_info();
		
		
		data.setTitle(title);
		data.setContent(content);
		data.setManager(manager);
		data.setTime(time);
		data.setId(id);
		Urgent_infoDAOImpl dao = new Urgent_infoDAOImpl();
		boolean judge = dao.rec(data);
		int result=0;
		if(judge == true) {
			result=1;
		}
		response.getWriter().println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
