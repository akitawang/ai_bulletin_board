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
        <title>大屏数据管理 - 中部大图管理</title>
        <meta content="Admin Dashboard" name="description" />
        <meta content="Mannatthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

<!-- build:css -->
        <link href="/ai_bulletin_board/assets/css/app.css" rel="stylesheet" type="text/css" />        
        <link href="/ai_bulletin_board/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="/ai_bulletin_board/assets/css/icons.css" rel="stylesheet" type="text/css">
        <link href="/ai_bulletin_board/assets/css/style.css" rel="stylesheet" type="text/css">
		<!-- bootstrap 5.x or 4.x is supported. You can also use the bootstrap css 3.3.x versions -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" crossorigin="anonymous">
		 
		<!-- default icons used in the plugin are from Bootstrap 5.x icon library (which can be enabled by loading CSS below) -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.min.css" crossorigin="anonymous">
		 
		<!-- alternatively you can use the font awesome icon library if using with `fas` theme (or Bootstrap 4.x) by uncommenting below. -->
		<!-- link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" crossorigin="anonymous" -->
		 
		<!-- the fileinput plugin styling CSS file -->
		<link href="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
		 
		<!-- if using RTL (Right-To-Left) orientation, load the RTL CSS file after fileinput.css by uncommenting below -->
		<!-- link href="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/css/fileinput-rtl.min.css" media="all" rel="stylesheet" type="text/css" /-->
		 
		<!-- the jQuery Library -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
		 
		<!-- piexif.min.js is needed for auto orienting image files OR when restoring exif data in resized images and when you
		    wish to resize images before upload. This must be loaded before fileinput.min.js -->
		<script src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/plugins/piexif.min.js" type="text/javascript"></script>
		 
		<!-- sortable.min.js is only needed if you wish to sort / rearrange files in initial preview. 
		    This must be loaded before fileinput.min.js -->
		<script src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/plugins/sortable.min.js" type="text/javascript"></script>
		 
		<!-- bootstrap.bundle.min.js below is needed if you wish to zoom and preview file content in a detail modal
		    dialog. bootstrap 5.x or 4.x is supported. You can also use the bootstrap js 3.3.x versions. -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
		 
		<!-- the main fileinput plugin script JS file -->
		<script src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/fileinput.min.js"></script>
		 
		<!-- following theme script is needed to use the Font Awesome 5.x theme (`fas`). Uncomment if needed. -->
		<!-- script src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/themes/fas/theme.min.js"></script -->
		 
		<!-- optionally if you need translation for your language then include the locale file as mentioned below (replace LANG.js with your language locale) -->
		<script src="https://cdn.jsdelivr.net/gh/kartik-v/bootstrap-fileinput@5.2.5/js/locales/LANG.js"></script>
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
                        	 <h4 class="header-title">上传右侧广告位</h4>
                         </div>
					<div class="general-label">
					
					<div class="jumbotron">
					  <p class="lead">仅支持上传jpeg,jpg,png格式图片！</p>
					
					</div>



			<div class="file">
				<form enctype="multipart/form-data">
				        <p><input type="file" id="csv_file" name="csv_file" accept="image/jpeg,image/jpg,image/png"/></p>
				        <button id="import" type="button" class="btn btn-primary">上传</button>
				</form>
			    </div>
			    <script type="application/javascript">
			        $("#import").click(function () {
			            var files = $('#csv_file').prop('files');
			            var data = new FormData();
			            data.append('csv_file', files[0]);
			
			            $.ajax({
			                type: 'POST',
			                url: "/ai_bulletin_board/Ad_pic_upload",
			                data: data,
			                cache: false,
			                processData: false,
			                contentType: false,
			                success: function (data) {
			                	if(data > 0){
			                		alert("操作成功");
			                	}
			                	else{
			                		alert("操作失败");
			                	}
			                    alert(ret);
			                }
			            });
			        });
			    </script>
					    
						
					</div>
					</div>
					</div>
                   
                   

                         </div><!-- container -->
                        
                  
					
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

        
        <!-- Toastr js -->
        <script src="/ai_bulletin_board/assets/libs/jquery-toast-plugin/jquery.toast.min.js"></script>
        <script src="/ai_bulletin_board/assets/js/jquery.toastr.js"></script>

    </body>
     <script>	

     

</script>
</html>