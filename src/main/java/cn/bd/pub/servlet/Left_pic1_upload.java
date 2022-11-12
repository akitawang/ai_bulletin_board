package cn.bd.pub.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.bd.dao.manageimpl.Left_picDAOImpl;
import cn.bd.manage.Left_pic;

/**
 * Servlet implementation class Left_pic1_upload
 */
public class Left_pic1_upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Left_pic1_upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码为utf-8
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		FileItemFactory factory = new DiskFileItemFactory();
		 
         // 文件上传处理器
         ServletFileUpload upload = new ServletFileUpload(factory);
 
         // 解析请求信息
         List items = null;
         try {
             items = upload.parseRequest(request);
         }
         catch (FileUploadException e) {
             e.printStackTrace();
         }
 
         // 对请求信息进行判断
         Iterator iter = items.iterator();
         while (iter.hasNext()) {
             FileItem item = (FileItem) iter.next();
             // 信息为普通的格式
             if (item.isFormField()) {
                 String fieldName = item.getFieldName();
                 String value = item.getString();
                 request.setAttribute(fieldName, value);
             }
             // 信息为文件格式
             else {
            	 String fileName = item.getName();//获得上传图片的名称
                 Date now = new Date();
         		 SimpleDateFormat sf = new SimpleDateFormat("MM_dd_hh_ss_mm");
         		 String pubtime = sf.format(now);
                 fileName = pubtime+item.getName();

                 request.setAttribute("realFileName", fileName);
                 String basePath =  "D:/akita/pic/";
                 File file = new File(basePath, fileName);
                 try {
					item.write(file);
					Left_pic data = new Left_pic();
					data.setPic1(basePath+fileName);
					System.out.println(basePath+fileName);//打印当前位置
					Left_picDAOImpl dao = new Left_picDAOImpl();
					boolean judge = dao.rec1(data);
					int result=0;
					if(judge == true) {
						result=1;
					}
					response.getWriter().println(result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
             }
            
         }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
