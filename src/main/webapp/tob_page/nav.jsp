<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.bd.user.*"   %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<%
	Admin user = (Admin)session.getAttribute("user");
	
	if(user==null)
	{
		response.setHeader("refresh", "0;url=/ai_bulletin_board/tob_page/login.jsp");
	}
	
	else if(user!=null)
	{
	
%>
<!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <button type="button" class="button-menu-mobile button-menu-mobile-topbar open-left waves-effect">
                    <i class="ion-close"></i>
                </button>

                <!-- LOGO -->
                <div class="topbar-left">
                    <div class="text-center">
                        <a href="/ai_bulletin_board/tob_page/index.jsp" class="logo"><i class="mdi mdi-assistant"></i> 大连A社区管理系统</a>
                        <!-- <a href="index.html" class="logo"><img src="assets/images/logo.png" height="24" alt="logo"></a> -->
                    </div>
                </div>

                <div class="sidebar-inner slimscrollleft">

                    <div id="sidebar-menu">
                        <ul>
                            <li>
                                <a href="/ai_bulletin_board/tob_page/index.jsp" class="waves-effect"><i class="mdi mdi-airplay"></i><span> 首页/控制台</span></a>
                            </li>
                            <li>
                                <a href="/ai_bulletin_board/Index_info_list" class="waves-effect"><i class="mdi mdi-vector-square"></i><span>首页信息管理</span></a>
                            </li>
                            <li>
                                <a href="/ai_bulletin_board/Information_list" class="waves-effect"><i class="mdi mdi-vector-polyline"></i><span>左部公共信息管理</span></a>
                            </li>
                            <li>
                                <a href="/ai_bulletin_board/tob_page/left_pic_upload.jsp" class="waves-effect"><i class=" mdi mdi-led-on"></i><span>左部公示图片管理 </span></a>
                            </li>
                            <li>
                                <a href="/ai_bulletin_board/tob_page/big_pic_upload.jsp" class="waves-effect"><i class=" mdi mdi-bullhorn"></i><span>中部大屏图片管理 </span></a>
                            </li> 
                            <li>
                                <a href="/ai_bulletin_board/Urgent_info_list" class="waves-effect"><i class="mdi mdi-map"></i><span>中部紧急信息管理</span></a>
                            </li>  
                            <li>
                                <a href="/ai_bulletin_board/Surrounding_info_list" class="waves-effect"><i class="mdi mdi-map"></i><span>右部周边信息管理</span></a>
                            </li>  
                            <li>
                                <a href="/ai_bulletin_board/tob_page/ad_pic_upload.jsp" class="waves-effect"><i class=" mdi mdi-bullhorn"></i><span>右部广告位图片管理 </span></a>
                            </li> 
                            <li>
                                <a href="/ai_bulletin_board/tob_page/analysis.jsp" class="waves-effect"><i class=" mdi mdi-bullhorn"></i><span>数据分析 </span></a>
                            </li> 
                        </ul>
                       
                    </div>
                    <div class="clearfix"></div>
                </div> <!-- end sidebarinner -->
            </div>
            <!-- Left Sidebar End -->

<!-- Start right Content here -->

            <div class="content-page">
                <!-- Start content -->
                <div class="content">

                    <!-- Top Bar Start -->
                    <div class="topbar">

                        <nav class="navbar-custom">

                            <ul class="list-inline float-right mb-0">
                                <!-- data index-->
                                <li class="list-inline-item dropdown notification-list">
                                    <a class="nav-link dropdown-toggle arrow-none waves-effect text-white" data-toggle="dropdown" href="#" role="button"
                                        aria-haspopup="false" aria-expanded="false">
                                        快捷菜单 <img src="/ai_bulletin_board/tob_page/assets/images/index_data.png" class="ml-2" height="16" alt=""/>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-menu-lg">
                                       <div class="dropdown-item noti-title">
                                            <h5>欢迎</h5>
                                        </div>
                                        <!-- item-->
                                        
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/tob_page/index.jsp" class="waves-effect"><i class="mdi mdi-airplay"></i><span> 首页/控制台</span></a>
				                            </div>
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/Index_info_list" class="waves-effect"><i class="mdi mdi-vector-square"></i><span>首页信息管理</span></a>
				                            </div>
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/Information_list" class="waves-effect"><i class="mdi mdi-vector-polyline"></i><span>左部公共信息管理</span></a>
				                            </div>
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/tob_page/left_pic_upload.jsp" class="waves-effect"><i class=" mdi mdi-led-on"></i><span>左部公示图片管理 </span></a>
				                            </div>
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/tob_page/big_pic_upload.jsp" class="waves-effect"><i class=" mdi mdi-bullhorn"></i><span>中部大屏图片管理 </span></a>
				                            </div> 
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/Urgent_info_list" class="waves-effect"><i class="mdi mdi-map"></i><span>中部紧急信息管理</span></a>
				                            </div>  
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/Surrounding_info_list" class="waves-effect"><i class="mdi mdi-map"></i><span>右部周边信息管理</span></a>
				                           </div>  
				                            <div class="notify-icon">
				                                <a href="/ai_bulletin_board/tob_page/ad_pic_upload.jsp" class="waves-effect"><i class=" mdi mdi-bullhorn"></i><span>右部广告位图片管理 </span></a>
				                            </div> 
                                    </div>
                                   
                                </li>
                                <li class="list-inline-item dropdown notification-list">
                                    <a class="nav-link dropdown-toggle arrow-none waves-effect text-white" data-toggle="dropdown" href="#" role="button"
                                        aria-haspopup="false" aria-expanded="false">
                                        显示 <img src="/ai_bulletin_board/tob_page/assets/images/index_data.png" class="ml-2" height="16" alt=""/>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-menu-lg">
                                       <div class="dropdown-item noti-title">
                                            <h5>欢迎</h5>
                                        </div>
                                        <!-- item-->
                                        <a href="/ai_bulletin_board/Index" target="_blank" class="dropdown-item notify-item">
                                            <div class="notify-icon">
                                            	<img src="/ai_bulletin_board/tob_page/assets/images/index_data2.png" alt="user-img" class="img-fluid rounded-circle" /> 
                                            </div>
                                            <p class="notify-details"><b>公共页面1显示</b><small class="text-muted">公共页面1</small></p>
                                        </a>
										<a href="#" class="dropdown-item notify-item">
                                            <div class="notify-icon"><img src="/ai_bulletin_board/tob_page/assets/images/index_data2.png" alt="user-img" class="img-fluid rounded-circle" /> </div>
                                            <p class="notify-details"><b>公共页面2显示</b><small class="text-muted">公共页面2(未开放)</small></p>
                                        </a>
                                    </div>
                                   
                                </li>
                                

                                <li class="list-inline-item dropdown notification-list">
                                    <a class="nav-link dropdown-toggle arrow-none waves-effect nav-user" data-toggle="dropdown" href="#" role="button"
                                       aria-haspopup="false" aria-expanded="false" >
                                     	  <font color="white"> 欢迎您！<%=user.getUsername() %></font>
                                    </a>
                                    <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                                        <!-- item-->
                                        <div class="dropdown-item noti-title">
                                            <h5>欢迎使用</h5>
                                        </div>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="/ai_bulletin_board/Logout"><i class="mdi mdi-logout m-r-5 text-muted"></i> 登出</a>
                                    </div>
                                </li>

                            </ul>
							
                            <div class="clearfix"></div>

                        </nav>

                    </div>
                    <!-- Top Bar End -->
                   
      <%} %>
      




</body>
</html>