<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select name="province" id="provinceID">
		<option value="-1">请选择省份</option>
		<option>广东</option>
		<option>湖南</option>
	</select>
	<select name="city" id="cityID">
		<option>请选择城市</option>
	</select>
	
	<script type="text/javascript">
	
		var ajax;
		if(window.XMLHttpRequest) {
			ajax = new XMLHttpRequest();
		} else if(window.ActiveXObject) {
			ajax = new ActiveXObject();
		}
	
		//设置省份改变事件
		document.getElementById("provinceID").onchange = function() {
			//获得选中的省份
			var index = this.selectedIndex;
			var province = this.options[index].innerHTML;
			if("请选择省份" == province) {
				var citySelect = document.getElementById("cityID");
				citySelect.options.length = 1;
			}
			if("请选择省份" != province) {
				var citySelect = document.getElementById("cityID");
				citySelect.options.length = 1;
			
				ajax.open("POST","/fish01/Servlet01_1",true);
				ajax.setRequestHeader("content-type", "application/x-www-form-urlencoded");
				ajax.send("province="+province);
				ajax.onreadystatechange = function() {
					if(ajax.readyState == 4) {
						if(ajax.status == 200) {
							var XMLDocument = ajax.responseXML;
							var cities = XMLDocument.getElementsByTagName("city");
							for(var i=0;i<cities.length;i++) {
								var value = cities[i].firstChild.nodeValue;
								var optionElement = document.createElement("option");
								optionElement.innerHTML = value;
								citySelect.appendChild(optionElement);
							}
						}
					}
				}
			}
			
		}
	</script> 
</body>
</html>