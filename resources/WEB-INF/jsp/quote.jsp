<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Quotes</title>
</head>

<body>
    <table border=1>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>
        <tr>
                <td>${model.id}</td>
                <td>${model.name}</td>
         </tr>
    </table>
</body>
</html>