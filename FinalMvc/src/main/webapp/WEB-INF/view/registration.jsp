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
<c:url var="url" value="/registration" />
<form:form action="${url}" method="post" modelAttribute="daoMvc">

    <h1>Registrati</h1>
    <p></p>
    <hr>

    <label for="email"><b>Email</b></label>
    <form:input type="text" placeholder="Enter Email" path="email" />

    <label for="psw"><b>Password</b></label>
    <form:input type="password" placeholder="Enter Password" path="password" />

    <label for="telefono"><b>Telefono</b></label>
    <form:input type="text" placeholder="123456" path="num_telefono" />

    <label for="nome"><b>Nome</b></label>
    <form:input type="text" placeholder="Nome" path="nome" />

    <label for="emcognomeail"><b>Cognome</b></label>
    <form:input type="text" placeholder="Cognome" path="cognome" />
    
    <hr>
    <button type="submit" class="registerbtn">Register</button>
</form:form>
</body>
</html>