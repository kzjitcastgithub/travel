<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
    <style>
        #tag05 {
            display: none;
        }
    </style>
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                数据管理 <small>数据列表</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">数据管理</a></li>
                <li class="active">数据列表</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <!--  < class="btn-group">  -->
                                <button type="button" class="btn btn-default" title="新建"
                                        onclick="location.href='${pageContext.request.contextPath}/pages/product-add.jsp'">
                                    <i class="fa fa-file-o"></i> 新建
                                </button>
                                <button id="btn_delete" type="button" class="btn btn-default" title="删除">
                                    <i class="fa fa-trash-o"></i> 删除
                                </button>
                                <button type="button" class="btn btn-default" title="开启">
                                    <i class="fa fa-check"></i> 开启
                                </button>
                                <button type="button" class="btn btn-default" title="屏蔽">
                                    <i class="fa fa-ban"></i> 屏蔽
                                </button>
                                <button type="button" class="btn btn-default" title="刷新"
                                        onclick="location.href='${pageContext.request.contextPath}/product/findPageable.action?page=1&context=&size=${pageInfo.pageSize}'">
                                    <i class="fa fa-refresh"></i> 刷新
                                </button>
                                <input id="input-search" type="text" class="form-control input-sm"
                                       placeholder="搜索">
                                <!--<span class="glyphicon glyphicon-search form-control-feedback"></span>-->
                                </input>
                                <button type="button" class="btn btn-default" title="搜索"
                                        onclick="findPageable()">
                                    <i class="fa fa-search"></i> 搜索
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="box-tools pull-right">

                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm"
                                       placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </input>
                                <button type="button" class="btn btn-default" title="刷新"
                                        onclick="location.href='${pageContext.request.contextPath}/product/findPageable.action?page=1&size=${pageInfo.pageSize}'">
                                    <i class="fa fa-refresh"></i> 刷新
                                </button>
                            </div>

                    </div>
                    -->
                    <!--工具栏/-->

                    <!--数据列表-->
                    <table id="dataList"
                           class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr>
                            <th class="" style="padding-right: 0px;"><input
                                    id="selall" type="checkbox" class="icheckbox_square-blue">
                            </th>
                            <!--<th class="sorting_asc">ID</th>-->
                            <th class="sorting_desc">编号</th>
                            <th class="sorting_asc sorting_asc_disabled">产品名称</th>
                            <th class="sorting_desc sorting_desc_disabled">出发城市</th>
                            <th class="sorting">出发时间</th>
                            <th class="text-center sorting">产品价格</th>
                            <th class="sorting">产品描述</th>
                            <th class="text-center sorting">状态</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody id="tag_tbody">


                        <c:forEach items="${pageInfo.list}" var="product">
                            <tr>
                                <td><input id="ids" name="ids" type="checkbox"></td>
                                <td id="tag05">${product.id }</td>
                                <td>${product.productNum }</td>
                                <td>${product.productName }</td>
                                <td>${product.cityName }</td>
                                <td>${product.departureTimeStr }</td>
                                <td class="text-center">${product.productPrice }</td>
                                <td>${product.productDesc }</td>
                                <td class="text-center">${product.productStatusStr }</td>
                                <td class="text-center">
                                    <button type="button" class="btn bg-olive btn-xs">订单</button>
                                    <button type="button" class="btn bg-olive btn-xs">详情</button>
                                    <button type="button" class="btn bg-olive btn-xs"
                                            id="btn_bj">编辑
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!--数据列表/-->
                    <!--工具栏/-->

                </div>
                <!-- 数据表格 /-->


            </div>
            <!-- /.box-body -->


            <!-- .box-footer-->
            <div class="box-footer">
                <div class="pull-left">
                    <div class="form-group form-inline">
                        总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页 <select id="changePageSize"
                                                                                 onchange="changePageSize()"
                                                                                 class="form-control">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select> 条
                    </div>
                </div>

                <div class="box-tools pull-right">
                    <ul class="pagination">
                        <li>
                            <a href="${pageContext.request.contextPath}/product/findPageable.action?page=1&size=${pageInfo.pageSize}&context="
                               ;
                               aria-label="Previous">首页</a></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/product/findPageable.action?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}&context=">上一页</a>
                        </li>
                        <c:forEach begin="1" end="${pageInfo.pages}" var="page">
                            <li>
                                <a href="${pageContext.request.contextPath}/product/findPageable.action?page=${page}&size=${pageInfo.pageSize}&context=">${page}</a>
                            </li>
                        </c:forEach>
                        <li>
                            <a href="${pageContext.request.contextPath}/product/findPageable.action?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}&context=">下一页</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/product/findPageable.action?page=${pageInfo.pages}&size=${pageInfo.pageSize}&context="
                               aria-label="Next">尾页</a></li>
                    </ul>
                </div>
            </div>


            <!-- /.box-footer-->
    </div>
    </section>
    <!-- 正文区域 /-->

</div>
<!-- @@close -->
<!-- 内容区域 /-->

<!-- 底部导航 -->
<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 1.0.8
    </div>
    <strong>Copyright &copy; 2014-2017 <a
            href="http://www.itcast.cn">研究院研发部</a>.
    </strong> All rights reserved.
</footer>
<!-- 底部导航 /-->

</div>

<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script>
    function changePageSize() {
        //var pageSize = $("#changePageSize").val();
        //alert("页大小："+$("#changePageSize option:selected").text());
        var pageSize = $("#changePageSize option:selected").text();
        //$("select option[value='5']").prop("selected","selected");
        location.href = "${pageContext.request.contextPath}/product/findPageable.action?page=1&context=&size=" + pageSize;
    }

    function findPageable() {
        var text = $("#input-search").val();
        //alert(text);
        location.href = "${pageContext.request.contextPath}/product/findPageable.action?page=1&context="+text+"&size=" +${pageInfo.pageSize};
    }

    $(function () {
        $("select option[value=${pageInfo.pageSize}]").prop("selected", "selected");
    });

    $(function () {

        $("tbody td").find("#btn_bj").click(function () {
            //alert($(this).parent("td").parent("tr").find("#tag05").text());
            var id = $(this).parent("td").parent("tr").find("#tag05").text();
            location.href = "${pageContext.request.contextPath}/product/findById.action?id=" + id;

        });

        //location.href = "${pageContext.request.contextPath}/product/findById.action?id="+$("#tag05").text();

        $("#btn_delete").click(function () {
            //alert("触发了");
            var ids = new Array();
            var i = 0;
            $.each($('input:checked'), function () {
                if (this.checked) {
                    //alert($(this).parents("tr").find("#hiden").html());
                    var id = $(this).parents("tr").find("#tag05").text();
                    ids[i] = id;
                    i++;
                }
            });
            //alert(ids);
            if (ids.length > 0) {
                $.ajax({
                    url: "${pageContext.request.contextPath}/product/deleteByIds.action",
                    type: "post",
                    data: {"ids": ids},
                    traditional: true,
                    success: function (result) {
                        if (result.flag) {
                            alert(result.message);
                            location.reload();
                        } else {
                            alert(result.message);
                            location.reload();
                        }
                    },
                    error: function () {
                        alert("error!");
                    },
                    dataType: "json"
                });
            } else {
                location.reload();
            }

        });
    });
</script>
</body>

</html>