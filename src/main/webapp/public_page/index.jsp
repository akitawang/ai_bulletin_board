<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cn.bd.pub.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="/ai_bulletin_board/public_page/css/BigData.css" rel="stylesheet" type="text/css" />
    <link href="/ai_bulletin_board/public_page/css/index.css" rel="stylesheet" type="text/css" />
    <link href="/ai_bulletin_board/public_page/css/index01.css" rel="stylesheet" type="text/css" />
    <script src="/ai_bulletin_board/public_page/js/jquery.js"></script>
    <link href="/ai_bulletin_board/public_page/js/bstable/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="/ai_bulletin_board/public_page/js/bstable/css/bootstrap-table.css" rel="stylesheet" type="text/css" />
    <link href="/ai_bulletin_board/public_page/css/Security_operation.css" rel="stylesheet" type="text/css" />
    <link href="/ai_bulletin_board/public_page/css/index_picture.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="/ai_bulletin_board/public_page/js/artDialog/skins/default.css" type="text/css"/>
    <script src="/ai_bulletin_board/public_page/js/laydate.js"></script>
    <script src="/ai_bulletin_board/public_page/js/Home_page.js"></script>
    <script src="/ai_bulletin_board/public_page/js/new_index.js"></script>
    <script src="/ai_bulletin_board/public_page/js/index_picture.js"></script>
    
    <!--preloader-->
    <link rel="stylesheet" href="/ai_bulletin_board/public_page/css/style.css">
    <link rel="stylesheet" href="/ai_bulletin_board/public_page/css/demo.css" />
    <meta charset="UTF-8">
    <title>大连市A社区智慧大屏</title>

</head>
<body >
<div class="data_bodey">

    <div class="index_nav" >
        <ul style="height: 30px; margin-bottom: 0px;">
            <li class="l_left total_chose_fr nav_active"><a href="./tob_page/login.jsp">A小区管理后台</a></li>
            <li class="l_left total_chose_fr nav_active"><a href="/ai_bulletin_board/Index">刷新</a></li>
            <li class="r_right total_chose_pl" >当前时间：<span id="time"></span></li>
        </ul>
    </div>
    
    <div class="index_tabs" >
        <!--安防运作-->
        <div class="inner" style="height: 109%;">

            <div class="left_cage">
                <div class="dataAllBorder01 cage_cl" style="margin-top: 9% !important; height: 24%;">
                    
                    <img class="dataAllBorder02 video_cage" src="/ai_bulletin_board/public_page/video/video.jpg">
                </div>
                <!--社区图片公告-->
                <div class="dataAllBorder01 cage_cl" style="margin-top: 1.5% !important; height: 38%;">
                    <div class="dataAllBorder02 video_cage">

                        <img class="video_around" src="<%=request.getAttribute("Left_pic1") %>">
   						<img class="video_around" src="<%=request.getAttribute("Left_pic2") %>">

                    </div>
                </div>
                <div class="dataAllBorder01 cage_cl" style="margin-top: 1.5% !important; height: 32%; position: relative;">
                    <div class="dataAllBorder02" style="padding: 1.2%; overflow: hidden">
					<div class="message_scroll_box"  >
					 
						<c:forEach var="U" items="${Information}" varStatus="status"> 
							   
	                            <div class="message_scroll">
	                            <div class="scroll_top">
	                                <span class="scroll_title">社区公开信息</span>
	                                <span class="scroll_timer">${U.time}</span>
	                            </div>
	                            <div class="msg_cage">
	                                <a class="localize_msg">联系人：${U.contact}</a>
	                            </div>
	                            <div class="msg_cage">
	                                <a class="localize_msg">${U.content}</a>
	                            </div>
	                        </div>
						</c:forEach>
					
                    </div>

                    </div>
                </div>
            </div>

            <div class="center_cage">
                <div class="dataAllBorder01 cage_cl" style="margin-top: 3.5% !important; height: 62.7%; position: relative;">
                    <div class="dataAllBorder02" style="position: relative; overflow: hidden;">
                        <!--标题栏-->
                        <div class="map_title_box" style="height: 6%">
                            <div class="map_title_innerbox">
                                <div class="map_title">社区宣传</div>
                            </div>
                        </div>
                        <div class="map">
							<img src="<%=request.getAttribute("Big_pic") %>" class="map" alt="">
                        </div>
                        
                        
                    </div>
                </div>

                <div class="dataAllBorder01 cage_cl" style="margin-top: 0.6% !important; height: 32.1%;">
                    <div class="dataAllBorder02" id="map_title_innerbox">
                        <div class="map_title_box">
                            <div class="map_title_innerbox">
                                <div class="map_title" style="background-image: url(/ai_bulletin_board/public_page/img/second_title.png);">社区紧急公告</div>
                            </div>
                        </div>
						<c:forEach var="A" items="${Urgent_info}" varStatus="status"> 
							<div style="width:25%; height:85%; float:left;">
		                        <table class="table table-bordered" style="height:100%;" border="1">
	                                <tbody>
	                                <tr class="info">
								     <th  style="height:20%;" ><h5>${A.title}</h5></th>
								   </tr>
								   <tr  class="info">
								     <td  style="height:80%;">${A.content}
								     <span>发布人：${A.manager}</span>
								     </td>
								     
								   </tr>
	                                </tbody>
	                            </table>
                        	</div>
						</c:forEach>


                    </div>
                </div>
            </div>

            <div class="right_cage">
                <div class="dataAllBorder01 cage_cl" style="margin-top: 9% !important; height: 24%">
                    <div class="dataAllBorder02">
	                    <div class="analysis">大连公共信息</div>
	                    <iframe style="margin-top: 0.05%" width="100%" height="10%" frameborder="0" scrolling="no" hspace="0" src="https://i.tianqi.com/?c=code&a=getcode&id=40&icon=1"></iframe>
                        <div class="depart_number_box">
                            <ul class="depart_number_cage">
                                <li class="depart_name">现存确诊数量：</li>
                                <li class="depart_number"><%=request.getAttribute("number") %></li>
                            </ul>
                            <ul class="depart_number_cage">
                                <li class="depart_name">累计确诊数量：</li>
                                <li class="depart_number"><%=request.getAttribute("confirmedCount") %></li>
                            </ul>
                        </div>
                        
                        <div class="message_scroll">
                        	<ul  class="data_show_box">
	                            <li class="depart_name"><h5>今日值班人：<%=request.getAttribute("onduty") %></h5></li>
	                            <li class="depart_name"><h5>联系电话：<%=request.getAttribute("onduty_tel") %></h5></li>
	                            <li class="depart_name"><h5><%=request.getAttribute("other_info") %></h5></li>
	                         </ul>
	                    </div>
	                   
                    </div>
			</div>
                <div class="dataAllBorder01 cage_cl" style="margin-top: 1.5% !important; height: 38%;">
                    <!--切换01-->
                    <div class="dataAllBorder02" style="padding: 1.2%; overflow: hidden">
                    <div class="analysis">本地信息栏</div>
                    	<marquee direction="up">
                        <div>
						<c:forEach var="B" items="${Surrounding_info}" varStatus="status"> 
							   
	                            <div class="message_scroll">
	                            <div class="scroll_top">
	                                <span class="scroll_title">${B.type}</span>
	                                <span class="scroll_timer">${B.time}</span>
	                            </div>
	                            <div class="msg_cage">
	                                <a class="localize_msg">${B.content}</a>
	                            </div>
	                        	</div>
						</c:forEach>
                    	</div>
                    	</marquee>
                    </div>
               </div>
               
				<div class="dataAllBorder01 cage_cl" style="margin-top: 1.5% !important; height: 32%; position: relative;">
                    <img class="dataAllBorder02 video_cage" src="<%=request.getAttribute("ad_pic") %>">
                </div>

           </div>
            
		</div>
    </div>
