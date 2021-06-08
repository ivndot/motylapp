<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.PlantsValueObject"%>
<%@ page import="motyl.valueobject.SpeciesValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<!--VARIABLES-->
<%!PlantsValueObject plants = null;
	SpeciesValueObject specie = null;
	ArrayList<PlantsValueObject> plantsList = null;%>

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
<title>Motyl | Añadir especie</title>
</head>
<body onload="itemFocus('species')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>

		<!--CONTENT-->
		<div class="content">
			<div class="contentcanvas">
				<!--TITLE-->
                <h2 class="content-tittle">Editar especie</h2>
                <p class="content-pgph">Edita los campos que sean necesarios.</p>
				<form class="content-add-item" method="POST"
					action="edit_species.controller">
					<%
					// get item specie
					specie = (SpeciesValueObject) request.getAttribute("specie");
					%>
					<!--ID-->
					<input type="text" name="id" value="<%=specie.getId()%>" style="display:none;">
					<!--COMMON NAME-->
					<label for="commonName" class="label-info">Nombre
						com&uacute;n</label> <input type="text" name="commonName" required
						class="input-text" maxlength="50"
						title="M&aacute;ximo 50 caracteres" value="<%=specie.getCommonName()%>">
					<!--CIENTIFIC NAME-->
					<label for="cientificName" class="label-info">Nombre
						cientif&iacute;co</label> <input type="text" name="cientificName"
						class="input-text" required maxlength="50"
						title="M&aacute;ximo 50 caracteres" value="<%=specie.getCientificName()%>">
					<!--COLOR-->
					<label for="color" class="label-info">Color</label> <input
						type="text" name="color" class="input-text" required
						maxlength="20" title="M&aacute;ximo 20 caracteres" value="<%=specie.getColor()%>">
					<!--SIZE-->
					<label for="size" class="label-info">Tamaño</label> <select
						id="size" name="size" class="combo-box" required>
						<option value="grande" <%=specie.getSize().equals("Grande") ? "selected": ""%>>Grande</option>
						<option value="mediano" <%=specie.getSize().equals("Mediano") ? "selected": ""%>>Mediano</option>
						<option value="chico" <%=specie.getSize().equals("Chico") ? "selected": ""%>>Chico</option>
					</select>
					<!--FOOD-->
					<label for="food" class="label-info">Tipo de
						alimentaci&oacute;n</label> <select id="food" name="food"
						class="combo-box" required>
						<option value="0" <%=specie.getFood() == 0? "selected": ""%>>Frug&iacute;vora</option>
						<option value="1" <%=specie.getFood() == 1? "selected": ""%>>Nectar&iacute;fera</option>
					</select>
					<!--HOME PLANT-->
					<label for="homePlant" class="label-info">Planta hospedera</label>
					<select id="homePlant" name="homePlant" class="combo-box" required>
						<%
						//get list of plants
						plantsList = (ArrayList<PlantsValueObject>) request.getAttribute("plantsList");
						// for each
						for (PlantsValueObject plant : plantsList) {
						%>
						<option value="<%=plant.getId()%>" <%=specie.getIdPlant() == plant.getId()? "selected": ""%>><%=plant.getName()%></option>
						<%
						}
						%>

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
