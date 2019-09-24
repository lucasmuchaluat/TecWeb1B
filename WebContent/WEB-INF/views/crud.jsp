<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crud</title>
<link href="Styles/crud.css" rel="stylesheet">
</head>
<body>
	<jsp:useBean id="dao" class="mvc.model.TarefaDAO" />

	<%
		String user = (String) request.getAttribute("user");
	%>
	<div class="container-crud">
		<form action='logout'>
			Bem vindo,
			<%=user%>. <input type='submit' value='Sair'>
		</form>
		<form action='adiciona_get' method='get'>
			<input type="hidden" name="user" value="<%=user%>" readonly> <input
				type='submit' value='Adicionar Tarefa'>
		</form>
		<br />
		<table border="1" class="table">
			<tr>
				<td><b>Id</b></td>
				<td><b>User</b></td>
				<td><b>Type</b></td>
				<td><b>Task</b></td>
				<td><b>Data</b></td>
				<td><b>Option</b>
			</tr>
			<c:forEach var="tarefa" items="<%=dao.getTarefas()%>" varStatus="id">
	
				<td>${tarefa.id}</td>
				<td>${tarefa.user}</td>
				<td>${tarefa.type}</td>
				<td>${tarefa.task}</td>
				<td><fmt:formatDate value="${tarefa.date.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><form method='get' action='edita_get'>
						<input type="hidden" name="id" value="${tarefa.id}" readonly>
						<input type="hidden" name="user" value="<%=user%>" readonly>
						<input type="hidden" name="type" value="${tarefa.type}" readonly>
						<input type="hidden" name="task" value="${tarefa.task}" readonly>
						<input type="hidden" name="date"
							value=<fmt:formatDate value="${tarefa.date.time}" pattern="yyyy-MM-dd"/>
							readonly> <input type='submit' value='Editar'>
					</form>
					<form method='post' action='apaga'>
						<input type="hidden" name="id" value="${tarefa.id}" readonly>
						<input type="hidden" name="user" value="<%=user%>" readonly>
						<input type='submit' value='Excluir'>
					</form></td>
				</tr>
			</c:forEach>
		</table>
		<br />
	</div>
</body>
</html>