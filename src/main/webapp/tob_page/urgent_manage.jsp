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
        <title>大屏数据管理 - 紧急信息管理</title>
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
                        	 <h4 class="header-title">添加紧急信息</h4>
                         </div>
					<div class="general-label">
					<form method = "get" id="pass" action="/ai_bulletin_board/Urgent_info_add">
					<div class="row">
	                      <div class="form-group col-md-6">
	                          <label for="exampleInputEmail1">标题</label>
	                          <input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
	                      </div>
	                      <div class="form-group col-md-6">
	                          <label for="exampleInputEmail1">添加人</label>
	                          <input type="text" class="form-control" id="manager" name="manager" placeholder="请输入您的姓名">
	                      </div>

                    </div>
                    <div class="row">
                    	  <div class="form-groups col-md-12">
	                          <label for="exampleInputEmail1">内容</label>
	                          <textarea type="text" class="form-control" id="content" name="content" placeholder="请输入内容"></textarea>
	                      </div>
                    </div>  
 
                    <div style="padding-left:40%;padding-top:10px">
	                      <button type="submit" id="submitbutton" class="btn btn-primary">提交</button>
	                      <a href="/ai_bulletin_board/Urgent_info_list" class="btn btn-primary">刷新本页面</a>  
	                      <a href="/ai_bulletion_board/Index" target="_blank"><button   class="btn btn-danger">刷新大屏</button> </a>
                    </div>
 
                      
                   </form>      
                   
					</div>
					</div>
					</div>
                   
                   
                         <div class="row">
                    <div class="col-12">
                        <div class="card-box">
                        <div class="row">
                        <div class="form-group col-md-12">
                        	 <h4 class="header-title">紧急信息管理</h4>
                         </div>
                      </div>
                     
							
                           <table id="datatable-buttons" class="table table-hover mb-0">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>标题</th>
                                    <th>内容</th>
                                    <th>操作</th>
                                </tr>
                                </thead>


                                <tbody>
                                <c:forEach var="U" items="${list}" varStatus="status"> 
                                <tr>
                                	
                                    <td>${U.id}</td>
                                    <td>${U.title}</td>
                                    <td style="overflow:hidden">${U.content}</td>
                                    <td>
                                    	<a href="/ai_bulletin_board/tob_page/urgent_info.jsp?id=${U.id}&title=${U.title}&content=${U.content}&manager=${U.manager}&time=${U.time}">
                                    		<button  class="btn btn-info">
                                    		<i class="dripicons-document"></i> <span>操作</span>
										</button></a>
									</td>
									
                                </tr>
                                
                                
                               </c:forEach>
                                </tbody>
                            </table>
                            
                        </div>
                    </div>
                </div>
                <!-- end row -->        
                         </div><!-- container -->
                        
                  
					
                    </div> <!-- Page content Wrapper -->

                </div> <!-- content -->

                <footer class="footer">
                    © 2020 大数据可视化管理系统   by Wang Xizhong 
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
  		$(document).ready(function(){
    	        $("#pass").submit(function(e){
    	        	var vtitle = $('#title').val();
    	    		var vmanager = $('#manager').val();
    	    		var vcontent = $('#content').val();
    	    		if(vtitle == ''){
    	    			alert("请您提交前先输入标题！");
    	    			return false;
    	    		}
    	    		else if(vmanager == ''){
    	    			alert("请您提交前先输入添加人！");
    	    			return false;
    	    		}
    	    		else if(vcontent == ''){
    	    			alert("请您提交前先输入内容！");
    	    			return false;
    	    		}	
    	    		else{
    	        	$("#submitButton").attr('disabled',"true");
    	        	$.ajax({
    	                url:$("#pass").attr("action"),
    	                data:$('#pass').serialize(),
    	                type:"post",
    	                async:false,//一定要是同步请求，否则会跳转；（ajax默认是异步的）
    	                success:function(data){
    	                	if(data > 0){
    	                		alert("操作成功");window.location.href='/ai_bulletin_board/Urgent_info_list';
    	                	}
    	                	else{
    	                		alert("操作失败");
    	                	}
    	                	$("#submitButton").removeAttr("disabled");
    	                },
    	                error:function(data){
    	                	alert("操作异常(请将以下内容截取给服务供应商以排除错误)：" + $("#id").val() + data.responseText);
    	                	$("#submitButton").removeAttr("disabled");
    	                }
    	            });
    	        	return false;
    	    	   }
    	        });
    	    });
    		
    		
    	
    	
    		
    		 $(document).ready(function() {
                 // Default Datatable
                 $('#datatable').DataTable({
                     keys: true
                 });

                 //Buttons examples
                 var table = $('#datatable-buttons').DataTable({
                     lengthChange: false,
                     buttons:['copy', 'print','pageLength'　] ,
                     pageLength: 5,　//初始化显示几条数据
                     lengthMenu: [　
                         [5, 10, 20, -1],
                         ['5 条', '10 条', '20 条', '全部']
                     ],
                     language: {　　// 这是修改语言的显示
                         buttons: {
                             pageLength: {
                                 _: "显示%d条",
                                 '-1': "全部显示"
                             }
                         },
                         paginate: {
                             first: "首条",
                             previous: "前一页",
                             next: "下一页",
                             last: "末页"
                         },
                         "info": "第_PAGE_页,共_PAGES_页",
                         "infoEmpty": "未找到相关数据",
                         "search": "查找",
                         "zeroRecords": "未找到相关数据",
                         "decimal": ".",
                         "thousands": ",",
                         "Print":"打印",
                         "Copy":"复制内容"
                     }
                 });

                 table.buttons().container()
                         .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
             } );
    		 


</script>
</html>