<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
<legend>
Registrer deg
<font color="red">${feilmelding}</font>
<form action="registrer" method="post">
Mobil (8 siffer): <input type="text" name="mobil" value="${sjemadata.mobil}"></input>
Fornavn:  <input type="text" name="fornavn" value="${sjemadata.navn}"></input>
Etternavn <input type="text" name="etternavn" value="${sjemadata.etternavn}"></input>
Passord  <input type="password" name="pass" value="${sjemadata.pass}"></input>
Gjenta pass  <input type="password" name="pass2"></input>
<input type="submit" value="Registrer deg"><input>
</form>
</legend>
</fieldset>

<!-- <legend> -->
<!-- Opprette ny bruker: -->
<!-- <form action="servlet" method="post" id="form1"> -->
<!-- <p>Nick</p> -->
<!-- <input type="text" name="nick"> -->

<!-- </input> -->
<%-- ${feilmelding} --%>
<!-- Klasse: -->
<!-- <select form="form1" name="select"> -->
<%-- <c:forEach items="${liste}" var="var"> --%>
<%-- <option value="${var}"></option> --%>
<%-- </c:forEach> --%>
<!-- <select> -->

<!-- <input type="submit" value="Registrer meg"> -->

<!-- </input> -->
<!-- </form> -->
<!-- </legend> -->

</body>
</html>