<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*, java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.*, mvc.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editor</title>
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
	<jsp:useBean id="dao" class="mvc.model.TarefaDAO" />
	
	<% String user = (String) request.getAttribute("user"); %>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Icon -->
			<div class="fadeIn.first">
				<img src="https://img.icons8.com/dusk/64/000000/add.png"
					id="icon" alt="User Icon">
			</div>
			
			<!-- Title -->
			<h2>Adicione uma nova tarefa</h2>
			
			<!-- Add -->
			<form action='adiciona_post' method='post' autocomplete="off">
				<input type="hidden" name="user" value="<%=user%>" readonly>
				<input type="text" class="fadeIn.second" name="type" placeholder='Tipo' required='required'> 
				<input type="text" class="fadeIn.third" name="task" placeholder='Tarefa' required='required'>
				<input type="date" class="fadeIn.third" name="date" placeholder='Data' required='required'>
				<input type="submit" class="fadeIn.fourth" value="Adicionar!">
			</form>
		</div>
	</div>

</body>
</html>