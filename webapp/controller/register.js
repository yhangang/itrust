//载入导航和页脚
$("#navigation").load("view/navigation.html");
$("#footer").load("view/footer.html");
// 注册按钮监听事件

// $("#registerButton").click(
// function() {
// $.post("register.do", $("#registerForm").serialize(), function(
// data, status) {
// var obj = JSON.parse(data);
// if ("SUCCESS" == obj.FLAG) {
// $("#loginInfo").attr("class", "alert alert-info").text(
// "注册成功");
// setTimeout("location.href ='mainUrl.do'", 1000);
// } else {
// $("#loginInfo").attr("class", "alert alert-danger").text(
// "注册失败，服务器异常");
// }
// });
// });

// 表单校验
$(document).ready(
		function() {
			$('#registerForm').bootstrapValidator({
				fields : {
					username : {
						trigger : 'blur',
						validators : {
							notEmpty : {
								message : '用户名不能为空'
							},
							stringLength : {
								min : 3,
								max : 30,
								message : '用户名长度为3-30'
							},
							remote: {
		                        message: '用户名已被使用',
		                        url: 'isVacantUsername.do'
		                    },
		                    //可以自己写回调函数验证
							callback : {
								message : 'some message',
								callback : function(value, validator) {
									var obj;
									 return true;
								}
							}
						}
					},
					password : {
						trigger : 'blur',
						validators : {
							notEmpty : {
								message : '密码不能为空'
							},
							identical : {
								field : 'password2',
								message : '两次输入密码不一致'
							},
							stringLength : {
								min : 3,
								max : 30,
								message : '密码长度为3-30'
							}
						}
					},
					password2 : {
						trigger : 'blur',
						validators : {
							notEmpty : {
								message : '密码不能为空'
							},
							identical : {
								field : 'password',
								message : '两次输入密码不一致'
							},
							stringLength : {
								min : 3,
								max : 30,
								message : '密码长度为3-30'
							}
						}
					},
					realname : {
						trigger : 'blur',
						validators : {
							notEmpty : {
								message : '真实姓名不能为空'
							}
						}
					}
				},
			}).on(
					'success.form.bv',
					function(e) {
						// 修复bootstrapvalidator重复提交的bug
						e.preventDefault();
						$.post("register.do", $("#registerForm").serialize(),
								function(data, status) {
									var obj = JSON.parse(data);
									if ("SUCCESS" == obj.FLAG) {
										$("#registerInfo").attr("class",
												"alert alert-info")
												.text("注册成功");
										setTimeout(
												"location.href = 'mainUrl.do'",
												1000);
									} else {
										$("#registerInfo").attr("class",
												"alert alert-danger").text(
												"注册失败，服务器异常");
									}
								});
					});
		});