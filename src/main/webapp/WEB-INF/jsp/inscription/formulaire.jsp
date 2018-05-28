<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription d'un usager</title>
</head>
<body>

	<form method="POST" accept-charset="utf-8">
		<div>
			<label for="nom">Nom :</label>
			<input id="nom" name="nom" type="text" value="<c:out value="${param['nom']}"/>">
			<span><c:out value="${erreurs['nom']}"/></span>
		</div>
		<div>
			<label for="prenom">Prénom :</label>
			<input id="prenom" name="prenom" type="text" value="<c:out value="${param['prenom']}"/>">
			<span><c:out value="${erreurs['prenom']}"/></span>
		</div>
		<div>
			<label for="dateNaissance">Date de Naissance :</label>
			<input id="dateNaissance" name="dateNaissance" type="date" value="<c:out value="${param['dateNaissance']}"/>">
			<span><c:out value="${erreurs['dateNaissance']}"/></span>
		</div>
		<button type="submit">inscrire</button>
	</form>

</body>
</html>