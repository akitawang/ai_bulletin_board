<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cn.bd.pub.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <title>大屏数据管理 - 首页信息管理</title>
        <meta content="Admin Dashboard" name="description" />
        <meta content="Mannatthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

<!-- DataTables -->
        <link href="/ai_bulletin_board/assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link href="/ai_bulletin_board/assets/libs/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link href="/ai_bulletin_board/assets/libs/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="/ai_bulletin_board/assets/libs/datatables.net-select-bs4/css/select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

        <!-- Icons css -->
        <link href="/ai_bulletin_board/assets/libs/@mdi/font/css/materialdesignicons.min.css" rel="stylesheet" type="text/css" />
        <link href="/ai_bulletin_board/assets/libs/dripicons/webfont/webfont.css" rel="stylesheet" type="text/css" />
        <link href="/ai_bulletin_board/assets/libs/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css" />

		 <!-- Datatable js -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.html5.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.flash.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.print.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.colVis.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js" type="text/javascript"></script>
        <!-- Key Tables -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <!-- Selection table -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net-select/js/dataTables.select.min.js"></script>
        <!-- build:css -->
        <link href="/ai_bulletin_board/assets/css/app.css" rel="stylesheet" type="text/css" />
        
        <link href="/ai_bulletin_board/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="/ai_bulletin_board/assets/css/icons.css" rel="stylesheet" type="text/css">
        <link href="/ai_bulletin_board/assets/css/style.css" rel="stylesheet" type="text/css">

    </head>


    <body class="fixed-left">

        <!-- Loader -->
        <div id="preloader"><div id="status"><div class="spinner"></div></div></div>

        <!-- Begin page -->
        <div id="wrapper">

            <!-- ========== Left Sidebar Start ========== -->
            <%@include file="../tob_page/nav.jsp" %>
             <!-- end sidebarinner -->
            
            <!-- Left Sidebar End -->

                    <div class="page-content-wrapper ">

                        <div class="container-fluid">

                             <div style="padding-top:20px"> </div>

                       
                      
                        <div class="card bg-white m-b-30">
					<div class="card-body">
					<div class="form-group col-md-12">
                        	 <h4 class="header-title">首页信息管理</h4>
                         </div>
					<div class="general-label">
					<div class="jumbotron">
					  <p class="lead">直接在本页面可以修改大屏右侧值班人员信息！确认信息后点击刷新大屏，即可更新大屏信息！</p>
					
					</div>
					<div class="row">                                  
	                      <div class="form-group col-md-6">
	                          <label for="exampleInputEmail1">今日值班人员</label>
	                          <input type="text" class="form-control" id="onduty" name="onduty" value="<%=request.getAttribute("onduty") %>">
	                      </div>
	                      <div class="form-group col-md-6">
	                          <label for="exampleInputEmail1">值班人员联系方式</label>
	                          <input type="text" class="form-control" id="onduty_tel" name="onduty_tel" value="<%=request.getAttribute("onduty_tel") %>">
	                      </div>
                      </div>
                      <div class="row">                                  
	                      <div class="form-group col-md-6">
	                          <label for="exampleInputEmail1"> 右一模块其他信息 </label>
	                          <input type="text" class="form-control" id="other_info" name="other_info" value="<%=request.getAttribute("other_info") %>">
	                      </div>
	                      <div class="form-group col-md-6">
	                          <label for="exampleInputEmail1">预留信息位 </label>
	                          <input type="text" class="form-control" id="other" name="other" readonly="readonly" value="<%=request.getAttribute("other") %>">
	                      </div>
                      </div>

                      
                      <div style="padding-left:40%">
                      <button  id="rec" class="btn btn-primary">修改</button>
                      <a href="/ai_bulletion_board/Index" target="_blank"><button   class="btn btn-danger">刷新大屏</button> </a>
                      </div>
                     
                   
					</div>
					</div>
					</div>
                   
                   
                        
                  </div>
					
                    </div> <!-- Page content Wrapper -->

                </div> <!-- content -->

                <footer class="footer">
                    © 2022 大数据可视化管理系统   by Wang Xizhong 
                </footer>

           


        <!-- jQuery  -->
        <script src="/ai_bulletin_board/assets/js/jquery.min.js"></script>
        <script src="/ai_bulletin_board/assets/js/popper.min.js"></script>
        <script src="/ai_bulletin_board/assets/js/bootstrap.min.js"></script>
        <script src="/ai_bulletin_board/assets/js/modernizr.min.js"></script>
        <script src="/ai_bulletin_board/assets/js/detect.js"></script>
        <script src="/ai_bulletin_board/assets/js/fastclick.js"></script>
        <script src="/ai_bulletin_board/assets/js/jquery.slimscroll.js"></script>
        <script src="/ai_bulletin_board/assets/js/jquery.blockUI.js"></script>
        <script src="/ai_bulletin_board/assets/js/waves.js"></script>
        <script src="/ai_bulletin_board/assets/js/jquery.nicescroll.js"></script>
        <script src="/ai_bulletin_board/assets/js/jquery.scrollTo.min.js"></script>

        <!-- App js -->
        <script src="/ai_bulletin_board/assets/js/app.js"></script>
        
        <!-- select2 js -->
        <script src="/ai_bulletin_board/assets/libs/select2/js/select2.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/bootstrap-tagsinput/bootstrap-tagsinput.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/mohithg-switchery/switchery.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/bootstrap-maxlength/bootstrap-maxlength.min.js"></script>
        <!-- Mask input -->
        <script src="/ai_bulletin_board/assets/libs/jquery-mask-plugin/jquery.mask.min.js"></script>
        <!-- Bootstrap Select -->
        <script src="/ai_bulletin_board/assets/libs/bootstrap-select/js/bootstrap-select.min.js"></script>

        <script src="/ai_bulletin_board/assets/libs/bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>

        <script src="/ai_bulletin_board/assets/libs/bootstrap-colorpicker/js/bootstrap-colorpicker.min.js"></script>

        <script src="/ai_bulletin_board/assets/libs/moment/moment.js"></script>

        <script src="/ai_bulletin_board/assets/libs/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>

        <script src="/ai_bulletin_board/assets/libs/bootstrap-daterangepicker/daterangepicker.js"></script>
		<!-- Parsley js -->
        <script type="text/javascript" src="/ai_bulletin_board/assets/libs/parsleyjs/parsley.min.js"></script>

        <!-- Init Js file -->
        <script src="/ai_bulletin_board/assets/js/jquery.form-advanced.js"></script>

        <!-- Datatable js -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/dataTables.buttons.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.html5.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.flash.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.print.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons/js/buttons.colVis.min.js" type="text/javascript"></script>
        <script src="/ai_bulletin_board/assets/libs/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js" type="text/javascript"></script>
        <!-- Key Tables -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <!-- Selection table -->
        <script src="/ai_bulletin_board/assets/libs/datatables.net-select/js/dataTables.select.min.js"></script>

        
        <!-- Toastr js -->
        <script src="/ai_bulletin_board/assets/libs/jquery-toast-plugin/jquery.toast.min.js"></script>
        <script src="/ai_bulletin_board/assets/js/jquery.toastr.js"></script>

    </body>
     <script>

    		
  		 $(document).ready(function() {
			 $("#rec").click(function(){
   		          //得到input的值
   		          var onduty = $("#onduty").val();
   		      	  var onduty_tel = $("#onduty_tel").val();
   		      	  var other_info = $("#other_info").val();
   		      	  var other = $("#other").val();
	   		      	if(onduty == ''){
		    			alert("请您提交前先输入值班人！");
		    			return false;
		    		}
		    		else if(onduty_tel == ''){
		    			alert("请您提交前先输入联系方式！");
		    			return false;
		    		}
		    		else if(other_info == ''){
		    			alert("请您提交前先输入其他信息！");
		    			return false;
		    		}
   		          //设置linkToCart的href的值
   		          $.ajax({
	                url:"/ai_bulletin_board/Index_info_rectify?id=1&onduty="+onduty+"&onduty_tel="+onduty_tel+"&other_info="+other_info+"&other="+other,
	                type:"post",
	                success:function(data){
	                	if(data > 0){
	                		alert("操作成功");
	                	}
	                	else{
	                		alert("操作失败");
	                	}
	                },
	                error:function(data){
	                	alert("操作异常(请将以下内容截取给服务供应商以排除错误)：" +  data.responseText);
	                	
	                }
	            });
	            return false;
    		 });
  		});
    		 
    		

</script>
</html>