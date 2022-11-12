package cn.bd.pub.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.Surrounding_infoDAOImpl;
import cn.bd.manage.Surrounding_info;

/**
 * Servlet implementation class Surrounding_info_add
 */
public class Surrounding_info_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Surrounding_info_add() {
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
		String content= request.getParameter("content");
		String manager= request.getParameter("manager");
		String type= request.getParameter("type");
		
		Surrounding_infoDAOImpl impl = new Surrounding_infoDAOImpl();
		Surrounding_info data = new Surrounding_info();
		data.setType(type);
		data.setContent(content);
		data.setManager(manager);
		data.setTime(time);
		
		String info = time + "添加一项周边公共信息" + "经办人：" + manager + "失败\n";
		int j = 0;
		boolean judge = impl.add(data);
		if(judge == true) {
			info = time + "添加一项周边公共信息" + "经办人：" + manager + "成功\n";
			j = 1;
		}
		System.out.print(info);
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
