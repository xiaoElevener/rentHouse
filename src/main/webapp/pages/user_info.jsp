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
	<footer></footer>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.pagination.js"></script>
</body>
</html>