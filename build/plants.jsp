<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--IMPORTS-->
<%@ page import="motyl.valueobject.PlantsValueObject"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="motyl.utility.Utility"%>
<!--VARIABLES-->
<%!PlantsValueObject plants = null;
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
<title>Motyl | Plantas</title>
</head>
<body onload="itemFocus('plant')">
	<!--CONTAINER-->
	<div class="container">
		<!--HEADER AND MENU-->
		<%@ include file="menu.jsp"%>
		<!--CONTENT-->
		<div class="content">
			<div class="contentcanvas">
				<!--TITLE-->
				<h2 class="content-tittle">Plantas</h2>
				<!--SEARCH-->
				<form action="search_plants.controller" class="search" method="GET"
					autocomplete="off">
					<input class="input-search" type="text" placeholder="Asclepias..."
						name="criteria" autocomplete="false">
					<button class="btn btn-search" type="submit" value="Buscar">Buscar</button>
				</form>
				<!--ADD BUTTON-->
				<a href="add-plants" class="btn btn-new-item"><i
					class="fas fa-plus-circle"></i> Nuevo</a>
				<!--GRID FOR ITEMS-->
				<div class="plants-container">
					<%
					//delete message error
					String deleteMessage = (String) request.getAttribute("deleteMessage");

					// get list of plants
					plantsList = (ArrayList<PlantsValueObject>) request.getAttribute("plantsList");

					//for each
					for (PlantsValueObject plants : plantsList) {
					%>

					<!--ITEMS CARDS-->
					<div class="plants-card">
						<div class="img-items"
							style="background-image: url(uploadImages/<%=plants.getImg()%>)"></div>
						<!--HEADER-->
						<div class="info-plants-header">
							<p class="species-header-normalname"><%=plants.getName()%></p>
						</div>
						<!--MAIN-->
						<div class="info-plants-main">
							<div>
								<i class="fas fa-cloud-sun"></i>
								<p class="plants-main-sun"><%=plants.getLightNeccesity()%></p>
							</div>
						</div>
						<!--FOOTER-->
						<div class="info-species-footer">
							<div class="controls">
								<a href="search_plants.controller?id=<%=plants.getId()%>"
									class="btn-control">Editar</a><span>|</span><a
									data-id="<%=plants.getId()%>" href="#"
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
	<script>alert("<%=deleteMessage%>")
	</script>
	<%
	}
	%>
	<!--JS-->
	<script src="js/main.js"></script>
</body>
</html>
