<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="Styles/login.css" rel="stylesheet">
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Icon -->
			<div class="fadeIn.first">
				<img src="https://img.icons8.com/dusk/64/000000/tasklist.png"
					id="icon" alt="User Icon" />
			</div>
			
			<!-- Title -->
			<h2>Faça seu login</h2>

			<!-- Login Form -->
			<form action='fazerLogin' method='get'>
				<input type="text" id="login" class="fadeIn.second" name="user"
					placeholder="Username" required='required'> <input type="text" id="password" name='password'
					class="fadeIn.third" name="password" placeholder="Password" required='required'> <input
					type="submit" class="fadeIn.fourth" value="Log In">
			</form>

			<!-- Signin Form -->
			<div id="formFooter">
				<a class="underlineHover" href="cadastrar">Ainda não é
					cadastrado? Cadastre-se!</a>
			</div>

		</div>
	</div>

</body>
</html>