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

$("#logout").click(function() {
	$.post("logout.do", {}, function(data, status) {
		var obj = JSON.parse(data);
		if("SUCCESS" == obj.FLAG){
			$("#user").text("游客");
		}
	});
});