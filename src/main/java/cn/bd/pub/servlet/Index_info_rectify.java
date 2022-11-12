package cn.bd.pub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.IndexDAOImpl;
import cn.bd.manage.Index;

/**
 * Servlet implementation class Index_info_rectify
 */
public class Index_info_rectify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_info_rectify() {
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
		String onduty =  request.getParameter("onduty");
		String onduty_tel =  request.getParameter("onduty_tel");
		String other_info =  request.getParameter("other_info");
		String other =  "Ô¤Áô";
		Index data = new Index();

		data.setId(id);
		data.setOnduty(onduty);
		data.setOnduty_tel(onduty_tel);
		data.setOther(other);
		data.setOther_info(other_info);
		
		IndexDAOImpl dao = new IndexDAOImpl();
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
