<%-- 
    Document   : index
    Created on : 08-Apr-2020, 12:28:44 AM
    Author     : RUDRESH PATEL
--%>

<%@page isELIgnored="false"%>
<html>
<head>
	<title>Student Management</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/styles.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$(".teacher-signup-form").hide();
			$(".teacher").css("background","none");

			$(".teacher").click(function(){
				$(".student-signup-form").hide();
				$(".teacher-signup-form").show();
				$(".student").css("background","none");
				$(".teacher").css("background","#fff");
			});

			$(".student").click(function(){
				$(".teacher-signup-form").hide();
				$(".student-signup-form").show();
				$(".teacher").css("background","none");
				$(".student").css("background","#fff");
			})

		});
	</script>
</head>
<body>
	<div class="container">
		<div class="student">Student</div>
		<div class="teacher">Teacher</div>

		<div class="student-signup-form">
			<form method="POST" action="#">
				<input type="number" name="studentID" placeholder="Enrollment number" class="input" required=""><br>
				<!-- <input type="email" name="" placeholder="Email Address" class="input"><br> -->
				<input type="password" name="studentPassword" placeholder="Password" class="input" required=""><br>
				<div class="btn">
					<button>Login</button>
				</div>
			</form>
			
		</div>
		<div class="teacher-signup-form">
			<form method="POST" action="#">
				<input type="number" name="TeacherID" placeholder="Teachers ID" class="input" required=""><br>
				<!-- <input type="email" name="" placeholder="Email Address" class="input"><br> -->
				<input type="password" name="TeacherPassword" placeholder="Password" class="input" required=""><br>
				<div class="btn">
					<button>Login</button>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>