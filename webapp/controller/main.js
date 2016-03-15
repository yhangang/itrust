//angularjs代码
//获取页面app对象
var mainApp = angular.module('mainApp', []);

// 定义controller函数
mainApp.controller('mainCtrl', function($scope, $http) {
	$scope.user = {
		"username" : "游客"
	};

	$scope.submitForm = function() {
		/* $("#loginForm").submit(); */

		$http({
			method : 'POST',
			url : 'logintest.do',
			data : $.param($scope.formData),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.user = data;
			alert(data.username);
		});

	};
});

//jquery代码
$("#navigation").load("view/navigation.html");
$("#footer").load("view/footer.html");