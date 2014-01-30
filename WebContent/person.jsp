<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="produit" scope="session"
		class="fr.jee.projet.db.Person">
		<p>Liste des personnes !</p>
	</jsp:useBean>
	<jsp:setProperty name="person" property="id" value="GL0312" />
	<jsp:setProperty name="person" property="name" value="Gairoard" />
	<jsp:setProperty name="person" property="firstName" value="Lionel" />
	<jsp:setProperty name="person" property="mail"
		value="lionel.gairoard@gmail.com" />
	<jsp:setProperty name="person" property="website" value="" />
	<jsp:setProperty name="person" property="birthdate" value="03/12/1989" />
	<jsp:setProperty name="person" property="password" value="master22" />
	<p>
		Nom :
		<jsp:getProperty name="person" property="name" />
	</p>
	<p>
		Prénom :
		<jsp:getProperty name="person" property="firstName" />
	</p>
	<p>
		Anniversaire :
		<jsp:getProperty name="person" property="birthdate" />
	</p>
</body>
</html>