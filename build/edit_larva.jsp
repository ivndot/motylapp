<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.LarvaPhaseValueObject"%>
<%@ page import="motyl.valueobject.EggPhaseValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<%!EggPhaseValueObject eggphase = null;
	ArrayList<EggPhaseValueObject> eggPhaseList = null;
	LarvaPhaseValueObject larvaphase = null;%>
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
<title>Motyl | Editar lote de larvas</title>
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
				<h2 class="content-tittle">Editar lote de larvas</h2>
				<p class="content-pgph">Edita los campos que sean necesarios.</p>
				<form class="content-add-item" method="get"
					action="edit_larva.controller">
					<%
					//get larva lote
					larvaphase = (LarvaPhaseValueObject) request.getAttribute("larvaphase");
					%>
					<!--ID-->
					<input type="text" name="id" value="<%=larvaphase.getId()%>"
						style="display: none;">
					<!--RECOLECTED LARVAS-->
					<label for="numberLarvas" class="label-info">Larvas
						iniciales</label> <input type="text" name="numberLarvas"
						class="input-text" pattern="[0-9]+" title="Solo n&uacute;meros"
						maxlength="5" required value="<%=larvaphase.getInitLarvas()%>" />
					<!--INIT DATE-->
					<label for="initDate" class="label-info">Fecha de inicio</label> <input
						type="date" name="initDate" required class="input-text"
						value="<%=larvaphase.getInitDate()%>" />
					<!--CHANGE LEAF DATE-->
					<label for="leafDate" class="label-info">Fecha de cambio de
						hoja</label> <input type="date" name="leafDate" class="input-text"
						value="<%=larvaphase.getChangeDate()%>" />
					<!--RECOLECTED PUPAS-->
					<label for="numberPupas" class="label-info">Pupas finales</label> <input
						type="text" name="numberPupas" class="input-text" pattern="[0-9]+"
						title="Solo n&uacute;meros" maxlength="5"
						value="<%=larvaphase.getEndPupas()%>" />
					<!--END DATE-->
					<label for="endDate" class="label-info">Fecha de
						finalizaci&oacute;n</label> <input type="date" name="endDate"
						class="input-text" value="<%=larvaphase.getEndDate()%>" />
					<!--EGG LOTE-->
					<label for="eggLote" class="label-info">Lote fase huevo</label> <select
						id="eggLote" name="eggLote" class="combo-box" required>
						<%
						//get list of eggs
						eggPhaseList = (ArrayList<EggPhaseValueObject>) request.getAttribute("eggPhaseList");
						// for each
						for (EggPhaseValueObject eggLote : eggPhaseList) {
						%>
						<option value="<%=eggLote.getId()%>"
							<%=eggLote.getId() == larvaphase.getIdLoteEgg() ? "selected" : ""%>><%=eggLote.getId()%></option>
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
