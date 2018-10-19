<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="/booksandsubjectsmvchibernatedataboot/addBook.html" modelAttribute="bookObject">      
        <table >  
         <tr>    
         	<td><form:label path = "bookId">Book Id</form:label></td>
         	<td><form:input path = "bookId"></form:input></td>
         </tr>
         <tr>    
         	<td><form:label path = "title">Title</form:label></td>
         	<td><form:input path = "title"></form:input></td>
         </tr>
         <tr>    
         	<td><form:label path = "price">Price</form:label></td>
         	<td><form:input path = "price"></form:input></td>
         </tr>
         <tr>    
         	<td><form:label path = "volume">Volume</form:label></td>
         	<td><form:input path = "volume"></form:input></td>
         </tr>
         <tr>    
         	<td><form:label path = "publishDate">Publish Date</form:label></td>
         	<td><form:input path = "publishDate"></form:input></td>
         </tr>
         <tr>
         	<td><input type="submit" value="submit" /></td>  
         </tr>
    
        </table>    
</form:form>


<form:form method="post" action="/booksandsubjectsmvchibernatedataboot/optionRedirect.html">      
<input type="submit" value="Main Menu" />
</form:form>

</body>
</html>