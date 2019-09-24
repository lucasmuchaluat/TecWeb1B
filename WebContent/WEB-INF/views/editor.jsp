<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*, java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<% String type = (String) request.getAttribute("type"); %>
	<% String task = (String) request.getAttribute("task"); %>
	<% String date = (String) request.getAttribute("date"); %>
	<% String id = (String) request.getAttribute("id"); %>

	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Icon -->
			<div class="fadeIn.first">
					<img src="https://img.icons8.com/clouds/100/000000/multi-edit.png" id="icon" alt="User Icon">
			</div>
			
			<!-- Title -->
			<h2>Edite a tarefa selecionada</h2>
			
			<!-- Editor -->
			<form action='edita_post' method='post' autocomplete="off">
				<input type="hidden" name="user" value="<%=user%>" required='required' readonly>
				<input type="hidden" name="id" value="<%=id%>" required='required' readonly> <input
					type="text" class="fadeIn.second" name="type" value="<%=type%>"
					placeholder="Username" required='required'> <input
					type="text" id="password" class="fadeIn.third" name="task"
					value="<%=task%>" placeholder="Password" required='required'>
				<input type="date" class="fadeIn.third" name="date"
					value="<%=date%>" placeholder="Password" required='required'>
				<input type="submit" class="fadeIn.fourth" value="Atualizar!">
			</form>
		</div>
	</div>

</body>
</html>