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
		
		//ObjectMapper mapper = new ObjectMapper(); //�ṩjava-json�໥ת�����ܵ���
		//String json = mapper.writeValueAsString(lists); //��list�еĶ���ת��ΪJson��ʽ������
		//System.out.println(json);
		//��json���ݷ��ظ��ͻ���
		//response.setContentType("text/html; charset=utf-8");
		//response.getWriter().write(json);
			
		//������ת������Servlet��ת��showinfo.jspҳ�棬���Ҵ���request��response������ԭ�еĲ���
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
