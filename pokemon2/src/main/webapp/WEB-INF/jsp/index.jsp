<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.6/cosmo/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<form:form action="insert" method="post" modelAttribute="ash">
		<span>Nombre del maestro pokemon:</span>
		<form:input type="text" path="name" />
		<input type="submit" value="Guardar nombre maestro pokemon" />
	</form:form>
	<br />
	<br /> El nombre del maestro pokemon es
	<span><c:out value="${ash.name}" /></span>
	<br />

	<span>Pokemon principal</span>
	<table border="1">
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Vida</td>
				<td>Ataque</td>
				<td>Defensa</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${ash.equipo.main.name}" /></td>
				<td><c:out value="${ash.equipo.main.vida}" /></td>
				<td><c:out value="${ash.equipo.main.ataque}" /></td>
				<td><c:out value="${ash.equipo.main.defensa}" /></td>
			</tr>
		</tbody>
	</table>
	
	<br /><br/><br/>
	<table border="1">
	<span>Pokemons de</span> <c:out value="${ash.name}"/>
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Vida</td>
				<td>Ataque</td>
				<td>Defensa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="poke" items="${ash.equipo.pokemon}">
				<tr>
					<td><c:out value="${poke.name}" /></td>
					<td><c:out value="${poke.vida}" /></td>
					<td><c:out value="${poke.ataque}" /></td>
					<td><c:out value="${poke.defensa}" /></td>
					<form:form action="changeMain${poke.id}" method="post" modelAttribute="main">
					<td><input type="submit" value="Elegir pokemon principal" /></td>
					</form:form>
					<span>Añadir un boton que permita elegir a ese pokemon como principal, el que peleara contra el rival</span>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br/>
	
	<br/><br/>
	<table border="1">
	
	<br />
	<span>Capacidad del equipo: <c:out value="${ash.equipo.capacidad}" /></span>
	<br />
	
	<form:form action="insert" method="post" modelAttribute="ash">
		<span>Nuevo Pokemon:</span>
		<br/>
		<span>Nombre:</span>
		<form:input type="text" path="pokemon.name" />
		<span>Vida:</span>
		<form:input type="number" path="pokemon.vida" />
		<span>Ataque:</span>
		<form:input type="number" path="pokemon.ataque" />
		<span>Defensa:</span>
		<form:input type="number" path="pokemon.defensa" />
		<input type="submit" value="Capturar pokemon y meterlo al equipo" />
	</form:form>
	<span><c:out value="${ash.equipo.limite}" /></span>
	
	<br />
	
	<span>Pokemon rival</span>
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Vida</td>
				<td>Ataque</td>
				<td>Defensa</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${rival.name}" /></td>
				<td><c:out value="${rival.vida}" /></td>
				<td><c:out value="${rival.ataque}" /></td>
				<td><c:out value="${rival.defensa}" /></td>
				<form:form action="combate" method="post" modelAttribute="combate">
				<td><input type="submit" value="Combate!" /></td>
				</form:form>
			</tr>
		</tbody>
	</table>
	<span>Añadir un log de batalla</span>
	<span><c:out value="${rival.estado} " /></span>
	<br /><br/><br/>
	
	<table border="1">
	<span>Pokemons debilitados de </span> <c:out value="${ash.name}"/>
		<thead>
			<tr>
				<td>Nombre</td>
				<td>Vida</td>
				<td>Ataque</td>
				<td>Defensa</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="poke" items="${ash.equipo.pokemonDeb}">
				<tr>
					<td><c:out value="${poke.name}" /></td>
					<td><c:out value="${poke.vida}" /></td>
					<td><c:out value="${poke.ataque}" /></td>
					<td><c:out value="${poke.defensa}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	


</body>
</html>