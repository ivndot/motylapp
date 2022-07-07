<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.AdultPhaseValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<%@ page import="java.util.Date"%>
<!--VARIABLES-->
<%!AdultPhaseValueObject adultPhase = null;
	ArrayList<AdultPhaseValueObject> adultPhaseList = null;%>
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
<title>Motyl | Fase adulto</title>
</head>
<body onload="itemFocus('adult')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>
		<!--CONTENT-->
		<div class="content">
			<div class="contentcanvas">
				<!--TITLE-->
				<h2 class="content-tittle">Fase adulto</h2>
				<!--SEARCH-->
				<form action="search_pupa.controller" class="search" method="GET"
					autocomplete="off">
					<input class="input-search" type="text"
						placeholder="Especie, Lote adulto, Lote pupa" name="criteria"
						autocomplete="false" />
					<button class="btn btn-search" type="submit" value="Buscar">Buscar</button>
				</form>
				<!--ADD BUTTON-->
				<a href="add-adult" class="btn btn-new-item"><i
					class="fas fa-plus-circle"></i> Nuevo</a>
				<!--EGG FASE CONTAINER-->
				<div class="egg-container">
					<!--TABLE FOR LARVA PHASE-->
					<table class="table">
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>Lote</th>
								<th>Cantidad liberaci&oacute;n</th>
								<th>Cantidad mariposario</th>
								<th>Total</th>
								<th>Lote Pupa</th>
								<th>Especie</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<!--ROW ITEM-->

							<%
							//delete message error
							String deleteMessage = (String) request.getAttribute("deleteMessage");

							// get list of larvas
							adultPhaseList = (ArrayList<AdultPhaseValueObject>) request.getAttribute("adultPhaseList");

							//for each
							for (AdultPhaseValueObject adultLote : adultPhaseList) {
							%>

							<tr>
								<!--IMAGE-->
								<td>
									<div style="background-image: url(uploadImages/<%=adultLote.getImgSpecie()%>)"
										class="img-table"></div>
								</td>
								<!--ID LOTE-->
								<td><%=adultLote.getId()%></td>
								<!--CANTIDAD LIBERACION-->
								<td><%=adultLote.getLiberation()%></td>
								<!--CANTIDAD MARIPOSARIO-->
								<td><%=adultLote.getSanctuary()%></td>
								<!--TOTAL-->
								<td><%=adultLote.getAdults()%></td>
								<!--LOTE PUPA-->
								<td><%=adultLote.getIdLotePupa()%></td>
								<!--SPECIE-->
								<td><%=adultLote.getCommonNameSpecie()%></td>
								<!--CONTROLS-->
								<td>
									<div class="controls">
										<a href="search_pupa.controller?id=<%=adultLote.getId()%>" class="btn-control">Editar</a><span>|</span><a
											data-id="<%=adultLote.getId()%>" href="#" class="btn-control btn-drop">Eliminar</a>
									</div>
								</td>
							</tr>

							<%
							}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--MODAL BOX-->
	<div class="modal-box">
		<div class="modal-content">
			<h2>Atenci&oacute;n</h2>
			<p>¿Est&aacute;s seguro de que deseas eliminar este elemento?</p>
			<p>Se eliminar&aacute;n los registros en cascada</p>
			<div class="modal-buttons">
				<a href="#" class="btn btn-cancel">Cancelar</a> <a href="#"
					class="btn btn-accept">Aceptar</a>
			</div>
		</div>
	</div>
	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
