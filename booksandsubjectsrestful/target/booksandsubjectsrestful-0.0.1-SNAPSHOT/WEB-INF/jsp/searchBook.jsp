<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search book</title>
</head>
<body>
<form:form method="post" action="/booksandsubjectsmvchibernate/searchBook.html">      
        <table >  
        <tr>
        <td>Enter the book id</td>
        <td><input type="text" name="bookId" /></td>
        </tr>
         <tr>
         	<td><input type="submit" value="submit" /></td>  
         </tr>
    
        </table>    
</form:form>

<form:form method="post" action="/booksandsubjectsmvchibernate/optionRedirect.html">      
<input type="submit" value="Main Menu" />
</form:form>
</body>
</html>