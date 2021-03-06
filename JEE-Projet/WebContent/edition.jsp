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
<title>Formulaire d'enregistrement</title>
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
			<h1>Formulaire d'enregistrement</h1>
		</header>
		<section>
			<div id="container_page">
				<a class="hiddenanchor" id="tologin"></a> <a class="hiddenanchor"
					id="toregister"></a>
				<div id="wrapper">
					<div id="register" class="animate form">
						<form action="backup.html" autocomplete="on">
							<h1>Inscription</h1>
							<p>
								<input type="hidden" name="id" value="${person.id}">
							<p>
								<label for="userfirstnamesignup" class="ufirstname"
									data-icon="u">Pr&eacute;nom</label> <input
									id="userfirstnamesignup" name="userfirstnamesignup"
									required="required" type="text" placeholder="Pierre" value="${person.firstName}" />
							</p>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">Nom
									de famille</label> <input id="usernamesignup" name="usernamesignup"
									required="required" type="text" placeholder="Dupont" value="${person.name}" />
							</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e">
									Adresse &eacute;lectronique</label> <input id="emailsignup"
									name="emailsignup" required="required" type="email"  value="${person.mail}"
									placeholder="monadresse@mail.com" />
							</p>
							<p>
								<label for="birthdatesignup" class="youbirthdate" data-icon="b">
									Date de naissance</label> <input id="birthdatesignup"
									name="birthdatesignup" type="date" placeholder="31/12/2014"  value="${person.birthdate}"/>
							</p>
							<p>
								<label for="websitesignup" class="youwebsite" data-icon="w">
									Site internet</label> <input id="websitesignup" name="websitesignup"  value="${person.website}"
									type="url" placeholder="www.monsiteweb.com" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">Entrez
									votre mot de passe </label> <input id="passwordsignup"
									name="passwordsignup" required="required" type="password"  value="${person.password}"
									placeholder="exemple :  abcd1234" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd"
									data-icon="p">Veuillez confirmer votre mot de passe </label> <input
									id="passwordsignup_confirm" name="passwordsignup_confirm"
									required="required" type="password"
									placeholder="exemple :  abcd1234" />
							</p>
							<p class="signin button">
								<input type="submit" value="Enregistrer" />
							</p>
							<p class="change_link">
								Retour &agrave; la page d'accueil ? <a href="index.html">Acc&eacute;der
									&agrave; la page de connexion</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>