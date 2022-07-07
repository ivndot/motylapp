<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.PupaPhaseValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<%@ page import="java.util.Date"%>
<!--VARIABLES-->
<%!PupaPhaseValueObject pupaPhase = null;
	ArrayList<PupaPhaseValueObject> pupaPhaseList = null;%>
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
<title>Motyl | Fase pupa</title>
</head>
<body onload="itemFocus('pupa')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>
		<!--CONTENT-->
		<div class="content">
			<div class="contentcanvas">
				<!--TITLE-->
				<h2 class="content-tittle">Fase pupa</h2>
				<!--SEARCH-->
				<form action="search_pupa.controller" class="search" method="GET"
					autocomplete="off">
					<input class="input-search" type="text"
						placeholder="Especie, Lote pupa, Lote larva" name="criteria"
						autocomplete="false" />
					<button class="btn btn-search" type="submit" value="Buscar">Buscar</button>
				</form>
				<!--ADD BUTTON-->
				<a href="add-pupa" class="btn btn-new-item"><i
					class="fas fa-plus-circle"></i> Nuevo</a>
				<!--EGG FASE CONTAINER-->
				<div class="egg-container">
					<!--TABLE FOR LARVA PHASE-->
					<table class="table">
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>Lote</th>
								<th>Inicio</th>
								<th>Fin</th>
								<th>Lote larva</th>
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
							pupaPhaseList = (ArrayList<PupaPhaseValueObject>) request.getAttribute("pupaPhaseList");

							//for each
							for (PupaPhaseValueObject pupaLote : pupaPhaseList) {
							%>

							<tr>
								<!--IMAGE-->
								<td>
									<div
										style="background-image: url(uploadImages/<%=pupaLote.getImgSpecie()%>)"
										class="img-table"></div>
								</td>
								<!--ID LOTE-->
								<td><%=pupaLote.getId()%></td>
								<td>
									<!--START DATE-->
									<li class="main-info-table"><%=Utility.formmatingDate(pupaLote.getInitDate())%></li> 
									<!--PUPAS-->
									<li class="second-info-table"><%=pupaLote.getInitPupas()%> pupas</li>
								</td>
								<td>
									<!--FINISH DATE-->
									<li class="main-info-table"><%=pupaLote.getEndDate() == null ? "-" : Utility.formmatingDate(pupaLote.getEndDate())%></li> 
									<!--Adultos-->
									<li class="second-info-table"><%=pupaLote.getEndAdults() == 0 ? "Sin" : pupaLote.getEndAdults()%> adultos</li>
								</td>
								<!--LOTE LARVA-->
								<td><%=pupaLote.getIdLoteLarva()%></td>
								<!--SPECIE-->
								<td><%=pupaLote.getCommonNameSpecie()%></td>
								<!--CONTROLS-->
								<td>
									<div class="controls">
										<a href="search_pupa.controller?id=<%=pupaLote.getId()%>" class="btn-control">Editar</a><span>|</span><a
											data-id="<%=pupaLote.getId()%>" href="#" class="btn-control btn-drop">Eliminar</a>
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