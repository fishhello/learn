<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var httpRequest;
function checkUsername() {
	
	//创建xmlhttprequest对象
	if(window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		httpRequest = new ActiveXObject();
	}
	
	//创建http请求
	httpRequest.open("POST","/fish01/Servlet01",true);
	
	//post方法特用
	httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	//指定回调函数
	httpRequest.onreadystatechange = response01;
	
	//获取传递参数--中文乱码解决--参数两次解码成二进制数据--后台再按utf-8解码
	var name = encodeURI(encodeURI(document.getElementById("username").value),'');
	
	//发送http请求--传参
	httpRequest.send("username="+name);
	alert(httpRequest.readyState);
}

function response01() {
	//readystate状态4表示请求的数据已经流回浏览器(所有浏览器都对状态4通用)
	if(httpRequest.readyState==4) {
		//请求的资源状态
		if(httpRequest.status==200) {
			//获得浏览器流回的数据
			var text = httpRequest.responseText;
			
			//改变id=result的显示内容
			var div = document.getElementById("result");
			
			div.innerText = text;
		}
	}
}
</script>
</head>
<body>
<input type="text" id="username">
<input type="button" onclick="checkUsername()" value="检测用户名是否合法">
<div id="result">

</div>
</body>
</html>