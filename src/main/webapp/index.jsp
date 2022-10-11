<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Register</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="style.css">
</head>
<body>
<
	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2>Welcome to EazyKart</h2>
						<h3> Please Enter the details</h3><br><br>
					
						<form method="post" action="register" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="Your Name" required="required"/>
							</div>
							<div class="form-group">
								<label for="balance"><i class="zmdi zmdi-balance"></i></label> <input
									type="text" name="city" id="balance" placeholder="Enter current location" required="required"/>
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-email"></i></label> <input
									type="text" name="mobile" id="email" placeholder="Enter mobile no. (10 digits)" required="required"/>
							</div>
							<div class="form-group">
								<label for="pan"><i class="zmdi zmdi-account-box"></i></label> <input
									type="text" name="area" id="pan" placeholder="Enter Destination" required="required"/>
							</div>
							<div class="form-group">
								<label for="pass"><i class="zmdi zmdi-lock"></i></label> <input
									type="number" name="weight" id="pass" placeholder="Enter weight in g." required="required"/>
							</div>
							<div class="form-group">
								<label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="number" name="distance" id="re_pass"
									placeholder="Enter Distance in km." required="required"/>
							</div>
							
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Submit" />
							</div>
							<br>
							<a href="table.jsp" class="signup-image-link">Dashboard</a>	
						</form>
					</div>
					
				</div>
			</div>
		</section>


	</div>
	
	

</body>
</html>