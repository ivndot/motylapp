<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet" />
        <!--ICONS-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
        <title>Motyl | Añadir plantas</title>
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
                <h2 class="content-tittle">Añade una nueva planta</h2>
                <p class="content-pgph">Llena los siguientes campos para agregar una nueva planta.</p>
                <form class="content-add-item" method="POST" action="add_plants.controller" enctype="multipart/form-data">
                    <!--NAME-->
                    <label for="name" class="label-info">Nombre</label>
                    <input type="text" name="name" required class="input-text" maxlength="30" title="M&aacute;ximo 30 caracteres">
                    <!--LIGHT NECESSITY-->
                    <label for="light" class="label-info">Necesidad de luz</label>
                    <select id="light" name="light" class="combo-box" required>
                        <option value="Sombra">Sombra</option>
                        <option value="Semi-sombra">Semi-sombra</option>
                        <option value="Luz directa">Luz directa</option>
                    </select>
                    <!--CHOOSE IMAGE-->
                    <label for="img" class="label-info">Selecciona una imagen</label>
                    <input type="file" name="img" class="input-img" accept="image/png, image/jpg, image/jpeg" required>
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
