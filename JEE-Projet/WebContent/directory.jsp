<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="fr" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="fr" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="fr" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="fr" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="fr" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Annuaire</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="annuaire" />
<meta name="keywords" content="html5, css3, form" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="html/css/background.css" />
<link rel="stylesheet" type="text/css" href="html/css/form.css" />
<link rel="stylesheet" type="text/css" href="html/css/table.css" />
<link rel="stylesheet" type="text/css"
	href="html/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<!-- Top bar -->
		<header>
			<h1>Annuaire du personnel</h1>
		</header>
		<section>
			<div id=container_page>
				<div align="center">
					<table class="directory"
						style="border-collapse: collapse; border-spacing: 0">
						<tr>
							<th>Num&eacute;ro d'identification</th>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Adresse &eacute;lectronique</th>
							<th>Anniversaire</th>
							<th>Site internet</th>
						</tr>
						<c:forEach var="person" items="${persons}">
							<tr onclick="document.location='details.html';">
								<td>${person.id}</td>
								<td>${person.name}</td>
								<td>${person.firstName}</td>
								<td>${person.mail}</td>
								<td>${person.birthdate}</td>
								<td><a href="http://${person.website}">${person.website}</a></td>
							</tr>
						</c:forEach>
					</table>
					<div id="wrapper">
						<p class="change_link">
							Retour &agrave; la page d'accueil ? <a href="index.html">Acc&eacute;der
								&agrave; la page de connexion</a>
						</p>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>