<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
<title>房屋详情-中兴租房</title>
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
							<a href="${pageContext.request.contextPath}/user/getLoginForm.do"
								class="btn btn-top btn-sm">免费注册</a>
							<a href="${pageContext.request.contextPath}/user/getLoginForm.do"
								class="btn btn-link btn-sm">登录</a>
						</c:if>
						<c:if test="${sessionScope.user!=null}">
							<span>欢迎：${sessionScope.user.username}</span>
							<a href="${pageContext.request.contextPath}/user/logout.do"
								class="btn btn-link btn-sm">登出</a>
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
				<a href="${pageContext.request.contextPath }/house/getCreateHouseForm.do"
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

	<section class="detail-main">
		<div class="container detail-title">
			<div class="col-md-12">
				<strong> ${requestScope.house.title}</strong>
			</div>
		</div>
		<div class="container detail-content">
			<div class="col-md-6 col-xs-12">
				<img src="${pageContext.request.contextPath}/img/h.jpg" width="100%" height="80%" alt="">
			</div>
			<div class="col-md-6 col-xs-12">
				<p>
					<strong>${requestScope.house.price}</strong><sub>元/月</sub>
				</p>
				<p>
					<i>租赁方式：</i><em>整租</em>
				</p>
				<p>
					<i>房屋类型：</i><em>${requestScope.house.type.name}</em>
				</p>
				<p>
					<i>面积：</i><em>${requestScope.house.floorage}</em>m<sup>2</sup>
				</p>
				<p>
					<i>地址：</i><em>${requestScope.house.street.district.name}
						&nbsp;${requestScope.house.street.name}</em>
				</p>
				<div>
					<span class="phone"><i class="icon-phone"></i><em>${requestScope.house.users.telephone}</em>
					</span>
				</div>
			</div>
		</div>
		<div class="container detail">
			<div class="col-md-6 col-xs-12">
				<h2>房源配置</h2>
				<div>
					<ul class="house-disposal">
						<li><i class="glyphicon glyphicon-bed"></i>
						</li>
						<li><i class="icon-sun"></i>
						</li>
						<li><i class=""></i>
						</li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-12">
				<h2>房源描述</h2>
				<p>${requestScope.house.description}</p>
			</div>
		</div>
	</section>

	<footer></footer>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>