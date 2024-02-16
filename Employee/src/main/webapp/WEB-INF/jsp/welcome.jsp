<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="https://www.thymeLeaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>

</head>
<body>

<h2 th:text="${name}">Name</h2>
<h2 th:text="${username}">userName</h2>
</body>
</html>