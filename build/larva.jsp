<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.LarvaPhaseValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<%@ page import="java.util.Date"%>
<!--VARIABLES-->
<%!LarvaPhaseValueObject larvaPhase = null;
	ArrayList<LarvaPhaseValueObject> larvaPhaseList = null;%>
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
<title>Motyl | Fase larva</title>
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
				<h2 class="content-tittle">Fase larva</h2>
				<!--SEARCH-->
				<form action="search_larva.controller" class="search" method="GET"
					autocomplete="off">
					<input class="input-search" type="text" placeholder="Especie, Lote larva, Lote huevo"
						name="criteria" autocomplete="false" />
					<button class="btn btn-search" type="submit" value="Buscar">Buscar</button>
				</form>
				<!--ADD BUTTON-->
				<a href="add-larva" class="btn btn-new-item"><i
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
								<th>Cambio de hoja</th>
								<th>Lote huevo</th>
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
							larvaPhaseList = (ArrayList<LarvaPhaseValueObject>) request.getAttribute("larvaPhaseList");

							//for each
							for (LarvaPhaseValueObject larvaLote : larvaPhaseList) {
							%>

							<tr>
								<!--IMAGE-->
								<td>
									<div
										style="background-image: url(uploadImages/<%=larvaLote.getImgSpecie()%>)"
										class="img-table"></div>
								</td>
								<!--ID LOTE-->
								<td><%=larvaLote.getId()%></td>
								<td>
									<!--START DATE-->
									<li class="main-info-table"><%=Utility.formmatingDate(larvaLote.getInitDate())%></li>
									<!--LARVAS-->
									<li class="second-info-table"><%=larvaLote.getInitLarvas()%>
										larvas</li>
								</td>
								<td>
									<!--FINISH DATE-->
									<li class="main-info-table"><%=larvaLote.getEndDate() == null ? "-" : Utility.formmatingDate(larvaLote.getEndDate())%></li>
									<!--PUPAS-->
									<li class="second-info-table"><%=larvaLote.getEndPupas() == 0 ? "Sin" : larvaLote.getEndPupas()%>
										pupas</li>
								</td>
								<!--FECHA CAMBIO HOJA-->
								<td><%= larvaLote.getChangeDate() == null ? "-" : Utility.formmatingDate(larvaLote.getChangeDate())%></td>
								<!--LOTE HUEVO-->
								<td><%=larvaLote.getIdLoteEgg()%></td>
								<!--SPECIE-->
								<td><%=larvaLote.getCommonNameSpecie()%></td>
								<!--CONTROLS-->
								<td>
									<div class="controls">
										<a href="search_larva.controller?id=<%=larvaLote.getId()%>"
											class="btn-control">Editar</a><span>|</span><a
											data-id="<%=larvaLote.getId()%>" href="#"
											class="btn-control btn-drop">Eliminar</a>
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
