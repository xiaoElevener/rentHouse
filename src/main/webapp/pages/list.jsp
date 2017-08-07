<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--引入Bootstrap核心样式文件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/lib/html5shiv/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/respond/respond.min.js"></script>
    <![endif]-->
<!-- 引用分页插件-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pagination.css" />
<title>房屋列表-中兴租房</title>
</head>
<body>
	<header id="list-top">
		<div class="topbar hidden-xs hidden-sm">
			<div class="container">
				<div class="row">
					<div class="col-md-2 text-center">
						<i class="icon-mobile"></i> <a href="#">下载app</a> <i
							class="glyphicon glyphicon-menu-down icondown"></i>
					</div>
					<div class="col-md-5 text-center">
						<i class="glyphicon glyphicon-earphone"></i> <span>4006-89-4006（服务时间：9:00-21:00）</span>
					</div>
					<div class="col-md-2 text-center">
						<a href="#">常见问题</a> <a href="#">财富登录</a>
					</div>
					<div class="col-md-3 text-center">
						<c:if test="${sessionScope.user == null}">
							<a
								href="${pageContext.request.contextPath}/user/getLoginForm.do"
								class="btn btn-top btn-sm">免费注册</a>
							<a href="${pageContext.request.contextPath}/user/getLoginForm.do"
								class="btn btn-link btn-sm">登录</a>
							<c:out value="${sessionScope.user}" />
						</c:if>
						<c:if test="${sessionScope.user!=null}">
							<span>欢迎：${sessionScope.user.username}</span>
							<a href="${pageContext.request.contextPath}/user/logout.do"
								class="btn btn-link btn-sm">登出</a>
							<c:out value="${sessionScope.user}" />
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="search-bar">
		<div class="container clearfix">
			<div class="col-md-2  hidden-xs hidden-sm">
				<i class="icon-home list-icon"></i>
				<!-- <i class="list-title">中兴租房</i>-->
			</div>
			<div class="col-md-7 text-center col-xs-12 col-sm-12">
				<form class="form-horizontal">
					<div class="search">
						<input id="title" class="form-control input-search" type="text"
							placeholder="请输入房源相关信息"> <a
							href="javascript:doSearch(1,6);" class="btn btn-link btn-search ">搜索</a>
						<i class="icon-search"></i>
					</div>
			</div>
			<div class="col-md-3 text-center hidden-xs hidden-sm">
				<a href="${pageContext.request.contextPath}/house/getCreateHouseForm.do"
					class="btn mffb"> <i class="glyphicon glyphicon-pencil"></i> <i>免费发布</i>
				</a>
			</div>

		</div>

	</div>
	<div class="container">
		<div class="search-items">
			<div class="col-xs-6 col-sm-3">
				<div class="form-group">
					<select class="form-control" id="price">
						<option selected value="">价格</option>
						<option value=0-100>100元以下</option>
						<option value=100-200>100元—200元</option>
						<option value=200-1000000>200元以上</option>
					</select>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="form-group">
					<select class="form-control" id="street">
						<option selected value="">街道</option>
						<option value=1000>知春路</option>
						<option value=1001>中关村大街</option>
						<option value=1002>学院路</option>
						<option value=1003>朝阳路</option>
					</select>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="form-group">
					<select class="form-control" id="type">
						<option selected value="">房型</option>
						<option value=1000>一室一厅</option>
						<option value=1001>一室两厅</option>
						<option value=1002>两室一厅</option>
						<option value=1003>两室两厅</option>
					</select>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="form-group">
					<select class="form-control" id="floorage">
						<option selected value="">面积</option>
						<option value=0-40>40以下</option>
						<option value=40-500>40-500</option>
						<option value=500-1000000>500以上</option>
					</select>
				</div>
			</div>

		</div>
		</form>
	</div>

	<section class="list-main">
		<nav class="navbar navbar-my list-nav">
			<div class="container clearfix">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#nav_list"
							aria-expanded="false">
							<span class="sr-only">切换菜单</span> <span class="icon-bar"></span>
							<span class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#"> <i class="icon-home2"></i> </a>
					</div>
					<div id="nav_list" class="collapse navbar-collapse">
						<ul class="nav navbar-nav">

							<li class=" active"><a href="#">南昌租房</a>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right hidden-sm">
							<li><a href="#">个人中心</a>
							</li>
						</ul>
					</div>
				</div>
		</nav>
		<div id="house_list" class="container list"></div>
		<div
			class="row list-row col-md-6 col-sm-6 col-xs-6 col-md-offset-3 col-sm-offset-3">
			<div id="News-Pagination"></div>
		</div>
	</section>

	<footer></footer>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.pagination.js"></script>
</body>
<script>
	$(function(){
		var page = '<%=(String) application.getAttribute("page")%>';
		page = eval('(' + page + ')');
		view(page.list);
					initPagination(page.totalRecords, page.pageSize,
							page.pageNo, page.totalPage);
		
　　}); 

	function view(list) {
		var html = [];
		for ( var j = 0; j < list.length; j++) {
			html += '<div class="row list-row">';
			html += '<div class="col-md-2 col-sm-2 col-xs-4">'
					+ '<a href="#" class="list-img">'
					+ '<img src="${pageContext.request.contextPath}/img/house.gif"></a></div>';
			html += '<div class="col-md-6 col-sm-6 col-xs-8">'
					+ '<a href="${pageContext.request.contextPath}/house/detail.do?id=' + list[j].id + '" target="_black"><h4><strong>'
					+ list[j].title + '</strong></h4></a>' + '<h5>'
					+ list[j].street.district.name + list[j].street.name
					+ '   ' + list[j].floorage + '平米' + '联系方式：'
					+ list[j].floorage + '</h5>' + '</div>';
			html += '<div class="col-md-2 col-sm-2 hidden-xs">'
					+ list[j].type.name + '</div>';
			html += '<div class="col-md-2 col-sm-2 hidden-xs">' + '<p><strong>'
					+ list[j].price + '</strong><sub>万/月</sub></p>' + '</div>';
			html += '</div>';
		}
		$("#house_list").html(html);
	}
</script>

<script type="text/javascript">
	
	function doSearch(page, size) {
		var mydata = {
			title : $("#title").val(),
			price : $("#price").val(),
			street_id : $("#street").val(),
			type_id : $("#type").val(),
			floorage : $("#floorage").val(),
		};
		$.ajax({
			url : '${pageContext.request.contextPath}/house/ajax_search.do',
			type : 'POST',
			cache : false,
			dataType : 'json',
			scriptCharset : 'utf-8',
			data : {
				"conditions" : JSON.stringify(mydata),
				"pageNo" : page,
				"pageSize" : size,
			},
			success : function(data) {
				if (data) {
					var list = data.list;
					view(list);
					//alert(data.totalRecords+"   "+data.pageSize+"   "+(data.pageNo- 1));
					initPagination(data.totalRecords, data.pageSize,
							data.pageNo, data.totalPage);
				}
			}
		});
	}
	// 点击分页按钮以后触发的动作
	function handlePaginationClick(new_page_index, pagination_container) {
		doSearch((new_page_index + 1), 6);
		return true;
	}

	function initPagination(totalRecords, pageSize, pageNo, ltotalPage) {
		$("#News-Pagination").pagination(totalRecords, {
			items_per_page : pageSize, // 每页显示多少条记录
			current_page : pageNo - 1, // 当前显示第几页数据
			num_display_entries : 8, // 分页显示的条目数
			next_text : "下一页",
			prev_text : "上一页",
			num_edge_entries : 2, // 连接分页主体，显示的条目数
			callback : handlePaginationClick
		});
	};
</script>
</html>