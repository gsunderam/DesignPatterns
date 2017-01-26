<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Student Information</title>
</head>

<body>
    <table border=1>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>company</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.company}</td>
                <td>${student.salary}</td>
         </tr>
    </table>
</body>
</html>