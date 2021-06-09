<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--HEADER-->
<header class="header">
	<div class="menuicon">
		<i id="menubutton" class="fas fa-bars fa-2x"></i>
	</div>
	<div class="logocontainer">
		<object data="images/logo.svg" width="50" height="50"> </object>
		<h1 class="logotext">Motyl</h1>
	</div>

</header>
<!--MENU-->
<div class="menu">
	<ul>
		<!--ESPECIE-->
		<li class="item"><a id="species" href="./species" class="itemhref"> <img
				src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAABmJLR0QA/wD/AP+gvaeTAAADBklEQVRIie2WTWxUVRiGn+90sGOlSqiJcWmCC9KFcWagiRDIndHoxgWLjgsRaaaxmBoWBFbozh+UBYsGraHTxGiCUhckoiRC29FUJeROd0KiJGpJMUIg2lKYIcy8LspMZqYzc68/K8K3uue97/c+55ycnHvhXt3tZQApf+xtYa9hzFpZo2t/eXBiIp0u/R+A/mPHOq49ttAvZ7sQMYmR6Q2Z/QaQ9LNLQFeN/7zB8GQiM/1foCk/6wkOA+tr5BtTicwDEQDBVasHrxdMJv3sR8UCu7/bnFn8J8BNM9nu+6I2IrSDO7taU1cAHIBhZ5r0G7CzM8qslz8SDwv18kfinVFmDb3cBIqkM1Uwpq/aZK0zuRkvn00HQVP58RdMbgZY18rjjJNVcNm540CxTWbUxKdJf2xvK4OXz+6TdBSItskpGKXjVXDuyYE/YXkmbcrADqb87J7GF6l8dtjEezTZ2roA48vTiaG/qmAAGUcDwMs+OJj0x/or46Q/1i8xEqpX+qw6icrD8/6HXUtE/gBWh8i4arfLvQCKuB+BnhA9izdvdT/yw1Ppm1Cz4i8SQzeAT8LMHOhRxN4sR9xbIaEYfFyB1oEBrFQ6RPtDVuveZrAt5EQLJdOhWqEOPNn3yk+gl4BLIcJ6gLUhfPMS23PxwQu1YutTKNnT+fFNJfSMw+JATPBoO4LB78CshC90ajqR+R4ztfCuLO/s+FZz+oD6O/bf1DmcXp2KDX4bCPb88T5D3wCdAaELd/q7A3xFpC1TGwbP1oqu0eXQGyGgGHYOOB/kW85yrzeKkUZBsDFEGKDPQQYW7Df1NUorVgw8FIJ6uWPVqtHy/cVR4HII/4rMZuDfglIkO/D1EzuWcr3D1yU7EAL8ayBYKOjO/vnhrtWHK4PomuvvAxfa+KHJd2AleLHjHRmnW0SUDYYmetO3KsLJx3cX5bQLKLegniovuHcDwTlvoLA1dvFZM7YDJ4B5oAA2h7Sz2X/YdGxwUmIAbG7ZyzxwQujFLfG553LeQKHFQu7VXVx/Ay9EChbN/JCEAAAAAElFTkSuQmCC"
				class="iconmargin" /> <span
				data-elements="">Especies</span>
		</a></li>
		<!--PLANTA-->
		<li class="item"><a id="plant" href="./plants" class="itemhref"> <i
				class="fas fa-seedling fa-2x iconmargin"></i> <span data-elements="">Plantas</span>
		</a></li>
		<!--FASES-->
		<li class="item"><a href="#" class="itemhref itemflex"> <span
				class="itemalign"><i class="fab fa-buffer fa-2x iconmargin"></i><span
					data-elements="">Fases</span></span> <span data-elements=""><i
					id="dropdownicon" class="fas fa-angle-down"></i></span></i>
		</a></li>
		<!--SUBMENU-->
		<div data-elements="" class="submenu collapse-phases">
			<ul>
				<li class="subitem"><a id="egg" class="subitemhref" href="./egg-phase">Huevo</a></li>
				<li class="subitem"><a id="larva" class="subitemhref" href="#">Larva</a></li>
				<li class="subitem"><a id="pupa" class="subitemhref" href="#">Pupa</a></li>
				<li class="subitem"><a id="adult" class="subitemhref" href="#">Adulto</a></li>
			</ul>
		</div>
	</ul>

</div>