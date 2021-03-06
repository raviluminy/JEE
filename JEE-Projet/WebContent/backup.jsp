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
<title>Enregistrement</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Page d'accueil" />
<meta name="keywords" content="html5, css3" />
<meta name="author" content="jee" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="html/css/background.css" />
<link rel="stylesheet" type="text/css" href="html/css/form.css" />
<link rel="stylesheet" type="text/css"
	href="html/css/animate-custom.css" />
</head>
<body>
	<div class="container">
		<!-- Top bar -->
		<header>
			<h1>Verification des donnees en cours...</h1>
		</header>
		<section>
			<div id="container_page">
				<div id="wrapper">
					<form>
						<p class="${message_type}">${message}</p>
						<p class="change_link">
							Retour au formulaire ? <a href="edition.html?id=${person.id}">Acc&eacute;der
								au formulaire</a>
						</p>
					</form>
				</div>
			</div>
		</section>
	</div>
</body>
</html>