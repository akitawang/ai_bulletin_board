package cn.bd.pub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.Urgent_infoDAOImpl;
import cn.bd.manage.Urgent_info;


/**
 * Servlet implementation class Urgent_info_list
 */
public class Urgent_info_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Urgent_info_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
	
		Urgent_infoDAOImpl impl = new Urgent_infoDAOImpl();
		List<Urgent_info> lists=new ArrayList<Urgent_info>();
		lists = impl.getall();
		request.setAttribute("list", lists);
			
		//这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
		request.getRequestDispatcher("./tob_page/urgent_manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
