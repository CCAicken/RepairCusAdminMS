<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <title>网站用户管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../layui/css/layui.css" media="all">
    <style>
        .blogUser-con .layui-table-view {
            border: none;
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
    <div class="blogUser-con">
        <!-- 条件筛选框Start -->
        <blockquote class="layui-elem-quote not_border_left">
            <form class="layui-form" action="">
                <div class="layui-input-inline">
                    <input type="text" name="userName" id="userName" placeholder="请输入用户名或真实姓名" class="layui-input"
                        autocomplete="off">
                </div> 
                <div class="layui-inline">
                    <button id="btnselfrontinfo" type="button" class="layui-btn layui-bg-blue">查询</button>
                </div> 
            </form>
        </blockquote>
        <!-- 条件筛选框End    <a class="layui-btn layui-btn-xs" lay-event="seluser">查看</a>-->

        <table class="layui-hide" name="blogUser" id="blogUser" lay-filter="blogUser"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script> 
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
           
            /*加载表格*/
            table.render({
                elem: '#blogUser',
                id: 'adminUserid',
                url: '../customer/getcustomer',
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
                        field: 'customeraccount',
                        title: '账号',
                        align: 'center'
                    }, {
                        field: 'customername',
                        align: 'center',
                        title: '姓名'
                    },{
                        field: 'gender',
                        align: 'center',
                        title: '性别' 
                    }, {
                        field: 'tel',
                        align: 'center',
                        title: '电话'
                    }, {
                        field: 'customercreatetime',
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
                    },
                    page: {
                        curr: 1
                    }
                });
            });  
            //表格工具栏事件 
            table.on('tool(blogUser)', function (obj) {
                var data = obj.data; 
                switch (obj.event) {
                        //删除按钮操作
                    case 'del':
                        layer.confirm('确定要删除么？', {
                            btn: ['确定', '取消'],
                            icon: 3
                        }, function () {
                            $.ajax({
                                type: 'get',
                                url: "../customer/delcustomer?id=" + data.customeraccount,
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