<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>重复页面</title>
<style type="text/css">
body {
	color: #444444;
	background-color: #EEEEEE;
	font-family: 'Trebuchet MS', sans-serif;
	font-size: 80%;
}

h1 {
	
}

h2 {
	font-size: 1.2em;
}

#page {
	background-color: #FFFFFF;
	width: 60%;
	margin: 24px auto;
	padding: 12px;
}

#header {
	padding: 6px;
	text-align: center;
}

.status3xx {
	background-color: #475076;
	color: #FFFFFF;
}

.status4xx {
	background-color: #FF552E;
	color: #FFFFFF;
}

.status5xx {
	background-color: #F2E81A;
	color: #000000;
}

#content {
	padding: 4px 0 24px 0;
}

#footer {
	color: #666666;
	background: #f9f9f9;
	padding: 10px 20px;
	border-top: 5px #efefef solid;
	font-size: 1em;
	text-align: center;
}

#footer a {
	color: #999999;
}
-->
</style>
</head>

<body>
	<div id="page">
		<div id="header" class="status3xx">
			<h1>重复操作!</h1>
		</div>
		<div id="content">
			<h2>
				${requestScope.error}
			</h2>
		</div>
		<div id="footer">
			<p>
				Powered by <a href="#" rel="nofollow">xiao_elevener.com.cn</a><br />
			</p>
		</div>
	</div>
</body>
</html>
