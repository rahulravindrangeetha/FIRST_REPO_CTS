<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Book Info</title>
</head>
<body>
<c:if test="${deleteStatus=='y'.charAt(0)}">
Subject deleted successfully !!!
</c:if>
<c:if test="${deleteStatus=='n'.charAt(0)}">
Subject not found !!!
</c:if>


<form:form method="post" action="/booksandsubjectsmvchibernatedataboot/optionRedirect.html">      
<input type="submit" value="Main Menu" />
</form:form>

</body>
</html>