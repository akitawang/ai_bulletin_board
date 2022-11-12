package cn.bd.pub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.Surrounding_infoDAOImpl;
import cn.bd.manage.Surrounding_info;

/**
 * Servlet implementation class Surrounding_info_rectify
 */
public class Surrounding_info_rectify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Surrounding_info_rectify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int id =  Integer.parseInt(request.getParameter("id"));
		String content =  request.getParameter("content");
		String manager =  request.getParameter("manager");
		String time =  request.getParameter("time");
		String type =  request.getParameter("type");
		Surrounding_info data = new Surrounding_info();
		
		data.setType(type);
		data.setContent(content);
		data.setManager(manager);
		data.setTime(time);
		data.setId(id);
		Surrounding_infoDAOImpl dao = new Surrounding_infoDAOImpl();
		boolean judge = dao.rec(data);
		int result=0;
		if(judge == true) {
			result=1;
		}
		String info = "一条周边信息被修改，编号id："+id+"操作人："+manager+"\n";
		System.out.print(info);
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
