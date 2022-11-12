package cn.bd.pub.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.InformationDAOImpl;
import cn.bd.dao.manageimpl.Surrounding_infoDAOImpl;

/**
 * Servlet implementation class Surrounding_info_del
 */
public class Surrounding_info_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Surrounding_info_del() {
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
		 
		Surrounding_infoDAOImpl impl = new Surrounding_infoDAOImpl();
		boolean judge = impl.del(id);
		int result=0;
		if(judge == true) {
			result=1;
		}
		String info = "一条周边信息被删除，编号id："+id+"\n";
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
