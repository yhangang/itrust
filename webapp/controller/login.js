//载入导航和页脚
$("#navigation").load("view/navigation.html");
$("#footer").load("view/footer.html");
// 注册按钮监听事件
$("#submitButton").click(function() {
	$.post("login.do", $("#loginForm").serialize(), function(data, status) {
		var obj = JSON.parse(data);
		if("SUCCESS" == obj.FLAG){
			$("#loginInfo").attr("class", "alert alert-info").text("登录成功"); 
			setTimeout("location.href = 'mainUrl.do'",1000);
		}else{
			$("#loginInfo").attr("class", "alert alert-danger").text("登录失败，请检查用户名与密码");
		}
	});
});