<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.EggPhaseValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<%@ page import="java.util.Date"%>
<!--VARIABLES-->
<%!EggPhaseValueObject eggPhase = null;
	ArrayList<EggPhaseValueObject> eggPhaseList = null;%>

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
<title>Motyl | Fase huevo</title>
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
				<h2 class="content-tittle">Fase huevo</h2>
				<!--SEARCH-->
				<form action="search_egg.controller" class="search" method="GET"
					autocomplete="off">
					<input class="input-search" type="text"
						placeholder="Especie o Lote" name="criteria" autocomplete="false">
					<button class="btn btn-search" type="submit" value="Buscar">Buscar</button>
				</form>
				<!--ADD BUTTON-->
				<a href="add-egg" class="btn btn-new-item"><i
					class="fas fa-plus-circle"></i> Nuevo</a>
				<!--EGG FASE CONTAINER-->
				<div class="egg-container">

					<!--TABLE FOR EGG FASE-->
					<table class="table">
						<thead>
							<tr>
								<th>&nbsp;</th>
								<th>Lote</th>
								<th>Inicio</th>
								<th>Fin</th>
								<th>D&iacute;as reales</th>
								<th>Especie</th>
								<th>&nbsp;</th>
							</tr>
						</thead>
						<tbody>
							<!--ROW ITEM-->
							<%
							//delete message error
							String deleteMessage = (String) request.getAttribute("deleteMessage");

							// get list of plants
							eggPhaseList = (ArrayList<EggPhaseValueObject>) request.getAttribute("eggPhaseList");

							//for each
							for (EggPhaseValueObject eggLote : eggPhaseList) {
							%>

							<tr>
								<!--IMAGE-->
								<td>
									<div
										style="background-image: url(uploadImages/<%=eggLote.getImgSpecie()%>)"
										class="img-table"></div>
								</td>
								<!--ID LOTE-->
								<td><%=eggLote.getId()%></td>
								<td>
									<!--START DATE-->
									<li class="main-info-table"><%=Utility.formmatingDate(eggLote.getInitDate())%></li>
									<!--EGGS-->
									<li class="second-info-table"><%=eggLote.getRecolectedEggs()%>
										huevos</li>
								</td>
								<td>
									<!--FINISH DATE-->
									<li class="main-info-table"><%=eggLote.getEndDate() == null ? "-" : Utility.formmatingDate(eggLote.getEndDate())%></li>
									<!--LARVA-->
									<li class="second-info-table"><%=eggLote.getFinalLarvs() == 0 ? "Sin" : eggLote.getFinalLarvs()%>
										larvas</li>
								</td>
								<!--DIAS REALES-->
								<td><%=eggLote.getRealDays() == 0 ? "-" : eggLote.getRealDays()%></td>
								<!--SPECIE-->
								<td><%=eggLote.getCommonNameSpecie()%></td>
								<!--CONTROLS-->
								<td>
									<div class="controls">
										<a href="search_egg.controller?id=<%=eggLote.getId()%>"
											class="btn-control">Editar</a><span>|</span><a
											data-id="<%=eggLote.getId()%>" href="#"
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
                <h2>Atención</h2>
                <p>¿Est&aacute;s seguro de que deseas eliminar este elemento?</p>
                <p>Se eliminar&aacute;n los registros en cascada</p>
                <div class="modal-buttons">
                    <a href="#" class="btn btn-cancel">Cancelar</a>
                    <a href="#" class="btn btn-accept">Aceptar</a>
                </div>
            </div>
        </div>
	<!--DELETE ERROR-->
	<%
	if (deleteMessage != null) {
	%>
	<script>alert("<%=deleteMessage%>
		")
	</script>
	<%
	}
	%>
	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
