<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>文章管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
 <link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<style>
	body .demo-class .layui-layer-title{background:#4476A7; color:#fff; border: none;}
	body .demo-class .layui-layer-btn{border-top:1px solid #4476A7}
	body .demo-class .layui-layer-btn a{background:#4476A7;}
	body .demo-class .layui-layer-btn .layui-layer-btn1{background:#4476A7;}
	body .demo-class .layui-layer-page .layui-layer-content {background-color: #e13e4;}
	tbody .layui-table-cell {
	    font-size:14px;
	    padding:0 5px;
	    height:100px;
	    overflow:visible;
	    text-overflow:inherit;
	    white-space:normal;
	    word-break: break-all;
	}
</style>
<body>

  <div class="layui-fluid" style="margin-top: 10px">
		<!--第一列结束-->
		<div class="layui-col-md12 layui-col-lg12 layui-col-space20">
			<div class="layui-row">
				<div class="layui-fluid layui-col-md12 layui-col-lg12">
					<div class="layui-card">
						<div class="layui-card-header">
							<span style="font-size:18px;">文章信息</span>
							<!-- <div style="float:right">
								<button class="layui-btn layui-btn-sm layui-btn-normal">修改文章信息</button>
							</div> -->
						</div>
						<div class="layui-card-body">
							<div class="layui-row layui-col-space20">
								<div class="layui-col-lg12">
									<table class="layui-table" id="forumcontent">
										<tr>
											<td>文章主标题</td>
											<td>${forum.tite }</td>
										</tr>
										
										<tr>
											<td>发表日期</td>
											<td>${forum.articlescreatetime }</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--第二列第一行结束-->
			<div class="layui-row">
				<div class="layui-container layui-col-md12 layui-col-lg12">
					<div class="layui-card ">
						<div class="layui-card-header">文章内容管理<button style="margin-left: 50px;" id="btn_addcontent" class="layui-btn  layui-btn-sm layui-btn-normal">添加内容</button></div>
						<div class="layui-card-body">
							<table id="contentlist" style="text-align: center;" lay-filter="tool" class="layui-table"></table>
							<!-- <table class="layui-table" lay-skin="line">
								<tr>
									<td>美丽西山大昆明</td>
									<td>图片</td>
									<td>测试内容</td>
									<td><button class="layui-btn btn_addcontent layui-btn-sm layui-btn-normal">编辑</button></td>
								</tr>
							</table> -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
<script src="../layui/layui.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-normal layui-btn-md edit" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
	<a class="layui-btn layui-btn-warm layui-btn-md del" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
</script>
<script>
layui.use(['layer','upload','table','jquery','form'], function(){
	var layer = layui.layer,
	form=layui.form,
	table=layui.table,
	$=layui.jquery,
	upload = layui.upload;
	/*加载表格*/
	table.render({
		elem : '#contentlist',
		id:'contentlist',
		url : '../articles/getarticlescontent?articlesid=${forum.articlesid}',
		title : '文章数据表',
		even : true,
		cols : [ 
		     [ {
				type : 'numbers',
				title : '序号',
				align : 'center'
			}, {
			    field : 'picpath',
			    align : 'center',
			    title : '图片',
			    style:'height:100px;',
				templet:function(data){
					return '<img style="width: 150px;height:100%" src= "'+data.photoname+'">' 
				}
			}, {
			    field : 'articlesidcontent',
			    title : '文章内容',
			    align : 'center', 
    		},{
				title : '操作',
				toolbar : '#barDemo',
				align : 'center'
			}]
		]
	});
	
	//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					},
					function(index,layero){
						$.ajax({
								type : "post",
								url : "../articles/delarticlescontent",
								data : {
									articlescontentid : data.articlescontentid
								},
								dataType : "json",
								success : function(data) {
									if(data.code == 0){
				        				layer.confirm(data.msg, {
										  btn: ['确定']
										}, function(){
											table.reload("contentlist", { //此处是上文提到的 初始化标识id
								                where: {
								                	keyword:data.code=='0'
								                }
								            });	
											layer.closeAll();
										});          				 
			        				}
				        			else{
				        				layer.confirm(data.msg, { btn: ['确定'] });
				        			}
								},
								error : function() {
									layer.msg('请求失败，稍后再试',{icon : 5});
								}
				
							}); 
					});
				break;
				/* 编辑文章标题按钮 */
				case 'edit': 
		            $("#edtphotoid").val(data.photoid);
		            $("#edtphotopath").attr("src",data.photoname);
		            $("#edtcontenttext").val(data.articlesidcontent);
			        layer.open({
						title:"编辑一个博文内容",
						type: 1,
						area: ['500px'],
						
						btn:['保存'],
						maxmin: true,//显示最大化最小化按钮
						//offset: 'b', 弹框的位置
						content: $('#div_edtcontent'),
						btn1: function(index, layero){ 
				            $.ajax({
								type : "post",
								url : "../articles/updatearticlescontent",
								data : {
									articlescontentid : data.articlescontentid,
									articlesid : data.articlesid,
									ordernum : data.ordernum,
									photoid: $("#edtphotoid").val(),
									issign : data.issign,
									state : data.state,
									articlesidcontent :  $("#edtcontenttext").val(),
								},
								dataType : "json",
								success : function(data) {
									if(data.code == 0){
				        				layer.confirm(data.msg, {
				        				icon: 1,
										  btn: ['确定']
										}, function(){ 
											table.reload("contentlist", { //此处是上文提到的 初始化标识id
								                where: {
								                	
								                },page: {
								                curr:1
								                }
								            });	
											layer.closeAll();
										});          				 
				        			}
				        			else{
				        				layer.confirm(data.msg, {
				        					  icon: 7,
											  btn: ['确定']
										});
				        			}
								},
								error : function() {
									layer.msg('请求失败，稍后再试',{icon : 5});
								}
				
							});
						},
						cancel: function(){ 
							$("#edtcontentid").val("");
				            $("#edtphotopath").attr("src","");
				            $("#edtcontenttext").text("");
				            $("#edtphotoid").val("");
						}
					});
				break; 
			};
		});
		
	
	
	//添加内容按钮点击事件
	$("#btn_addcontent").click(function(){
		layer.open({
			title:"编写一个博文内容",
			type: 1,
			area: ['500px'],
			
			btn:['添加'],
			maxmin: true,//显示最大化最小化按钮
			content: $('#div_addcontent'),
			btn1: function(index, layero){
	            var textcontent = $("#contenttext").val();
	            var photoid = $("#photoid").val();
 				$.ajax({
					type : "post",
					url : "../articles/addarticlestcontent",
					data : {
						articlesid : ${forum.articlesid},
						photoid : photoid,
						articlesidcontent : textcontent
					},
					dataType : "json",
					success : function(data) {
						if(data.code == 0){
	        				layer.confirm(data.msg, {
	        				icon: 1,
							  btn: ['确定']
							}, function(){
							$("#contentid").val("");
				            $("#photopath").attr("src","../image/defaultuser.jpg");
				            $("#contenttext").text("");
				            $("#photoid").val("");
								table.reload("contentlist", { //此处是上文提到的 初始化标识id
					                where: {
					                	
					                },page: {
					                curr:1
					                }
					            });	
								layer.closeAll();
							});          				 
	        			}
	        			else{
	        			
	        				layer.confirm(data.msg, {
	        					  icon: 7,
								  btn: ['确定']
							},function(){
								$("#contentid").val("");
					            $("#photopath").attr("src","../image/defaultuser.jpg");
					            $("#contenttext").text("");
					            $("#photoid").val("");
							});
	        			}
	        			
					},
					error : function() {
						layer.msg('请求失败，稍后再试',{icon : 5});
					}
	
				});
			},
			cancel: function(){ 
				$("#contentid").val("");
	            $("#photopath").attr("src","../image/defaultuser.jpg");
	            $("#contenttext").text("");
	            $("#photoid").val("");
			}
		});
	}) 
 
      //普通图片上传
     var uploadInst = upload.render({
         elem: '#btn-photo',
         url: '../file/springupload' //改成您自己的上传接口 
             ,
         before: function (obj) {
             //预读本地文件示例，不支持ie8
             obj.preview(function (index, file, result) {
                 $('#photopath').attr('src', result); //图片链接（base64）
             });
         },
         done: function (res) {
             //如果上传失败
             if (res.code > 0) {
                 return layer.msg('上传失败');
             }
             $("#photoid").val(res.count);
             // $('#demo1').attr('src', res.result); //图片链接（base64）
         },
         error: function () {
             //演示失败状态，并实现重传
             var demoText = $('#demoText');
             demoText.html(
                 '<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>'
             );
             demoText.find('.demo-reload').on('click', function () {
                 uploadInst.upload();
             });
         }
     });
     
       //普通图片上传
     var uploadInst = upload.render({
         elem: '#detbtn-photo',
         url: '../file/springupload' //改成您自己的上传接口 
             ,
         before: function (obj) {
             //预读本地文件示例，不支持ie8
             obj.preview(function (index, file, result) {
                 $('#edtphotopath').attr('src', result); //图片链接（base64）
             });
         },
         done: function (res) {
             //如果上传失败
             if (res.code > 0) {
                 return layer.msg('上传失败');
             }
             $("#photoid").val(res.count);
             // $('#demo1').attr('src', res.result); //图片链接（base64）
         },
         error: function () {
             //演示失败状态，并实现重传
             var demoText = $('#demoText');
             demoText.html(
                 '<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>'
             );
             demoText.find('.demo-reload').on('click', function () {
                 uploadInst.upload();
             });
         }
     });
     
}); 
 </script>
 
 
<div class="layui-card" id="div_edtcontent" style="display: none;height:450px;">
	<div class="layui-card-body">
		<div class="layui-card">
			<div class="layui-card-body">
				<!--表单开始-->
				<form class="layui-form">
					<input type="hidden" id="edtcontentid" value="" />
					<div class="layui-form-item">
						<label class="layui-form-label">图片名称</label>
						<div class="layui-input-block">
							<input type="text" name="photoid" disabled="disabled" id="edtphotoid" required
								lay-verify="required" placeholder="请选择上传的文章内容图片"
								autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"></label>
						<div class="layui-input-block">
							<button type="button" class="layui-btn layui-btn-normal"
								id="edtbtn-photo">上传内容图片</button>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">图片预览</label>
						<div class="layui-input-block">
							<img class="layui-upload-img" src="../image/defaultuser.jpg" id="edtphotopath" width="150px">
						</div>
					</div>

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">图片描述</label>
						<div class="layui-input-block">
							<textarea name="signed" id="edtcontenttext" placeholder="请输入一段文字描述图片"
								class="layui-textarea"></textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
  
<div class="layui-card" id="div_addcontent" style="display: none;height:450px;">
	<div class="layui-card-body">
		<div class="layui-card">
			<div class="layui-card-body">
				<!--表单开始-->
				<form class="layui-form">
					<input type="hidden" id="contentid" value="" />
					<div class="layui-form-item">
						<label class="layui-form-label">图片名称</label>
						<div class="layui-input-block">
							<input type="text" name="photoid" disabled="disabled" id="photoid" required
								lay-verify="required" placeholder="请选择上传的文章内容图片"
								autocomplete="off" class="layui-input layui-bg-gary">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"></label>
						<div class="layui-input-block">
							<button type="button" class="layui-btn layui-btn-normal"
								id="btn-photo">上传内容图片</button>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">图片预览</label>
						<div class="layui-input-block">
							<img class="layui-upload-img" src="../image/defaultuser.jpg" id="photopath" width="150px">
						</div>
					</div>

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">图片描述</label>
						<div class="layui-input-block">
							<textarea name="signed" id="contenttext" placeholder="请输入一段文字描述图片"
								class="layui-textarea"></textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
		   
</html>
