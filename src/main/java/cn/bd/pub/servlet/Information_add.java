package cn.bd.pub.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.InformationDAOImpl;
import cn.bd.dao.manageimpl.Urgent_infoDAOImpl;
import cn.bd.manage.Information;
import cn.bd.manage.Urgent_info;

/**
 * Servlet implementation class Information_add
 */
public class Information_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Information_add() {
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
		String contact = request.getParameter("contact");
		String content= request.getParameter("content");
		String manager= request.getParameter("manager");
		
		InformationDAOImpl impl = new InformationDAOImpl();
		Information data = new Information();
		
	
		data.setContact(contact);
		data.setContent(content);
		data.setManager(manager);
		data.setTime(time);
		
		String info = time + "添加一项公共信息" + "经办人：" + manager + "失败";
		int j = 0;
		boolean judge = impl.add(data);
		if(judge == true) {
			info = time + "添加一项公共信息" + "经办人：" + manager + "成功";
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
