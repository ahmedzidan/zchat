<html>
<head>
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/wow.min.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
	//this will be for me
</script>
</head>
<body>
	<!-- header-section-starts -->
	<div class="header" id="home">
		<div class="container">
			<div class="logo wow fadeInRight" data-wow-delay="0.4s">
				
			</div>
			<span class="menu"></span>
			<div class="top-menu wow fadeInLeft" data-wow-delay="0.4s">
				<ul>
					<li><a class="active scroll hvr-shutter-out-horizontal" href="#home">Home</a></li>
					<li><a class="scroll hvr-shutter-out-horizontal" href="#about">About us</a></li>
					<li><a class="scroll hvr-shutter-out-horizontal" href="#work">howItWork</a></li>
					<li><a class="scroll hvr-shutter-out-horizontal" href="#contact">Contact Us</a></li>
					<li><a class="scroll hvr-shutter-out-horizontal" href="signup.html">signup</a></li>
				</ul>
			</div>
				<!-- script for menu -->
				<script>
				$( "span.menu" ).click(function() {
				  $( ".top-menu" ).slideToggle( "slow", function() {
				    // Animation complete.
				  });
				});
			</script>
			<!-- script for menu -->

			<div class="clearfix"></div>
		</div>
	</div>

	
<div class="banner wow fadeInUp" data-wow-delay="0.4s">
		<div class="container">
			<div class="banner-info text-center">
				<h2 class="wow bounceInLeft" data-wow-delay="0.4s">communicate with your friend in zidanco chat :)</h2>
				<p class="wow bounceInLeft" data-wow-delay="0.4s">zchat easy way to comminucate with your friend , enjoy with your own chat and invent your friend</p>
				<div class="details wow fadeInLeft" data-wow-delay="0.4s">
					<form action="login" method="get">
						
						<li>
							<input type="text" name="Email" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email Address';}">
							
						</li>
						<li>
							<input type="text" name="Password" class="text" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
						</li>
							<input type="submit" value="login">
					</form>
	
		</div>
			</div>
			<div class="header-bottom">
		<div class="right-grid-1">
					<section class="slider">
							<div class="flexslider">
							  <ul class="slides">
								<li>
									<img src="images/chat1.jpeg" class="img-responsive" alt="" />
									</li>
									<li>
									<img src="images/chat4.png" class="img-responsive" alt="" />
									</li>
									<li>
									<img src="images/chat7.png" class="img-responsive" alt="" />
									</li>
									<li>
									<img src="images/chat10.jpg" class="img-responsive" alt="" />
									</li>
							  </ul>
							</div>
						  </section>
						  <!-- FlexSlider -->
						  <script defer src="js/jquery.flexslider.js"></script>
						  <script type="text/javascript">
							$(function(){
							  SyntaxHighlighter.all();
							});
							$(window).load(function(){
							  $('.flexslider').flexslider({
								animation: "slide",
								start: function(slider){
								  $('body').removeClass('loading');
								}
							  });
							});
						  </script>
                    </div>	
				</div>	
								
		</div>
		</div>	
	
</body>
</html>					
					
					
					
					
