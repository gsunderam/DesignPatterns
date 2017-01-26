<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String ctxPath = request.getContextPath();
   System.out.println("ctxpath is " + ctxPath);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Create Quotes</title>
	<script>
	    function submitForm(f, contentType) {
	        var baseUri = '<%= ctxPath %>/service/quotes/' + document.getElementById('id').value + "/" + document.getElementById('name').value
            if (contentType) f.action = baseUri + "." + contentType
            else f.action = baseUri
            f.submit()
	    }
	</script>
</head>

<body>

<form name="quoteForm" method="POST">
    <fieldset>
        <legend>Enter Quote Data</legend>
        <label for="id">ID : </label><input type="text" name="id" id='id' value="">
        <label for="name">Name: </label><input type="text" id='name' name="name" value="">
        <br><br>
        <input type="button" name="getQuotes" value="JSON Quote" onclick='submitForm(this.form, "json")'>
        <input type="button" name="getXmlQuotes" value="XML Quote" onclick='submitForm(this.form, "xml")'>
        <input type="button" name="getHtmlQuotes" value="HTML Quote" onclick='submitForm(this.form)'>
        <input type="button" name="getRSSQuotes" value="RSS Quote" onclick='submitForm(this.form, "rss")'>
    </fieldset>
</form>

</body>
</html>