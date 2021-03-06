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
<title>Page d'accueil</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Page d'accueil" />
<meta name="keywords" content="html5, css3, form" />
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
			<h1>Bienvenue sur la page d'accueil de l'annuaire</h1>
		</header>
		<section>
			<div id="container_page">
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form action="directory.html" autocomplete="on" method="post">
							<p>
								<label for="username" class="uname" data-icon="u">
									Adresse électronique </label> <input id="username" name="username"
									required="required" type="text"
									placeholder="exemple : monadresse@mail.com" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p">
									Mot de passe </label> <input id="password" name="password"
									required="required" type="password"
									placeholder="exemple : abcd1234" />
							</p>
							<p class="login button">
								<input type="submit" value="Connexion" />
							</p>
							<p class="change_link">
								Ajout d'un membre ? <a href="edition.html" class="to_register">Formulaire
									d'enregistrement</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>