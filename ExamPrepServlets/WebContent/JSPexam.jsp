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
<legend>
Opprette ny bruker:
<form action="servlet" method="post" id="form1">
<p>Nick</p>
<input type="text" name="nick">

</input>
${feilmelding}
Klasse:
<select form="form1" name="select">
<c:forEach items="${liste}" var="var">
<option value="${var}"></option>
</c:forEach>
<select>

<input type="submit" value="Registrer meg">

</input>
</form>
</legend>

</body>
</html>