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
body .demo-class .layui-layer-page .layui-layer-content {background-color: #e13e4;}
</style>
<body>

  <div class="layui-fluid" style="margin-top: 10px">
    		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form"> 
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="wherecondition" placeholder="请输入品牌名称" class="layui-input" autocomplete="off">
			    </div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button"
						class="layui-btn layui-bg-blue">查询</button>
				</div>
				<div  class="layui-inline">
          			<button class="layui-btn layuiadmin-btn-useradmin" type="button" id="btn_add">添加</button>
        		</div>
			</form>
		</blockquote>
      
      <div class="layui-card-body">
       <table id="majorlist" style="text-align: center;" class="layui-table" lay-filter="tool">
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
	<script src="../js/loadselect.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
  <script>
  	layui.use(['layer','upload','table','form'], function(){
  	var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table,form=layui.form;
  		 
  		/*加载表格*/
		table.render({
			elem : '#majorlist',
			id:'majorlist',
			url : '../carbrand/getcarbrand',
			title : '专业数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'brandname',
     				align : 'center',
     				title : '品牌名称',
   
    			},{
     				field : 'brandintroduction',
     				align : 'center',
     				title : '品牌简介',
   					 
    			},{
     				field : 'img',
     				align : 'center',
     				title : '品牌LOG',
   					templet: function(d){
        					return     '<img class="layui-nav-img" src="'+d.photoname+'" >'}
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
		
		 //自定义验证规则
			form.verify({
				addtitle: function (value) {
					if (value.length < 1) {
						return '标题至少得2个字符';
					}
				}, 
				adddescription: function (value) {
					if (value.length < 2  ) {
						return '品牌简介不得少于2个字符';
					}
				},
				 
			})
            //普通图片上传
            var uploadInst = upload.render({
                elem: '#test1',
                url: '../file/springupload' //改成您自己的上传接口 
                    ,
                before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result); //图片链接（base64）
                    });
                },
                done: function (res) {
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                    $("#addphotoid").val(res.count);
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
                elem: '#test2',
                url: '../file/springupload' //改成您自己的上传接口 
                    ,
                before: function (obj) {
                    //预读本地文件示例，不支持ie8
                    obj.preview(function (index, file, result) {
                        $('#demo2').attr('src', result); //图片链接（base64）
                    });
                },
                done: function (res) {
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                    $("#edtphotoid").val(res.count);
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
		//表格工具栏事件 
		table.on('tool(tool)', function(obj) {
			var data = obj.data;
			switch (obj.event) {
				//删除按钮操作
				case 'del':
					layer.confirm('确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../carbrand/delcarbrand",
			        		dataType: 'json',
			        		data:{
			        			carid:data.brandid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
				        				icon: 1,
										btn: ['确定']
							}, function(){
										table.reload("majorlist", { //此处是上文提到的 初始化标识id
							                where: {
							                	 
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
				/* 编辑品牌标题按钮 */
				$("#edttitle").val(data.brandname);
				$("#edtdescription").val(data.brandintroduction);
				$("#demo2").attr("src",data.photoname)
				$("#edtphotoid").val(data.brandphoto);
				$("#edtbrandid").val(data.brandid) 
				 
				layer.open({
 						title:"品牌信息编辑",
 						type: 1,
 						area: ['400px'],
 						
 						btn:['确认保存'],
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
 						content: $('#div_edlForum'), 
 						yes: function (layero, index) { 
		  				   form.on('submit(formDemo)', function (data) {
		                            //表单数据formData
		                            var formData = data.field; 
		                            
		                            delete data.field["file"]; 
		                     if($("#edtphotoid").val()==""){ 
		                    	 layer.confirm('请上传照片', { btn: ['确定'], icon: 2 });
			                    	return;
			                    } 
		                            
		   					$.ajax({
				        		type: 'post',
				        		url: "../carbrand/updatecarbrand",
				        		dataType: 'json',
				        		data: formData ,
				        		success:function(data){
				        			if(data.code == 0){
				        				layer.confirm(data.msg, {
				        				  icon:1,
										  btn: ['确定']
										}, function(){
											table.reload("majorlist", { //此处是上文提到的 初始化标识id
								                where: { 
								                }
								            });	
											layer.closeAll();
										});          				 
				        			}
				        			else{
				        				layer.confirm(data.msg, {
				        				  icon:7,
											  btn: ['确定']
										});
				        			}
				        		},
				        		error:function(){
				        			layer.confirm('出现错误，删除失败，请重试！', {
				        			  icon:6,
										  btn: ['确定']
									});
				        		},
				        	});
				        	})   
		  				},
 						cancel: function(){ 
 							$("#newcollegename").val("");
 						}
				});
				break;
				 
			};
		});
		
		
		/* 点击查询对网站用户进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('majorlist', {
				method : 'post',
				where : {
					realname : $("#wherecondition").val().trim()
						},
				page : {
					curr : 1
					}
			});
		}) 
  		
  		//添加品牌确认按钮点击事件
  		$("#btn_add").click(function(){
  			loadSelect('articlestype','addarticlestype', form);
  			$('#demo1').removeAttr('src'); 
  			$('#addphotoid').val(""); 
  			layer.open({
  				title:"添加品牌",
  				type: 1,
  				area: ['400px'], 
  				btn:['添加'],
	  			success: function (layero) { 
                    // 添加form标识
                    layero.addClass('layui-form');
                    // 将保存按钮改变成提交按钮
                    layero.find('.layui-layer-btn0').attr({
                        'lay-filter': 'formDemo',
                        'lay-submit': '', 
                    }); 
                    form.render();
                },
  				content: $('#div_addForum'),
  				 yes: function (layero, index) { 
  				   form.on('submit(formDemo)', function (data) {
                            //表单数据formData
                            var formData = data.field; 
                            
                            delete data.field["file"]; 
                            
                              if($("#addphotoid").val()==""){ 
	                    	 layer.confirm('请上传照片', {
                                            btn: ['确定'],
                                            icon: 2
                                        });
	                    	return;
	                    } 
                            
   					$.ajax({
		        		type: 'post',
		        		url: "../carbrand/addcarbrand",
		        		dataType: 'json',
		        		data: formData ,
		        		success:function(data){
		        			if(data.code == 0){
		        				layer.confirm(data.msg, {
		        				icon:1,
								  btn: ['确定']
								}, function(){
								 $("#div_addForum")[0].reset(); 
								 layui.form.render();
									table.reload("majorlist", { //此处是上文提到的 初始化标识id
						                where: {
						                 
						                }
						            });	
									layer.closeAll();
								});          				 
		        			}
		        			else{
		        				layer.confirm(data.msg, {
		        					  icon:7,
									  btn: ['确定']
								});
		        			}
		        		},
		        		error:function(){
		        			layer.confirm('出现错误，请重试！', {
		        				  icon:6,
								  btn: ['确定']
							});
		        		},
		        	});
		        	})   
  				},
  				cancel: function(){ 
  					$('#title').val("");
  					$('#author').val("");
  				}
			});
  		}) 
	}); 
  </script> 
	 <!--添加div  --> 
	<form id="div_addForum"
		style="display: none;text-align: center; margin-top: 15px;">
		
		<div class="layui-form-item">
			<label class="layui-form-label">品牌名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="brandname" id="addtitle"   lay-verify="addtitle"
					placeholder="请输入品牌名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">品牌简介:</label>
			<div class="layui-input-inline">
				<textarea style="height:100px"   name="brandintroduction" lay-verify="adddescription"  id="adddescription"
					  autocomplete="off" class="layui-input"> </textarea>
			</div> 
			</div>
		<div class="layui-form-item">
            <label class="layui-form-label">品牌LOG:</label>
            <div class="layui-upload layui-input-inline">
                <button type="button" style="display:inline-block;" class="layui-btn"
                    id="test1">上传图片</button>
                <div class="layui-upload-list" style="display:inline-block;  margin-left:2px" >
                    <img class="layui-upload-img" height="92px" width="92px" id="demo1">
                    <input id="addphotoid"   name="brandphoto"  lay-verify="addphotoid" class="layui-input"   style="display:none" />
                	 <input id="edtstate" value="true"    class="layui-input" name="state" style="display:none" /> 
                </div>
            </div>
         </div>
	</form> 
 
			 <!--专业编辑div  -->
	<div id="div_edlForum"
		style="display: none;text-align: center; margin-top: 15px;">
		
		<div class="layui-form-item">
			<label class="layui-form-label">品牌名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="brandname" id="edttitle"   lay-verify="addtitle"
					  autocomplete="off" class="layui-input"> 
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">品牌简介:</label>
			<div class="layui-input-inline">
				<textarea style="height:100px"  name="brandintroduction" lay-verify="adddescription"  id="edtdescription"
					  autocomplete="off" class="layui-input"></textarea>
			</div>
		</div>
		  
        <div class="layui-form-item">
           <label class="layui-form-label">品牌LOG:</label>
           <div class="layui-upload layui-input-block">
               <button type="button" style="display:inline-block;margin-left: -100px;" class="layui-btn"
                   id="test2">上传图片</button>
               <div class="layui-upload-list" style="display:inline-block; margin-left:2px" >
                   <img class="layui-upload-img" height="92px" width="92px" id="demo2">
                   <input id="edtphotoid"  lay-verify="addphotoid" class="layui-input" name="brandphoto" style="display:none" />
                   <input id="edtbrandid"    class="layui-input" name="brandid" style="display:none" /> 
               </div>
           </div>
       </div> 
	</div> 
</body>
		   
</html>
