//载入导航和页脚
$("#navigation").load("view/navigation.html");
$("#footer").load("view/footer.html");

// 注册按钮监听事件
/*$("#submitButton").click(function() {
	$.post("login.do", $("#loginForm").serialize(), function(data, status) {
		var obj = JSON.parse(data);
		if("SUCCESS" == obj.FLAG){
			$("#loginInfo").attr("class", "alert alert-info").text("登录成功"); 
			setTimeout("location.href = 'mainUrl.do'",1000);
		}else{
			$("#loginInfo").attr("class", "alert alert-danger").text("登录失败，请检查用户名与密码");
		}
	});
});*/
//表单校验
$(document).ready(function() {
    $('#loginForm').bootstrapValidator({
        fields: {
        	username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and cannot be empty'
                    },
                    stringLength: {
                        min: 3,
                        max: 30,
                        message: 'The username must be more than 3 and less than 30 characters long'
                    }/*,
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The username can only consist of alphabetical, number and underscore'
                    }*/
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and cannot be empty'
                    }
                }
            }
        }
    }).on('success.form.bv', function(e) {
        // 修复bootstrapvalidator重复提交的bug
        e.preventDefault();
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
});