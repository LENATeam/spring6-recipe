<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Member List</title>
    <meta charset="UTF-8"/>
</head>
<body>
<h2>Guest Members</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    <c:forEach var="m" items="${guests}">
        <tr>
            <td>${m.name}</td>
            <td>${m.phone}</td>
            <td>${m.email}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
