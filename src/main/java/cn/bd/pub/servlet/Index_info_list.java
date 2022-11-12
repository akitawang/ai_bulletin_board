package cn.bd.pub.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.bd.dao.manageimpl.IndexDAOImpl;
import cn.bd.dao.manageimpl.Surrounding_infoDAOImpl;
import cn.bd.manage.Surrounding_info;

/**
 * Servlet implementation class Index_info_list
 */
public class Index_info_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index_info_list() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
	
		IndexDAOImpl impl = new IndexDAOImpl();
		String lists[] = impl.getall();
		request.setAttribute("onduty", lists[0]);
		request.setAttribute("onduty_tel", lists[1]);
		request.setAttribute("other_info", lists[2]);
		request.setAttribute("other", lists[3]);
		
		//ObjectMapper mapper = new ObjectMapper(); //提供java-json相互转换功能的类
		//String json = mapper.writeValueAsString(lists); //将list中的对象转换为Json格式的数组
		//System.out.println(json);
		//将json数据返回给客户端
		//response.setContentType("text/html; charset=utf-8");
		//response.getWriter().write(json);
			
		//这里是转发，从Servlet跳转到showinfo.jsp页面，并且带上request和response对象中原有的参数
		request.getRequestDispatcher("./tob_page/index_information.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
