<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.SpeciesValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<!--VARIABLES-->
<%!SpeciesValueObject species = null;
	ArrayList<SpeciesValueObject> speciesList = null;%>
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
<title>Motyl | Añadir lote de huevos</title>
</head>
<body onload="itemFocus('egg')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>
		<!--CONTENT-->
		<div class="content">
			<div class="contentcanvas">
				<!--TITLE-->
				<h2 class="content-tittle">Añade un nuevo lote de huevos</h2>
				<p class="content-pgph">Llena los siguientes campos para agregar
					un nuevo lote de huevos.</p>
				<form class="content-add-item" method="GET"
					action="add_egg.controller">
					<!--RECOLECTED EGGS-->
					<label for="numberEggs" class="label-info">Huevos
						recolectados</label> <input type="text" name="numberEggs" required
						class="input-text" pattern="[0-9]+" title="Solo n&uacute;meros"
						maxlength="5">
					<!--INIT DATE-->
					<label for="initDate" class="label-info">Fecha de inicio</label> <input
						type="date" name="initDate" required class="input-text">
					<!--RECOLECTED LARVAS-->
					<label for="numberLarvas" class="label-info">Larvas
						recolectadas</label> <input type="text" name="numberLarvas"
						class="input-text" pattern="[0-9]+" title="Solo n&uacute;meros"
						maxlength="5">
					<!--END DATE-->
					<label for="endDate" class="label-info">Fecha de
						finalizaci&oacute;n</label> <input type="date" name="endDate"
						class="input-text">
					<!--SPECIE-->
					<label for="specieId" class="label-info">Especie</label> <select
						id="specieId" name="specieId" class="combo-box" required>

						<%
						//get list of species
						speciesList = (ArrayList<SpeciesValueObject>) request.getAttribute("speciesList");
						// for each
						for (SpeciesValueObject specie : speciesList) {
						%>
						<option value="<%=specie.getId()%>"><%=specie.getCommonName()%></option>
						<%
						}
						%>
					</select>
					<!--BUTTON SUBMIT-->
					<button class="btn btn-add-item" type="submit">Agregar</button>
				</form>
			</div>
		</div>
	</div>
	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
