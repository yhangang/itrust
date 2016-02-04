<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>I Trust</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom Google Web Font -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href='font-awesome/css/font-lato.css' rel='stylesheet' type='text/css'>

    <!-- Add custom CSS here -->
    <link href="css/custom.css" rel="stylesheet">
    <!-- JavaScript -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/custom.js"></script>

</head>

<script type="text/javascript">
function submit(){
	document.forms[0].submit();
}
</script>

<body>

	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">我思故我在</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#" class="scroll-link" data-id="home">首页</a></li>
      <li><a href="#" class="scroll-link" data-id="about">关于我们</a></li>
      <li><a href="#" class="scroll-link" data-id="services">服务</a></li>
      <li><a href="#" class="scroll-link" data-id="contact">联系我们</a></li>
      <li><a style="cursor:pointer;" id="loginpopup">登录/注册</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%
        if(request.getAttribute("user")!=null)
        	out.print(request.getAttribute("user"));
        else out.print("游客");
        %><b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#">我的账户</a></li>
          <li><a href="#">我的服务</a></li>
          <li class="divider"></li>
          <li><a href="logout.do">退出登录</a></li>
        </ul>
      </li>
    </ul>
    <!-- 
    <form class="navbar-form navbar-right" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
    -->
  </div><!-- /.navbar-collapse -->
  
  </nav>
  <!-- Code for Login / Signup Popup -->
  <!-- Modal Log in -->
	<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
	  <div class="modal-dialog" style="margin-top: 150px;">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel1">用户登录</h4>
	      </div>
	      <div class="modal-body" id="login_details">
	        <span> 已有账户? </span> </br></br>
	        <form name="loginForm" action="login.do" method="post">
	        *<span style="font-weight:bold;">用户名</span><br />
	        <input type="text" placeholder="username" name="username" /><br /></br>
	        *<span style="font-weight:bold;" >密码</span><br />
	        <input type="password" placeholder="Password" name="password" /><br />
	        </form>
	      </div>
	      <div class="modal-footer" >
			<input style="float: left" type="button" class="btn btn-success" value="登录" onclick="submit()"/> 
	       <span class="fp-link"> <a href="#">忘记密码?</a></span>
	       </br></br>
			<span> 还不是会员?</span>
			<span id="signup-link" style="cursor:pointer;" class="text-info">注册!</span>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
 <!--Modal Login Ends -->
 <!-- Modal Sign-up Starts -->
	<div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
	  <div class="modal-dialog" style="margin-top: 100px;">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	        <h4 class="modal-title" id="myModalLabel2">用户注册</h4>
	      </div>
	      <div class="modal-body" id="signup_details">
	        <span >Full Name</span>
	        <input type="text" placeholder="Full Name" name="register_name" /> </br></br>
	        *<span >Email</span>
	        <input type="text" placeholder="example@gmail.com" name="register_email" /></br></br>
	        *<span >Password</span>
	        <input type="password" placeholder="Password" name="register_password" /></br></br>
	        *<span >Password Re-Type</span>
	        <input type="password" placeholder="Re-type Password" name="re_register_password" />
	      </div>
	      <div class="modal-footer" >
		<input style="float: left" type="button" class="btn btn-success"  value="Sign Me Up" /> 
	       <span>&nbsp;&nbsp;&nbsp; Already a member? </span><span id="login-link" class="text-info" style="cursor:pointer;">  Login now  </span> 
		 </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
  <!-- Modal Sign up ends! -->
  <!-- End code for Login / Signup Popup -->

    <div class="intro-header" id="home">
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  <!-- Indicators -->
					  <ol class="carousel-indicators">
					    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
					  </ol>
					
					  <!-- Wrapper for slides -->
					  <div class="carousel-inner">
					    <div class="item active">
					      <img src="img/img1.jpg" alt="First Image">
					      <div class="carousel-caption">
					       	第一页
					      </div>
					    </div>
					    <div class="item">
					      <img src="img/img2.jpg" alt="Second Image">
					      <div class="carousel-caption">
					               第二页
					      </div>
					    </div>
					    <div class="item">
					      <img src="img/img3.jpg" alt="Third Image">
					      <div class="carousel-caption">
					               第三页
					      </div>
					    </div>
					  </div>
					
					  <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left"></span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right"></span>
					  </a>
					</div>
        
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <div class="content-section-a" id="about">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <div class="clearfix"></div>
                    <h2 class="section-heading">关于我们
                    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec et commodo neque. <a href="#">Fusce venenatis</a>, neque Vitae ornare consequat, sapien orci vestibulum augue, eu posuere dui urna non dolor. Quisque justo ipsum, consectetur nec mi hendrerit, semper ultrices lectus. <a href="#">Curabitur</a> id dolor eu neque pellentesque faucibus quis vel tellus. <a href="#">Etiam in ullamcorper</a> ligula. Praesent mattis dui in auctor scelerisque. Nulla facilisi. Morbi urna orci, aliquam ut nisi ut, imperdiet volutpat felis. Praesent a porttitor sapien, vel faucibus nisi.</p>
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <img class="img-responsive" src="img/ipad.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->

    <div class="content-section-b" id="services">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-lg-offset-1 col-sm-push-6  col-sm-6">
                    <h2 class="section-heading">服务
                    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. <a href="#">Donec et</a> commodo neque. Fusce venenatis, neque vitae ornare consequat, sapien orci vestibulum augue, eu posuere dui urna non dolor. Quisque justo ipsum, <a href="#">consectetur nec mi</a> hendrerit, semper ultrices lectus. Curabitur id dolor eu neque pellentesque faucibus quis vel tellus. <a href="#">Etiam in</a> ullamcorper ligula. <a href="#">Praesent mattis</a> dui in auctor scelerisque. Nulla facilisi. Morbi urna orci, aliquam ut nisi ut, imperdiet volutpat felis. Praesent a porttitor sapien, vel faucibus nisi.</p>
                </div>
                <div class="col-lg-5 col-sm-pull-6  col-sm-6">
                    <img class="img-responsive" src="img/doge.png" alt="">
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-b -->

    <div class="content-section-a" id="contact">

        <div class="container">

            <div class="row">
                <div class="col-lg-5 col-sm-6">
                    <h2 class="section-heading">联系我们</h2>
                    <form name="sentMessage" class="well" id="contactForm"  novalidate>
		                 <div class="control-group">
		                    <div class="controls">
		                        <input type="text" class="form-control" placeholder="Full Name" id="name" required data-validation-required-message="Please enter your name" />
		                          <p class="help-block"></p>
		                   </div>
		                 </div>         
		                <div class="control-group">
		                  <div class="controls">
		                        <input type="email" class="form-control" placeholder="Email" id="email" required data-validation-required-message="Please enter your email" />
		                        <p class="help-block"></p>
		                </div>
			            </div>         
			                          
			               <div class="control-group">
			                 <div class="controls">
			                                 <textarea rows="10" cols="100" class="form-control" placeholder="Message" id="message" required data-validation-required-message="Please enter your message" minlength="5" data-validation-minlength-message="Min 5 characters" maxlength="999" style="resize:none"></textarea>
			                                 <p class="help-block"></p>
			                </div>
			               </div>                  
			             <div id="success"> </div> <!-- For success/fail messages -->
			            <button type="submit" class="btn btn-primary pull-right">Send</button><br /><br/>
			          </form>
                </div>
                <div class="col-lg-5 col-lg-offset-2 col-sm-6">
                    <!-- <img class="img-responsive" src="img/map.gif" alt="">  -->
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.content-section-a -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <ul class="list-inline">
                        <li><a href="#home">首页</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li><a href="#about">关于</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li><a href="#services">服务</a>
                        </li>
                        <li class="footer-menu-divider">&sdot;</li>
                        <li><a href="#contact">联系我们</a>
                        </li>
                    </ul>
                    <p class="copyright text-muted small">Copyright &copy; HangYang MengyuLu 2016. All Rights Reserved. </p>
                </div>
            </div>
        </div>
    </footer>

</body>

</html>