<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign In</title>
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
				<img src="https://img.icons8.com/material/96/000000/add-user-male--v1.png"
					id="icon" alt="User Icon" />
			</div>
			
			<!-- Title -->
			<h2>Crie um novo usuário</h2>

			<!-- Signin Form -->
			<form action='signin' method='post'>
				<input type="text" id="login" class="fadeIn.second" name="user"
					placeholder="Username" required='required'> <input type="text" id="password"
					class="fadeIn.third" name="password" placeholder="Password" required='required'> <input
					type="text" id="password" class="fadeIn.third" name="password_check"
					placeholder="Confirme a password" required='required'> <input type="submit"
					class="fadeIn.fourth" value="Sign In">
			</form>
			
			<!-- Login Form -->
			<div id="formFooter">
				<a class="underlineHover" href="entrar">Já é
					cadastrado? Faça Login!</a>
			</div>
			
		</div>
	</div>

</body>
</html>