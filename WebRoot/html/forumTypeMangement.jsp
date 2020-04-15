<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>layuiAdmin 网站用户</title>
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
 .artTypeLayer {
            width: 90%;
            margin-left: auto;
            margin-right: auto;
            padding-top: 20px;
        }
</style>
<body>
 <!--添加div  -->
	<form id="div_addcollege"
		style="display: none;text-align: center; ">
		<div class="artTypeLayer"> 
             <div class="layui-form-item">
                 <label class="layui-form-label">类型名称:</label>
                 <div class="layui-input-block">
                     <input type="text" name="articlestypename" id="appointmentname" lay-verify="appointmentname" autocomplete="off"
                       placeholder="请输入名称" class="layui-input">
                       
                        <input type="text" name="state" value="true" id="appointmentname"   style="display:none">
                 </div>
             </div>  
         </div>
	</form>
	 <!--编辑div  -->
	<form id="div_editcollege"
		style="display: none;text-align: center;">
		<div class="artTypeLayer"> 
		<div class="layui-form-item">
			<label class="layui-form-label">类型名称:</label>
                 <div class="layui-input-block">
                     <input type="text" name="articlestypename" id="edtarticlestypename" lay-verify="appointmentname" autocomplete="off"
                       placeholder="请输入名称" class="layui-input">
                     <input type="text" name="state" value="true" id="edtstate"   style="display:none">
			</div>
		</div>
		</div>
		 
	</form>
	
	
  <div class="layui-fluid" style="margin-top: 10px">
    		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form">
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="input_collegename" placeholder="请输入查询条件" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div  class="layui-inline">
          			<button class="layui-btn layuiadmin-btn-useradmin" type="button" id="btn_addcollege">添加</button>
        		</div>
        	     
			</form>
		</blockquote>
      
      <div class="layui-card-body">
      	 <table id="collegelist" style="text-align: center;" class="layui-table" lay-filter="tool">
        </table> 
        <script type="text/html" id="imgTpl"> 
          <img style="display: inline-block; width: 50%; height: 100%;" src= {{ d.avatar }}>
        </script> 
        <script type="text/html" id="barDemo">
          <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i class="layui-icon layui-icon-edit"></i>编辑</a>
          <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</a>
        </script>
      </div>
    </div>

  <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer', 'table','form'], function(){
  		var layer = layui.layer,$=layui.jquery,form=layui.form,table=layui.table;
  			
 		//自定义验证规则
		form.verify({
			appointmentname: function (value) {
				if (value.length < 4) {
					return '名称至少5个字符';
				}
			}
		}) 		
  		/*加载表格*/
		table.render({
			elem : '#collegelist',
			id:'collegelist',
			url : '../articles/getarticlestype',
			title : '数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'articlestypename',
     				align : 'center',
     				title : '文章类型名称',
   
    			},{
     				field : 'state',
     				align : 'center',
     				title : '是否可用',
   
    			},{
					title : '操作',
					toolbar : '#barDemo',
					align : 'center'
				}] ],
			 page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 10,
					limits: [1, 4, 5, 10, 50],
					theme: '#1E9FFF',						
			 },
		});
		
		/* 点击查询对学院进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('collegelist', {
				method : 'post',
				where : {
					'realname' : $("#input_collegename").val().trim()
						},
				page : {
					curr : 1
					}
			});
		})
		
		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('即将删除'+data.articlestypename+'确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../articles/delarticlestype",
			        		dataType: 'json',
			        		data:{
			        		articlestypeid:data.articlestypeid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("collegelist", { //此处是上文提到的 初始化标识id
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
			        		error:function(){
			        			layer.confirm('出现错误，删除失败，请重试！', {
			        				icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});   
					}, function(){ 
						layer.closeAll();
					});
				break;
				case 'edit': 
					$("#edtarticlestypename").val(data.articlestypename); 
					$("#edtstate").val(data.state); 
					layer.open({
  						title:"编辑",
  						type: 1,
  						area: ['500px'], 
  						btn:['确认保存'],
  						maxmin: true,//显示最大化最小化按钮
  						//offset: 'b', 弹框的位置
  						content: $('#div_editcollege'),
  						btn1: function(index, layero){
    						$.ajax({
			        		type: 'POST',
			        		url: "../articles/updatearticlestype",
			        		dataType: 'json',
			        		data:{
				        		 articlestypeid:data.articlestypeid,
				        		 articlestypename:$("#edtarticlestypename").val().trim(),
				        		 state:data.state
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("collegelist", { //此处是上文提到的 初始化标识id
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
			        		error:function(){
			        			layer.confirm('出现错误，请重试！', {
			        				  icon: 6,
									  btn: ['确定']
								});
			        		},
			        	});  
  						},
  						cancel: function(){ 
  							$("#newcollegename").val("");
  						}
					});
					
				break;
			};
		}); 
  		//添加学院按钮事件
  		$("#btn_addcollege").click(function(){
  			layer.open({
  				title:"添加",
  				type: 1,
  				area: ['500px'], 
  				btn:['添加'],
  				content: $('#div_addcollege'),
  				  success: function (layero) { 
                        // 添加form标识
                        layero.addClass('layui-form');
                        // 将保存按钮改变成提交按钮
                        layero.find('.layui-layer-btn0').attr({
                            'lay-filter': 'formDemo',
                            'lay-submit': ''
                        }); 
                        form.render();
                    },
  				 
                    yes: function (layero, index) { 
                        form.on('submit(formDemo)', function (data) {
                            //表单数据formData
                            var formData = data.field;  
                            $.ajax({
                                url: '../articles/addarticlestype',
                                dataType: "json",
                                //data: {jsonString:JSON.stringify(data.field)},
                               data: formData,
                                type: "POST",
                                success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				 icon: 1,
									  btn: ['确定']
									}, function(){
									$("#div_addcollege")[0].reset(); 
										table.reload("collegelist", { //此处是上文提到的 初始化标识id
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
			        		error:function(){
			        			layer.confirm('出现错误，请重试！', {
			        			 	  icon: 6,
									  btn: ['确定']
								}); 
			        		},
                            })
                        });
                    },  
  				cancel: function(){  
  				}
			});
  		})
	
	}); 
  </script>
 
</body>
		   
</html>
