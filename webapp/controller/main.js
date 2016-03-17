//jquery代码
$("#navigation").load("view/navigation.html");
$("#footer").load("view/footer.html");
// 加载用户session
$(document).ready(function() {
	$.post("getLoginUser.do", {}, function(data, status) {
		var obj = JSON.parse(data);
		if ("SUCCESS" == obj.FLAG) {
			$("#user").text(obj.MESSAGE.username);
		} else {
			$("#user").text("游客");
		}
	});
});