</div>

<script src="/ai_bulletin_board/public_page/js/echarts-all.js"></script>
<script src="/ai_bulletin_board/public_page/js/index.js"></script>
<script src="/ai_bulletin_board/public_page/js/bstable/js/bootstrap.min.js"></script>
<script src="/ai_bulletin_board/public_page/js/bstable/js/bootstrap-table.js"></script>
<script type="text/javascript" src="/ai_bulletin_board/public_page/js/jquery.pagination.js"></script>
<script src="/ai_bulletin_board/public_page/js/bstable/js/bootstrap-table-zh-CN.min.js"></script>

    <!--<script src="js/MainMap.js"></script>-->
<script src="/ai_bulletin_board/public_page/js/Home_page.js"></script>
<script src="/ai_bulletin_board/public_page/js/artDialog/artDialog.js"></script>
<script src="/ai_bulletin_board/public_page/js/artDialog/plugins/iframeTools.source.js"></script>
<script>
    var number;
    $(function() {
        if (window.screen.height <= 768) {
            number = 4;
        } else if (window.screen.height > 768 && window.screen.height <= 900) {
            number = 6
        } else if (window.screen.height > 1080) {
            number = 8
        }
    });
</script>
<script>
    function TimeControl(){
        $(".message_scroll_box").animate({marginTop:96},800,
                function(){
                    $(".message_scroll_box").css({marginTop:0});    //把顶部的边界清零
                    $(".message_scroll_box .message_scroll:first").before($(".message_scroll_box .message_scroll:last"));    //在第一个新闻后面插入最后一个新闻

                });
    }
    var T=setInterval(TimeControl,2300);    //开始定时
    $(".message_scroll_box").mouseenter(function(){
        clearInterval(T);    //停止定时
    })
            .mouseleave(function(){
                T=setInterval(TimeControl,2500);    //再次定时
            })

</script>

</body>
</html>





