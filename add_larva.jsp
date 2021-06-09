<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!--IMPORTS-->
<%@ page import="motyl.valueobject.EggPhaseValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<!--VARIABLES-->
<%!EggPhaseValueObject eggphase = null;
	ArrayList<EggPhaseValueObject> eggphaseList = null;%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!--STYLES-->
<link rel="stylesheet" href="css/components.css" />
<link rel="stylesheet" href="css/styles.css" />
<!--FONTS-->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet" />
<!--ICONS-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<title>Motyl | Añadir lote de larvas</title>
</head>
<body onload="itemFocus('larva')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>
		<!--CONTENT-->
		<div class="content">
			<div class="contentcanvas">
				<!--TITLE-->
				<h2 class="content-tittle">Añade un nuevo lote de larvas</h2>
				<p class="content-pgph">Llena los siguientes campos para agregar
					un nuevo lote de larvas.</p>
				<form class="content-add-item" method="get"
					action="add_larva.controller">
					<!--RECOLECTED LARVAS-->
					<label for="numberLarvas" class="label-info">Larvas
						iniciales</label> <input type="text" name="numberLarvas"
						class="input-text" pattern="[0-9]+" title="Solo n&uacute;meros"
						maxlength="5" required />
					<!--INIT DATE-->
					<label for="initDate" class="label-info">Fecha de inicio</label> <input
						type="date" name="initDate" required class="input-text" />
					<!--CHANGE LEAF DATE-->
					<label for="leafDate" class="label-info">Fecha de cambio de
						hoja</label> <input type="date" name="leafDate" class="input-text" />
					<!--RECOLECTED PUPAS-->
					<label for="numberPupas" class="label-info">Pupas finales</label> <input
						type="text" name="numberPupas" class="input-text" pattern="[0-9]+"
						title="Solo n&uacute;meros" maxlength="5" />
					<!--END DATE-->
					<label for="endDate" class="label-info">Fecha de
						finalizaci&oacute;n</label> <input type="date" name="endDate"
						class="input-text" />
					<!--EGG LOTE-->
					<label for="eggLote" class="label-info">Lote fase huevo</label> <select
						id="eggLote" name="eggLote" class="combo-box" required>
						<%
						//get list of eggs
						eggphaseList = (ArrayList<EggPhaseValueObject>) request.getAttribute("eggphaseList");
						// for each
						for (EggPhaseValueObject eggLote : eggphaseList) {
						%>
						<option value="<%=eggLote.getId()%>"><%=eggLote.getId()%></option>
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

