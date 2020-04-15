<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
	<title>layuiAdmin 网站用户</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="../layui/css/layui.css" media="all">
</head>
<style>
	body .demo-class .layui-layer-title {
		background: #4476A7;
		color: #fff;
		border: none;
	}

	body .demo-class .layui-layer-btn {
		border-top: 1px solid #4476A7
	}

	body .demo-class .layui-layer-btn a {
		background: #4476A7;
	}

	body .demo-class .layui-layer-btn .layui-layer-btn1 {
		background: #4476A7;
	}
	 .layui-table-cell {
            height: auto;
            line-height: 30px;
        }
</style>

<body>

	<div class="layui-fluid" style="margin-top: 10px">
		<blockquote class="layui-elem-quote" style="border-left: none">
			<form class="layui-form">
				<div class="layui-input-inline">
					<input type="text" name="sysmothed" id="input_collegename" placeholder="请输入查询条件" class="layui-input"
						autocomplete="off">
				</div>
				<div class="layui-inline">
					<button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
				</div>
			</form>
		</blockquote>
		<div class="layui-card-body">
			<table id="collegelist" style="text-align: center;" class="layui-table" lay-size="lg" lay-filter="tool">
			</table>
			<script type="text/html" id="imgTpl">
				<img style="display: inline-block; width: 50%; height: 100%;" src={{ d.avatar }}>
			</script>
			<script type="text/html" id="barDemo">
				<!-- <a class="layui-btn layui-btn-xs" lay-event="more">查看大图</a> -->
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i
					class="layui-icon layui-icon-delete"></i>删除</a>
			</script>
		</div>
	</div>


	<div id='prevModal'>
		<img id='img_prev' />
	</div>

	<script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use(['layer', 'upload', 'table'], function () {
			var layer = layui.layer,
				$ = layui.jquery,
				upload = layui.upload,
				table = layui.table;


			/*加载表格*/
			table.render({
				elem: '#collegelist',
				id: 'collegelist',
				url: '../photo/getphoto',
				title: '图片数据表',
				height: "full-160",
				even: true,
				cols: [
					[{
						type: 'numbers',
						title: '序号',
						align: 'center',

					}, {
						field: 'photoname',
						align: 'center',
						title: '图片缩略图',
						style:'height:80px;',
						templet: function (d) {
							return '<img class="layui-nav-img"  src="' + d.photoname + '">'
						}

					}, {
						field: 'photoname',
						align: 'center',
						title: '图片路径',

					}, {
						field: 'byuser',
						align: 'center',
						title: '上传用户',

					}, {
						field: 'photocreatetime',
						align: 'center',
						title: '上传时间',

					}, {
						title: '操作',
						toolbar: '#barDemo',
						align: 'center'
					}]
				],
				page: {
					layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
					groups: 5,
					limit: 15,
					limits: [10, 15, 20, 30, 50],
					theme: '#1E9FFF',
				},
			});

			/* 点击查询对图片进行筛选 */
			$("#btnselfrontinfo").click(function () {
				table.reload('collegelist', {
					method: 'post',
					where: {
						'wherecondition': $("#input_collegename").val().trim()
					},
					page: {
						curr: 1
					}
				});
			})

			//表格工具栏事件 
			table.on('tool(tool)', function (obj) {
				var data = obj.data;
				switch (obj.event) {
					//删除按钮操作
					case 'del':
						layer.confirm('即将删除图片 ' + data.photoname + ' ,确定要删除么？', {
							btn: ['确定', '取消'],
							icon: 3
						}, function () {
							$.ajax({
								type: 'get',
								url: "../photo/delphoto",
								dataType: 'json',
								data: {
									photoid: data.photoid
								},
								success: function (data) {
									if (data.code == 0) {
										layer.confirm(data.msg, {
											icon: 1,
											btn: ['确定']
										}, function () {
											table.reload(
												"collegelist", { //此处是上文提到的 初始化标识id
													where: {

													},
													page: {
														curr: 1
													}
												});
											layer.closeAll();
										});
									} else {
										layer.confirm(data.msg, {
											icon: 7,
											btn: ['确定']
										});
									}
								},
								error: function () {
									layer.confirm('出现错误，删除失败，请重试！', {
										icon: 6,
										btn: ['确定']
									});
								},
							});
						}, function () {
							layer.closeAll();
						});
						break;
					case 'more':
						//单击预览
						img_prev.src = data.photoname;
						var w = $(window).width() - 42,
							h = $(window).height() - 42;
						layer.open({
							title: '预览',
							type: 1,
							area: [w, h], //宽高
							content: $('#prevModal')
						});
						break;
				};
			});
		});
	</script>
</body>

</html>