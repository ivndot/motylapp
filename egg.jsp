<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
					<input class="input-search" type="text" placeholder="Monarca..."
						name="criteria" autocomplete="false">
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
							<tr>
								<!--IMAGE-->
								<td>
									<div style="background-image: url(/images/monarca.jpg)"
										class="img-table"></div>
								</td>
								<!--ID LOTE-->
								<td>001</td>
								<td>
									<!--START DATE-->
									<li class="main-info-table">16 Abr 2021</li> <!--EGGS-->
									<li class="second-info-table">20 huevos</li>
								</td>
								<td>
									<!--FINISH DATE-->
									<li class="main-info-table">17 May 2021</li> <!--LARVA-->
									<li class="second-info-table">15 larvas</li>
								</td>
								<!--DIAS REALES-->
								<td>11</td>
								<!--SPECIE-->
								<td>Monarca</td>
								<!--CONTROLS-->
								<td>
									<div class="controls">
										<a href="search_egg.controller?id=" class="btn-control">Editar</a><span>|</span><a
											data-id="2" href="#" class="btn-control btn-drop">Eliminar</a>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--MODAL BOX-->
	<%@ include file="modal_box.jsp"%>

	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
