<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <title>网站用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
		content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <style>
        .blogUser-con .layui-table-view {
            border: none;
        }
		 .layui-table-cell {
		            height: auto;
		            line-height: 30px;
        }
        .blogUser-con .layui-table-box {
            margin-top: 10px;
        }

        .blogUser-con {
            padding: 0 15px 15px 15px;
            margin-bottom: 50px;
        }

        .blogUser-con .layui-table-tool-self {
            display: none;
        }

        .blogUser-con .not_border_left {
            border-left: none !important;
        }

        .blogUser-con .blogUser dl dd.layui-this {
            background-color: #1E9FFF !important;
        }

        .blogUser-con .hide {
            display: none;
        }

        .blogUser-con .show {
            display: block;
        }

        .blogUser-con .btn_size {
            height: 28px !important;
            line-height: 28px !important;
        }

        .blogUser-con .layui-table-body table tbody .layui-table-hover {
            background: #fffdd3 !important;
        }

        .blogUser-con .layui-table-body table tbody .layui-table-click {
            background: #fdef9b !important;
        }

        .blogUser-con .layui-table,
        .layui-table-view {
            border: none;
            margin-top: 0;
        }

        #add-blogUser {
            display: none;
            z-index: 999 !important;
        }

        #add-blogUser .artTypeLayer {
            width: 90%;
            margin-left: auto;
            margin-right: auto;
            padding-top: 20px;
        }

        .adminuserdetail {
            padding: 20px;
            display: none;
        }

        .adminuserdetail table tr td {
            padding: 15px;
            text-align: center;
        }

        .adminuserdetail .tdbck {
            background: #f2f2f2;
            width: 30%;
        } 
       
 
    </style>
</head>

