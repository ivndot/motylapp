<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.PlantsValueObject"%>
<%@ page import="motyl.utility.Utility"%>
<!--VARIABLES-->
<%!PlantsValueObject plant = null;%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--STYLES-->
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/styles.css" />
<!--FONTS-->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet" />
<!--ICONS-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<title>Motyl | Editar planta</title>
</head>
<body onload="itemFocus('plant')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>
		<!--CONTENT-->
		<div class="content">
		
		<%
		//get plants object
		plant = (PlantsValueObject) request.getAttribute("plant");
		%>
			<div class="contentcanvas">
				<!--TITLE-->
				<h2 class="content-tittle">Editar planta</h2>
				<p class="content-pgph">Edita los campos que sean necesarios.</p>
				<form class="content-add-item" method="POST"
					action="edit_plants.controller">
										<!--ID-->
					<input type="text" name="id" value="<%=plant.getId()%>" style="display:none;">
					<!--NAME-->
					<label for="name" class="label-info">Nombre</label> <input
						type="text" name="name" required class="input-text" maxlength="30"
						title="M&aacute;ximo 30 caracteres" value="<%=plant.getName()%>">
					<!--LIGHT NECESSITY-->
					<label for="light" class="label-info">Necesidad de luz</label> <select
						id="light" name="light" class="combo-box" required>
						<option value="Sombra" <%=plant.getLightNeccesity().equals("Sombra") ? "selected":""%>>Sombra</option>
						<option value="Semi-sombra" <%=plant.getLightNeccesity().equals("Semi-sombra") ? "selected":""%>>Semi-sombra</option>
						<option value="Luz directa" <%=plant.getLightNeccesity().equals("Luz directa") ? "selected":""%>>Luz directa</option>
					</select>
					<!--BUTTON SUBMIT-->
					<button class="btn btn-add-item" type="submit">Aceptar</button>
				</form>
			</div>
		</div>
	</div>
	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
