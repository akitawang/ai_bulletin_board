package cn.bd.pub.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bd.dao.manageimpl.Ad_picDAOImpl;
import cn.bd.dao.manageimpl.Big_imgDAOImpl;
import cn.bd.dao.manageimpl.IndexDAOImpl;
import cn.bd.dao.manageimpl.InformationDAOImpl;
import cn.bd.dao.manageimpl.Left_picDAOImpl;
import cn.bd.dao.manageimpl.Surrounding_infoDAOImpl;
import cn.bd.dao.manageimpl.Urgent_infoDAOImpl;
import cn.bd.manage.Information;
import cn.bd.manage.Surrounding_info;
import cn.bd.manage.Urgent_info;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//夺取新冠疫情信息
		StringBuilder json = new StringBuilder();
		URL url=new URL("https://lab.isaaclin.cn/nCoV/api/area?latest=1&province=%E8%BE%BD%E5%AE%81%E7%9C%81");  
        //打开URL  
		HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();  
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)"); //防止报403错误。  
        //获取服务器响应代码  
        int responsecode = urlConnection.getResponseCode();  
        if(responsecode==200){  
            //得到输入流，即获得了网页的内容   
           BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));  
           String inputLine = null;
           while ( (inputLine = reader.readLine()) != null) {
               json.append(inputLine);
           }
           reader.close(); 
           int number = 0;
           int confirmedCount = 0;
           String jsonstring = json.toString();
           JSONObject str = JSONObject.fromObject(jsonstring);
           if(str.has("results")) {
           	JSONArray results = str.getJSONArray("results");
           	for(int i=0;i<results.size();i++) {
           		String t = results.getString(i);                           //遍历过程将web数组元素赋给String型变量
           		JSONObject we = JSONObject.fromObject(t);             //通过String又得到每个元素的对象
           		if(we.has("cities")) {
           			JSONArray cities = we.getJSONArray("cities");
           			for(int j=0;j<cities.size();j++) {
           				String tt = cities.getString(j);                           //遍历过程将web数组元素赋给String型变量
                   		JSONObject wee = JSONObject.fromObject(tt);             //通过String又得到每个元素的对象
                   		if(wee.getString("cityName").equals("大连")) {
                   			number = Integer.parseInt(wee.getString("currentConfirmedCount"));
                   			confirmedCount = Integer.parseInt(wee.getString("confirmedCount"));
                   		}
           			}
           		}
           	}
           }
           	System.out.print("获取当地确诊人数总数成功！"+"\n");  //数据来源：https://lab.isaaclin.cn/nCoV/
           	request.setAttribute("number", number);
           	request.setAttribute("confirmedCount", confirmedCount);
           	
        }  
        else{  
        	System.out.print("获取不到网页的源码，服务器响应代码为："+responsecode+"\n");  
        	request.setAttribute("number", -1);
        } 
        
        
        // 获取四条紧急紧急信息
        Urgent_infoDAOImpl impl = new Urgent_infoDAOImpl();
		List<Urgent_info> lists=new ArrayList<Urgent_info>();
		lists = impl.getOne();
		request.setAttribute("Urgent_info", lists);
		
		// 获取六条公开信息
        InformationDAOImpl InformationDAOImpl = new InformationDAOImpl();
		List<Information> Informationlists=new ArrayList<Information>();
		Informationlists = InformationDAOImpl.getOne();
		request.setAttribute("Information", Informationlists);
		
		// 获取两张左图
        Left_picDAOImpl Left_picDAOImpl = new Left_picDAOImpl();
		String Left_piclists[] = Left_picDAOImpl.getOne();
		File Left_picliststempFile =new File( Left_piclists[0].trim());  
        String Left_piclistsfileName = Left_picliststempFile.getName();
        String Left_pic1 = "../images/"+Left_piclistsfileName;
        File Left_picliststempFile2 =new File( Left_piclists[1].trim());  
        String Left_piclistsfileName2 = Left_picliststempFile2.getName();
        String Left_pic2 = "../images/"+Left_piclistsfileName2;
		request.setAttribute("Left_pic1", Left_pic1);
		request.setAttribute("Left_pic2", Left_pic2);
		System.out.print("左部公告图片1加载完成，路径："+Left_pic1+"\n");
		System.out.print("左部公告图片2加载完成，路径："+Left_pic2+"\n");
		// 获取中间大图
        Big_imgDAOImpl Big_imgDAOImpl = new Big_imgDAOImpl();
		String big_piclists = Big_imgDAOImpl.getOnep();
		File tempFile =new File( big_piclists.trim());  
        String fileName = tempFile.getName();  
        String big_picname = "../images/"+fileName;
		request.setAttribute("Big_pic", big_picname);
		System.out.print("首页中部大图加载完成，路径："+big_picname+"\n");
		
		// 获取右部周围信息
        Surrounding_infoDAOImpl Surrounding_infoDAOImpl = new Surrounding_infoDAOImpl();
		List<Surrounding_info> Surrounding_infolists=new ArrayList<Surrounding_info>();
		Surrounding_infolists = Surrounding_infoDAOImpl.getall();
		request.setAttribute("Surrounding_info", Surrounding_infolists);
		
		// 获取右部第一栏信息
        IndexDAOImpl IndexDAOImpl = new IndexDAOImpl();
        String IndexDAOImpllists[] = IndexDAOImpl.getall();
		request.setAttribute("onduty", IndexDAOImpllists[0]);
		request.setAttribute("onduty_tel", IndexDAOImpllists[1]);
		request.setAttribute("other_info", IndexDAOImpllists[2]);
        
		// 获取右侧广告位
        Ad_picDAOImpl Ad_picDAOImpl = new Ad_picDAOImpl();
		String ad_piclists = Ad_picDAOImpl.getOnep();
		File astempFile =new File( ad_piclists.trim());  
        String asfileName = astempFile.getName();  
        String as_picname = "../images/"+asfileName;
		request.setAttribute("ad_pic", as_picname);
		System.out.print("右图广告加载完成，路径："+as_picname+"\n");
		System.out.println("用户访问系统，ip为："+InetAddress.getLocalHost().getHostAddress());
        
        request.getRequestDispatcher("./public_page/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