<body>
    <!--弹框调用内容Start-->
    <div id="adminuserdetail" class="adminuserdetail">
        <table class="layui-table">
            <tbody>
            	<tr>
                    <td class="tdbck">员工照片</td>
                    <td>  <img class="layui-upload-img" height="92px" width="92px" id="moreimg"></span></td>
                </tr>
                <tr>
                    <td class="tdbck">用户ID</td>
                    <td><span id="txtclaid"></span></td>
                </tr>
                <tr>
                    <td class="tdbck">真实姓名</td>
                    <td><span id="txtadminuserrealname"></span></td>
                </tr>
                <tr>
                    <td class="tdbck">用户类型</td>
                    <td><span id="txtadminuserusertype"></span></td>
                </tr>
                <tr>
                    <td class="tdbck">创建时间</td>
                    <td><span id="txtadmincreatetime"></span></td>
                </tr>
                
            </tbody>
        </table>
    </div>
    <!--弹框调用内容END-->

    <div class="blogUser-con">
        <!-- 条件筛选框Start -->
        <blockquote class="layui-elem-quote not_border_left">
            <form class="layui-form" action="">
                <div class="layui-input-inline">
                    <input type="text" name="userName" id="userName" placeholder="请输入用户名或真实姓名" class="layui-input"
                        autocomplete="off">
                </div>
                <div class="layui-inline">
                    <select id="usertype" lay-filter="usertype" lay-search>
                        <option value="">请选择用户类型</option>
                    </select>
                </div>
                <div class="layui-inline">
                    <button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
                </div>
                <button type="button" class="layui-btn layui-bg-blue" id="addartType" lay-event="addartType"
                    lay-filter="addartType" style="margin-left: 10px;">新增用户</button>
            </form>
        </blockquote>
        <!-- 条件筛选框End -->

        <table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>

        <!-- 用户信息添加Start -->
        <div id="add-blogUser">
            <div class="artTypeLayer"> 
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户类型:</label>
                        <div class="layui-input-block">
                            <select id="addusertype" name="roleid"  lay-verify="addroleid">
                                <option value="">请选择用户类型</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户头像:</label>
                        <div class="layui-upload layui-input-block">
                            <button type="button" style="display:inline-block;" class="layui-btn"
                                id="test1">上传图片</button>
                            <div class="layui-upload-list" style="display:inline-block; margin-left:50px" id="demo2">
                                <img class="layui-upload-img" height="92px" width="92px" id="demo1">
                                <input id="photoid" class="layui-input" name="photoid" style="display:none" />
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">用户账号:</label>
                        <div class="layui-input-block">
                            <input type="text" name="userid" id="userid" lay-verify="adduserid" autocomplete="off"
                                placeholder="请输入用户名" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">员工姓名:</label>
                        <div class="layui-input-block">
                            <input type="text" name="realname" id="realname"  lay-verify="addrealname" autocomplete="off" placeholder="请输入真实姓名"
                                class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">员工电话:</label>
                        <div class="layui-input-block">
                            <input type="text" name="usertel" id="usertel" lay-verify="addusertel" autocomplete="off" placeholder="请输入员工电话"
                                class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户性别:</label>
                        <div class="layui-input-block">
                            <input type="radio" name="gender" value="男" title="男" checked="">
                            <input type="radio" name="gender" value="女" title="女">
                        </div>
                    </div> 
            </div>
        </div>
        <!-- 用户信息添加End -->

    </div>
    <script src="../js/jquery-3.3.1.js" charset="utf-8"></script>
    <script src="../js/loadselect.js" charset="utf-8"></script>
    <script src="../layui/layui.js" charset="utf-8"></script>
    <script>
    	
        layui.use(['table', 'form', 'layer', 'laydate', 'laytpl', 'element', 'upload'], function () {
            var table = layui.table,
                form = layui.form,
                layer = layui.layer,
                $ = layui.jquery,
                laydate = layui.laydate,
                laytpl = layui.laytpl,
                element = layui.element,
                upload = layui.upload;
			    //自定义验证规则
			form.verify({
				adduserid: function (value) {
					if (value.length < 4) {
						return '用户名至少得5个字符';
					}
				},
				addroleid: function (value) {
					if (value.length < 1) {
						return '请选择用户类型';
						}
				}, 
				addrealname: function (value) {
					if (value.length < 2 || value.length > 10) {
						return '姓名名至少得2个字符';
					}
				},
				addusertel: function (value) {
					var mobile = /^1[3|4|5|6|7|8|9]\d{9}$/;
					var flag = mobile.test(value);
					if (!flag) {
						return '请输入正确手机号';
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
            //加载角色类型
            loadRoleType('usertype', form);
            /*加载表格*/
            table.render({
                elem: '#blogUser',
                id: 'adminUserid',
                url: '../admin/getuser',
                title: '管理员用户数据表',
                height: "full-160",
                skin: 'line',
                even: true,
                cols: [
                    [{
                        type: 'numbers',
                        title: '序号',
                        align: 'center',
                        width: 80
                    }, {
                        field: 'userid',
                        title: '账号',
                        align: 'center'
                    }, {
                        field: 'realname',
                        align: 'center',
                        title: '真实姓名'
                    },{
                        field: 'photoname',
                        align: 'center',
                        title: '员工照片'
                         ,templet: function(d){
        					return     '<img class="layui-nav-img" src="'+d.photoname+'" >'
      					}
                    }, {
                        field: 'name',
                        align: 'center',
                        title: '员工类型'
                    }, {
                        field: 'usercreatetime',
                        align: 'center',
                        title: '创建时间'
                    }, {
                        title: '操作',
                        toolbar: '#barDemo',
                        align: 'center'
                    }]
                ],
                page: {
                    layout: ['prev', 'page', 'next', 'skip', 'count', 'limit'],
                    groups: 5,
                    limit: 10,
                    limits: [10, 20, 30, 40, 50],
                    theme: '#1E9FFF',
                },
            });

            /* 点击查询对网站用户进行筛选 */
            $("#btnselfrontinfo").click(function () {
                var useridornickname = $("#userName").val().trim();
                table.reload('adminUserid', {
                    method: 'post',
                    where: {
                        'realname': useridornickname,
                        'roleid': $("#usertype").val(),
                    },
                    page: {
                        curr: 1
                    }
                });
            });

            /* 添加一个网站用户 String userid, String realname, Integer usertel,
            	String gender, Integer photoid, Integer roleid */
            $("#addartType").click(function () {

                //加载角色类型
                loadRoleType('addusertype', form);
                layer.open({
                    type: 1,
                    title: '管理员用户添加',
                    area: ['460px'],
                    shade: 0.4,
                    content: $('#add-blogUser'),
                    btn: ['保存', '返回'],
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
                    
	                    if($("#photoid").val()==""){ 
	                    	 layer.confirm('请上传用户照片', {
                                            btn: ['确定'],
                                            icon: 2
                                        });
	                    	return;
	                    } 
                        form.on('submit(formDemo)', function (data) {
                            //表单数据formData
                            var formData = data.field; 
                            delete data.field["file"]; 
                            $.ajax({
                                url: '../admin/addadminuser',
                                dataType: "json",
                                data: {jsonString:JSON.stringify(data.field)},
                                type: "POST",
                                success: function (res) {
                                    if (res.code == "0") {
                                        layer.confirm(res.msg, {
                                            btn: ['确定'],
                                            icon: 1
                                        }, function () {
                                            table.reload(
                                                "adminUserid", { //此处是上文提到的 初始化标识id
                                                    where: {}
                                                });
                                            layer.closeAll();
                                        });
                                    } else {
                                        layer.confirm(res.msg, {
                                            btn: ['确定'],
                                            icon: 2
                                        });
                                    }
                                },
                                error: function () {
                                    layer.confirm('出现错误，请重试！', {
                                        icon: 6,
                                        btn: ['确定']
                                    });
                                }
                            })
                        });
                    },
                    btn1 : function() {}
                });
            });

            //表格工具栏事件 
            table.on('tool(blogUser)', function (obj) {
                var data = obj.data;
                $("#txtclaid").text(data.userid);
                $("#txtadminuserrealname").text(data.realname);
                $("#txtadminuserusertype").text(data.name);
                $("#txtadminuserdesc").text(data.signed);
                $("#txtadmincreatetime").text(data.usercreatetime);
				$("#moreimg").attr('src', data.photoname);
                switch (obj.event) {
                    case 'seluser':
                        layer.open({
                            type: 1,
                            title: '管理员信息详情',
                            area: ['600px'],
                            shade: 0.8,
                            content: $('#adminuserdetail'),
                            btn: ['返回'],
                            yes: function () {
                                layer.closeAll();
                                $(".adminuserdetail").css("display", "none");
                            },
                            cancel: function () {
                                $(".adminuserdetail").css("display", "none");
                            }
                        });
                        break;

                        //删除按钮操作
                    case 'del':
                        layer.confirm('确定要删除么？', {
                            btn: ['确定', '取消'],
                            icon: 3
                        }, function () {
                            $.ajax({
                                type: 'get',
                                url: "../admin/deladminuser?userid=" + data.userid,
                                dataType: 'json',
                                success: function (data) {
                                    if (data.code == 0) {
                                        layer.confirm(data.msg, {
                                            icon: 1,
                                            btn: ['确定']
                                        }, function () {
                                            table.reload(
                                                "adminUserid", { //此处是上文提到的 初始化标识id
                                                    where: {
                                                        keyword: data
                                                            .code == '0'
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

                };
            });

        });
    </script>
</body>

</html>