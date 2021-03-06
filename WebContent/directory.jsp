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
<title>Page d'accueil</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="annuaire" />
<meta name="keywords" content="html5, css3, form" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css" href="css/background.css" />
<link rel="stylesheet" type="text/css" href="css/form.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
</head>
<body>
	<div align="center">
		<div class=container>
			<header>
				<h1>Annuaire du personnel</h1>
			</header>
		</div>
		<table class="directory"
			style="border-collapse: collapse; border-spacing: 0">
			<tr>
				<th>Numéro d'identification</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Adresse électronique</th>
				<th>Anniversaire</th>
				<th>Site internet</th>
			</tr>
			<tr id='person' onclick="document.location='details.html';">
				<td>GL0312</td>
				<td>Gairoard</td>
				<td>Lionel</td>
				<td>lionel.gairoard@gmail.com</td>
				<td>03/12/1989</td>
				<td><a href=http://www.google.fr>www.google.fr</a></td>
			</tr>
			<tr id='person' onclick="document.location='details.html';">
				<td>GA0312</td>
				<td>Gairoard</td>
				<td>Arnaud</td>
				<td>arnaud.gairoard@gmail.com</td>
				<td>03/12/1989</td>
				<td><a href=http://www.google.fr>www.google.fr</a></td>
			</tr>
		</table>
	</div>
</body>
</html>