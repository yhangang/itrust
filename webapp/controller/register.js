//载入导航和页脚
$("#navigation").load("view/navigation.html");
$("#footer").load("view/footer.html");
// 注册按钮监听事件
$("#registerButton").click(function() {
	$.post("register.do", $("#registerForm").serialize(), function(data, status) {
		var obj = JSON.parse(data);
		if("SUCCESS" == obj.FLAG){
			$("#loginInfo").attr("class", "alert alert-info").text("注册成功"); 
			setTimeout("location.href = 'mainUrl.do'",1000);
		}else{
			$("#loginInfo").attr("class", "alert alert-danger").text("注册失败，服务器异常");
		}
	});
});