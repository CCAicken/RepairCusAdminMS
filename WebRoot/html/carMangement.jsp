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
<form id="div_addcar"
		style="display: none;text-align: center; margin-top: 15px;"> 
		<div class="layui-form-item">
            <label class="layui-form-label">车辆图片:</label>
            <div class="layui-upload layui-input-inline">
                <button type="button" style="display:inline-block;" class="layui-btn"
                    id="test1">上传图片</button>
                <div class="layui-upload-list" style="display:inline-block;  margin-left:2px" >
                    <img class="layui-upload-img" height="92px" width="92px" id="demo1">
                    <input id="addphotoid"   name="photoid"  lay-verify="addphotoid" class="layui-input"   style="display:none" />
                </div>
            </div>
         </div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="carname" id="addcarname"   lay-verify="addtitle"
					placeholder="请输入车辆名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆车系:</label>
			<div class="layui-input-inline">
				<input type="text" name="carseries" id="addcarseries"   lay-verify="addtitle"
					placeholder="请输入文章标题" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
            <label class="layui-form-label">车辆品牌:</label>
            <div class="layui-input-inline">
                <select id="addbrandid" name="brandid"  lay-verify="addarticlestype">
                    <option value="">请选择车辆品牌</option>
                </select>
            </div>
        </div>
         <div class="layui-form-item">
            <label class="layui-form-label">车辆类型:</label>
            <div class="layui-input-inline">
                <select id="addcartypeid" name="cartypeid"  lay-verify="addcartypeid">
                    <option value="">请选择车辆类型</option>
                </select>
            </div>
        </div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆厂商:</label>
			<div class="layui-input-inline">
				<input type="text" name="manufacturer" id="addmanufacturer"   lay-verify="addtitle"
					placeholder="请输入车辆厂商" autocomplete="off" class="layui-input">
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">上市时间:</label>
			<div class="layui-input-inline">
				<input type="text" name="markettime" id="addmarkettime"   lay-verify="addtitle"
					placeholder="请输入上市时间" autocomplete="off" class="layui-input">
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">厂商指导价:</label>
			<div class="layui-input-inline">
				<input type="text" name="guideprice" id="addguideprice"   lay-verify="addtitle"
					placeholder="请输入指导价" autocomplete="off" class="layui-input">
			</div>
		</div> 
		<div class="layui-form-item">
		    <label class="layui-form-label">是否热销</label>
		    <div class="layui-input-inline">
		      <input type="radio" name="carstate" value="热销" title="热销" >
		      <input type="radio" name="carstate" value="非热销" title="非热销" checked=""> 
		    </div>
		</div>
		 <input    name="state"   value="true" class="layui-input"   style="display:none" />
	</form>
	
	 <!--编辑车辆  -->
	<form id="div_edlcar" lay-filter="edtdate"
		style="display: none;text-align: center;  margin-top: 15px;">
		
		<div class="layui-form-item">
            <label class="layui-form-label">车辆图片:</label>
            <div class="layui-upload layui-input-inline">
                <button type="button" style="display:inline-block;" class="layui-btn"
                    id="test2">上传图片</button>
                <div class="layui-upload-list" style="display:inline-block;  margin-left:2px" >
                    <img class="layui-upload-img" name="photoname" height="92px" width="92px" id="demo2">
                    <input    name="photoid"  lay-verify="addphotoid" class="layui-input"   style="display:none" />
                </div>
            </div>
         </div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆名称:</label>
			<div class="layui-input-inline">
				<input type="text" name="carname"     lay-verify="addtitle"
					placeholder="请输入车辆名称" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆车系:</label>
			<div class="layui-input-inline">
				<input type="text" name="carseries"   lay-verify="addtitle"
					placeholder="请输入文章标题" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
            <label class="layui-form-label">车辆品牌:</label>
            <div class="layui-input-inline">
                <select id="edtbrandid" name="brandid"  lay-verify="addarticlestype">
                    <option value="">请选择车辆品牌</option>
                </select>
            </div>
        </div>
         <div class="layui-form-item">
            <label class="layui-form-label">车辆类型:</label>
            <div class="layui-input-inline">
                <select id="edtcartypeid" name="cartypeid"  lay-verify="addcartypeid">
                    <option value="">请选择车辆类型</option>
                </select>
            </div>
        </div>
		<div class="layui-form-item">
			<label class="layui-form-label">车辆厂商:</label>
			<div class="layui-input-inline">
				<input type="text" name="manufacturer"   lay-verify="addtitle"
					placeholder="请输入车辆厂商" autocomplete="off" class="layui-input">
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">上市时间:</label>
			<div class="layui-input-inline">
				<input type="text" name="markettime"     lay-verify="addtitle"
					placeholder="请输入上市时间" autocomplete="off" class="layui-input">
			</div>
		</div> 
		<div class="layui-form-item">
			<label class="layui-form-label">厂商指导价:</label>
			<div class="layui-input-inline">
				<input type="text" name="guideprice"    lay-verify="addtitle"
					placeholder="请输入指导价" autocomplete="off" class="layui-input">
			</div>
		</div> 
		<div class="layui-form-item">
		    <label class="layui-form-label">是否热销</label>
		    <div class="layui-input-inline">
		      <input type="radio" name="carstate" value="热销" title="热销" >
		      <input type="radio" name="carstate" value="非热销" title="非热销" checked=""> 
		    </div>
		</div>
		 <input id="edtphotoid"   name="state"   value="true" class="layui-input"   style="display:none" />
	</form>
	

  <div class="layui-fluid" style="margin-top: 10px">
    		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form">
				<div class="layui-inline">
					<select id="collegeselect"  >
						<option value="">请选择类型</option>
					</select>
				</div> 
				
				<div class="layui-inline">
					<select id="carbrand"  >
						<option value="">请选择品牌</option>
					</select>
				</div> 
				
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="input_wherecondition" placeholder="请输入条件" class="layui-input" autocomplete="off">
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
       <table id="classlist" style="text-align: center;" class="layui-table" lay-filter="tool">
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
    layui.config({
        base: '../js/' //插件路径
    }).extend({
        enhanceform: 'enhanceform'
    });
  	layui.use(['layer','upload','table','form','enhanceform'], function(){
  		var layer = layui.layer,$=layui.jquery,upload = layui.upload,table=layui.table,form=layui.form,enhanceForm = layui.enhanceform;
            var enhance = new enhanceForm({
                elem: '#div_edlcar' //表单选择器
            });
           
  		//加载 下拉框信息
  		loadSelect("cartype","collegeselect", form); 
  		//自定义验证规则
		form.verify({
			addtitle: function (value) {
				if (value.length < 4) {
					return '标题至少得5个字符';
				}
			},
			addarticlestype: function (value) {
				if (value=="" ) {
					return '请选择车品牌';
					}
			}, 
			addcartypeid: function (value) {
				if (value=="" ) {
					return '请选择车辆类型';
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
         
	
	
  		/*加载表格*/
		table.render({
			elem : '#classlist',
			id:'classlist',
			url : '../car/getcar',
			title : '车辆数据表',
			height: "full-160",
			//skin : 'line',
			even : true,
			cols : [ 
			     [ {
					type : 'numbers',
					title : '序号',
					align : 'center',
					
				}, {
     				field : 'carname',
     				align : 'center',
     				title : '车辆名称',
   
    			},{
                        field: 'photoname',
                        align: 'center',
                        title: '车辆照片'
                         ,templet: function(d){
        					return     '<img class="layui-nav-img" src="'+d.photoname+'" >'
      					}
                    },{
     				field : 'brandname',
     				align : 'center',
     				title : '车辆品牌',
   
    			},{
     				field : 'cartypename',
     				align : 'center',
     				title : '车辆类型',
   
    			},{
     				field : 'guideprice',
     				align : 'center',
     				title : '生产年份',
   
    			},{
     				field : 'guideprice',
     				align : 'center',
     				title : '建业零售价',
   
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
		
		/* 点击查询对专业进行筛选 */
		$("#btnselfrontinfo").click(function() {
			table.reload('classlist', {
				method : 'post',
				where : {
					'wherecondition' : $("#input_wherecondition").val().trim(),
					'collegeid':$("#collegeselect").val(),
					'majorid':$("#majorselect").val()
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
					layer.confirm('即将删除'+data.carname+',确定要删除么？', {
					  btn: ['确定','取消'],
					  icon:3
					}, function(){
						$.ajax({
			        		type: 'get',
			        		url: "../car/delcar",
			        		dataType: 'json',
			        		data:{
			        		classid:data.carid
			        		},
			        		success:function(data){
			        			if(data.code == 0){
			        				layer.confirm(data.msg, {
			        				icon: 1,
									  btn: ['确定']
									}, function(){
										table.reload("classlist", { //此处是上文提到的 初始化标识id
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
					 //表单赋值 
					loadSelect('cartype','edtcartypeid', form);
  					loadSelect('brand','edtbrandid', form); 
					$("#demo2").attr("src",data.photoname)
					$("#edtphotoid").val(data.photoid);
				     enhance.filling(data);
			 		/**
			        * 设置select选中值
			        * @param {String} name 对象名称，指“name”
			        * @param {String} val 值
			        * @param {Boolean} isOnSelect 是否触发选中事件
			        * @returns {} 
			        */
			         enhance.setSelectVal('cartypeid',data.cartypeid,false) 
				      enhance.setSelectVal('brandid',data.brandid,false) 
					layer.open({
  						title:"车辆信息编辑",
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
  						content: $('#div_edlcar'),
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
				        		url: "../articles/updatearticles",
				        		dataType: 'json',
				        		data: formData ,
				        		success:function(data){
				        			if(data.code == 0){
				        				layer.confirm(data.msg, {
				        				  icon:1,
										  btn: ['确定']
										}, function(){
											table.reload("classlist", { //此处是上文提到的 初始化标识id
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
  						}
					});
					
				break;
			};
		});
  		 
  		//添加车辆按钮事件
  		$("#btn_addcollege").click(function(){
  			loadSelect('cartype','addcartypeid', form);
  			loadSelect('brand','addbrandid', form);
  			$('#demo1').removeAttr('src'); 
  			$('#addphotoid').val(""); 
  			layer.open({
  				title:"添加车辆",
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
  				content: $('#div_addcar'),
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
		        		url: "../car/addcar",
		        		dataType: 'json',
		        		data: formData ,
		        		success:function(data){
		        			if(data.code == 0){
		        				layer.confirm(data.msg, {
		        				icon:1,
								  btn: ['确定']
								}, function(){
								 $("#div_addcar")[0].reset();
								 layui.form.render();
									table.reload("classlist", { //此处是上文提到的 初始化标识id
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
  				 $("#div_addcar")[0].reset();
  				}
			});
  		}) 
	}); 
  </script>
 
</body>
		   
</html>
