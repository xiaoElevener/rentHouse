<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fonts.css">
<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/lib/html5shiv/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/lib/respond/respond.min.js"></script>
    <![endif]-->
<title>中兴租房-登录</title>
</head>
<body>
	<img src="${pageContext.request.contextPath}/img/login_bg.jpg" alt=""
		width="100%" height="100%" class="bg">
	<header id="login-header"></header>
	<section id="login-main">
		<div class="container">
			<div class="login-panel">
				<div class="login-logo ">
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<i></i>
						</div>
						<div class="col-xs-6 col-md-6">
							<span></span>
						</div>
					</div>
				</div>
				<div class="ul-wrapper">
					<!-- 选项卡标题 -->
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#category_01"
							aria-controls="category_01" role="tab" data-toggle="tab"
							aria-expanded="false">登录</a>
						</li>
						<li role="presentation"><a href="#category_02"
							aria-controls="category_02" role="tab" data-toggle="tab"
							aria-expanded="true">注册</a>
						</li>

					</ul>
				</div>
				<!-- 所有的选项卡内容 -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active"
						id="category_01">
						<div class="row login-row">
							<form:form class="form-horizontal" method="post"
								action="${pageContext.request.contextPath }/user/login.do"
								modelAttribute="user">
								<input type="hidden" name="user_token"
									value="${sessionScope.user_token}">

								<div class="form-group">
									<!--<label for="inputEmail3" class="col-sm-2 control-label">Email</label>-->
									<div class="col-sm-12">
										<form:input class="form-control input-lg" id="username"
											path="username" placeholder="用户名" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<form:password class="form-control input-lg" id="password"
											path="password" placeholder="密码" />
									</div>
								</div>
								<div class="form-group">
									<div class=" col-sm-12">
										<div class="checkbox">
											<label> <input type="checkbox"> 下次自动登录 </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-12">
										<button type="button" class="btn btn-default btn-my input-lg"
											onclick="this.disabled=true;this.form.submit();">登陆</button>
									</div>
								</div>
							</form:form>
						</div>
						<div class="row login-panel-footer">
							<div class="col-xs-3 col-xs-offset-1 col-md-3 col-md-offset-1">
								<a href="#"><i class="qq"></i> </a>
							</div>
							<div class="col-xs-3 col-xs-offset-1 col-md-3 col-md-offset-1">
								<a href="#"><i class="wx"></i> </a>
							</div>
							<div class="col-xs-3 col-xs-offset-1 col-md-3 col-md-offset-1">
								<a href="#"><i class="wb"></i> </a></a>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="category_02">
						<div class="row login-row">
							<form:form class="form-horizontal" method="post"
								action="${pageContext.request.contextPath}/user/register.do"
								modelAttribute="user">
								<input type="hidden" name="user_token"
									value="${sessionScope.user_token}">
								<div class="form-group">
									<label for="username" class="col-xs-4 col-sm-4 control-label">昵称：</label>
									<div class="col-xs-8 col-sm-8">
										<form:input class="form-control" id="username" path="username"
											placeholder="name" />
									</div>
								</div>

								<div class="form-group">
									<label for="password" class="col-xs-4 col-sm-4 control-label">密
										码：</label>
									<div class="col-xs-8 col-sm-8">
										<form:password class="form-control" id="password" path="password"
											placeholder="Password" />
									</div>
								</div>
								<div class="form-group">
									<label for="repassword" class="col-xs-4 col-sm-4 control-label">确认密码：</label>
									<div class="col-xs-8 col-sm-8">
										<input type="password" class="form-control" id="repassword"
											name="repassword" placeholder="Repassword">
									</div>
								</div>
								<div class="form-group">
									<label for="telephone" class="col-xs-4 col-sm-4 control-label">电
										话：</label>
									<div class="col-xs-8 col-sm-8">
										<form:input class="form-control" id="telephone"
											path="telephone" placeholder="tel" />
									</div>
								</div>

								<div class="form-group">
									<label for="authCode" class="col-xs-4 col-sm-4 control-label">验
										证码： </label>
									<div class="col-xs-8 col-sm-8">
										<div class="col-xs-6 col-sm-6" style="padding: 0px;">
											<input type="text" class="form-control" id="authCode"
												name="authCode">
										</div>
										<div class="col-xs-6 col-sm-6">
											<img
												src="${pageContext.request.contextPath }/user/getAuthImg.do"
												id="authImg" title="换一换">
										</div>
									</div>
								</div>
								<div class="form-group" style="margin-bottom:5px">
									<label for="error" class="col-xs-4 col-sm-4 control-label"></label>
									<c:if test="${requestScope.error_code!=null}">
										<div class="col-xs-8 col-sm-8 ">
											<div class="alert alert-danger alert-dismissable"
												style="padding-left:10px;padding-top:5px;padding-bottom:5px;margin:0px;">
												<button type="button" class="close" data-dismiss="alert"
													aria-hidden="true">&times;</button>
												验证码错误!
											</div>
										</div>
									</c:if>
								</div>


								<div class="form-group">
									<div class="col-xs-12 col-sm-12">
										<button type="button" class="btn btn-default btn-my input-md"
											onclick="this.disabled=true;this.form.submit();">注册</button>
									</div>
								</div>
								</form:form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
	<script>
		$('#authImg').on('click', function() {
			var timestamp = new Date().getTime();
			$(this).attr("src", $("#authImg").attr('src') + '?' + timestamp);
		});
	</script>
</body>
</html>