<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--引入Bootstrap核心样式文件-->
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
<title>发布-中兴租房</title>
</head>
<body>
	<img src="${pageContext.request.contextPath}/img/login_bg.jpg" alt=""
		width="100%" height="100%" class="bg">
	<div class="cover"></div>
	<header id="fabu-header" class="hidden-xs hidden-sm ">
		<div class="container">
			<div class="fabu-header-title">
				<i class="icon-home"></i> <i>中兴租房</i> <i class="sm-title">全球最专业的房屋租售平台</i>
				<i class="sm-title-shadow">全球最专业的房屋租售平台</i>
			</div>
		</div>
	</header>
	<section id="fabu-main">
		<div class="container">
			<div class="fabu-panel">
				<!--动态边框-->
				<div class="line line-col line-left"></div>
				<div class="line line-col line-right"></div>
				<div class="line line-row line-top"></div>
				<div class="line line-row line-bottom"></div>
				<div class="fabu-title">
					<div class="fabu-title-left">

						<i class="icon-home2"></i> <i>新房信息发布</i>
					</div>

					<div class="fabu-title-right">
						<i class="icon-pencil2"></i> <i>填写房屋信息</i>
					</div>
				</div>
				<div class="row ">
					<div class="fabu-row">
						<form:form class="form-horizontal" method="post"
							action="${pageContext.request.contextPath }/house/create_house.do"
							modelAttribute="house">
							<input type="hidden" name="user_token"
								value="${sessionScope.house_token}">
							<form:input type="hidden" path="users.userId" value="${sessionScope.user.userId}"/>
							<div class="form-group">
								<label for="title" class="col-xs-4 col-sm-4 control-label"><i
									class="icon-newspaper"></i>&nbsp;标&nbsp;&nbsp;题：</label>
								<div class="col-xs-8 col-sm-8">
									<form:input class="form-control input-my" id="title"
										placeholder="title" path="title" />
								</div>
							</div>
							<div class="form-group">
								<label for="type_id" class="col-xs-4 col-sm-4 control-label"><i
									class="icon-home"></i>&nbsp;户&nbsp;&nbsp;型：</label>
								<div class="col-xs-8 col-sm-8">
									<form:select class="form-control" id="type_id"
										path="type.typeId">
										<option selected value="">房型</option>
										<option value=1000>一室一厅</option>
										<option value=1001>一室两厅</option>
										<option value=1002>两室一厅</option>
										<option value=1003>两室两厅</option>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label for="floorage" class="col-xs-4 col-sm-4 control-label"><i
									class="icon-calculator"></i>&nbsp;面&nbsp;&nbsp;积：</label>
								<div class="col-xs-8 col-sm-8">
									<form:input type="number" class="form-control input-my"
										id="floorage" path="floorage" placeholder="floorage" />
								</div>
							</div>
							<div class="form-group">
								<label for="price" class="col-xs-4 col-sm-4 control-label"><i
									class="icon-coin-yen"></i>&nbsp;价&nbsp;&nbsp;格：</label>
								<div class="col-xs-8 col-sm-8">
									<form:input type="number" class="form-control input-my"
										id="price" placeholder="price" path="price" />
								</div>
							</div>
							<div class="form-group">
								<label for="houseDate" class="col-xs-4 col-sm-4 control-label"><i
									class="glyphicon glyphicon-calendar"></i>房产日期：</label>
								<div class="col-xs-8 col-sm-8">
									<form:input type="date" class="form-control input-my"
										id="pubdate" path="pubdate" placeholder="houseDate" />
								</div>
							</div>

							<div class="form-group">
								<label for="district_id" class="col-xs-2 col-sm-2 control-label"><i
									class="icon-location2"></i> </label>
								<div class="col-xs-4 col-sm-4">
									<form:select class="form-control" id="district_id"
										path="street.district.districtId">
										<option selected value="">区县</option>
										<option value=1000>青山湖区</option>
										<option value=1001>东湖区</option>
										<option value=1002>西湖区</option>
										<option value=1003>青云谱区</option>
									</form:select>
								</div>
								<label for="street_id" class="col-xs-2 col-sm-2 control-label">街：
								</label>
								<div class="col-xs-4 col-sm-4">
									<form:select class="form-control" id="street_id"
										path="street.streetId">
										<option selected value="">街道</option>
										<option value=1000>知春路</option>
										<option value=1001>中关村大街</option>
										<option value=1002>学院路</option>
										<option value=1003>朝阳路</option>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label for="contact" class="col-xs-4 col-sm-4 control-label"><i
									class="glyphicon glyphicon-phone"></i>联系方式：</label>
								<div class="col-xs-8 col-sm-8">
									<form:input type="number" class="form-control input-my"
										id="contact" path="contact" placeholder="contact" />
								</div>
							</div>
							<div class="form-group">
								<label for="description" class="col-xs-4 col-sm-4 control-label"><i
									class="icon-profile"></i>详细信息：</label>
								<div class="col-xs-8 col-sm-8">
									<form:textarea id="description" path="description"
										class="form-control" rows="4" />
								</div>
							</div>

							<div class="form-group">
								<div class="col-xs-12 col-sm-12">
									<button type="button" class="btn btn-default btn-my input-md"
										onclick="this.disabled=true;this.form.submit();">立即发布</button>
								</div>
							</div>
						</form:form>
					</div>

				</div>

			</div>
		</div>
	</section>
	<footer id="footer"> </footer>
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
</body>
</html>