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
<html lang="fr">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Fiche détaillée</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Formulaire d'inscription" />
<meta name="keywords" content="html5, css3, form, animation" />
<meta name="author" content="jee" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="html/css/background.css" />
<link rel="stylesheet" type="text/css" href="html/css/form.css" />
<link rel="stylesheet" type="text/css"
	href="html/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<header>
			<h1>Details</h1>
		</header>
		<section>
			<div id="container_page">
				<a class="hiddenanchor" id="tologin"></a> <a class="hiddenanchor"
					id="toregister"></a>
				<div id="wrapper">
					<div id="register" class="animate form">
						<form action="edition.html" autocomplete="on"
							contenteditable="false" method="post">
							<h1>${person.firstName} ${person.name}</h1>
							<input type="hidden" name="id" value="${person.id}" />
							<ul>
								<li>ID : ${person.id}</li>
								<li>Site web : <a href="http://${person.website}">${person.website}</a></li>
								<li>Adresse mail : <a href="mailto:${person.mail}">${person.mail}</a></li>
								<li>Date de naissance : ${person.birthdate}</li>
								<li>Mot de passe : ${person.password}</li>
							</ul>
							<p class="signin button">
								<input type="submit" value="Modifier" />
							</p>
							<p class="change_link">
								Retour &agrave; l'annuaire ? <a href="annuaire.html">Acc&eacute;der
									&agrave; l'annuaire</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>