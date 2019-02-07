<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="url" value="/modify" />
<form:form action="${url}" method="post" modelAttribute="daoMvc">
<label>Nome: ${nome}</label>
<form:input path="nome" value="${nome}"/>

<label>Cognome:</label>
<form:input path="cognome" value="${cognome}" />
<label>Telefono:</label>
<form:input path="num_telefono" value="${numero}" />
<label>Email:</label>
<form:input path="email" value="${email}"/>
<label>Password:</label>
<form:input path="password" value="${password}" />
<input type="submit" />
</form:form>
<c:url var="url" value="/index" />
<form:form action="${url}"  modelAttribute="daoMvc">
<input type="submit" placeholder="Elimina Utente"/>
</form:form>
</body>
</html>