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
	
	<span><c:out value="${ash.limite}" /></span>
	<form:form action="insert" method="post" modelAttribute="ash">
		<span>Nuevo Pokemon:</span>
		<br/>
		<span>Nombre:</span>
		<form:input type="text" path="pokemonAux.name" />
		<span>Vida:</span>
		<form:input type="number" path="pokemonAux.vida" />
		<span>Ataque:</span>
		<form:input type="number" path="pokemonAux.ataque" />
		<span>Defensa:</span>
		<form:input type="number" path="pokemonAux.defensa" />
		<input type="submit" value="Añadir pokemon al equipo" />
	</form:form>
	
	<br />
	<span><c:out value="${ash.limite}" /></span>
	<br />
	<span>Te quedan: <c:out value="${ash.maxPokeball}" /></span>
	<span><c:out value="${ash.pokeball.name}" /></span>
	
	<form:form action="capturar" method="post" modelAttribute="ash">
		<span>Intenta capturar al Pokemon:</span>
		<br/>
		<span>Nombre:</span>
		<form:input type="text" path="pokemonCapt.name" />
		<span>Vida:</span>
		<c:out value="${ash.pokemonCapt.vida}" />
		<span>Ataque:</span>
		<c:out value="${ash.pokemonCapt.ataque}" />
		<span>Defensa:</span>
		<c:out value="${ash.pokemonCapt.defensa}" />
		<input type="submit" value="Intentar capturar!" />
	</form:form>
	
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
			<c:forEach var="poke" items="${ash.pokemon}">
				
				<tr>
					<td><c:out value="${poke.name}" /></td>
					<td><c:out value="${poke.vida}" /></td>
					<td><c:out value="${poke.ataque}" /></td>
					<td><c:out value="${poke.defensa}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br/><br/><br/>
	<table border="1">
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
				<td><c:out value="${ash.rival.name}" /></td>
				<td><c:out value="${ash.rival.vida}" /></td>
				<td><c:out value="${ash.rival.ataque}" /></td>
				<td><c:out value="${ash.rival.defensa}" /></td>
				<form:form action="combate" method="post" modelAttribute="combate">
				<td><input type="submit" value="Combate!" /></td>
				</form:form>
			</tr>
		</tbody>
	</table>
	<span><c:out value="${ash.rival.estado} " /></span>
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
			<c:forEach var="poke" items="${ash.pokemonDeb}">
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