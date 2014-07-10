<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>website</title>
</head>
<body>
<h1>Home</h1>
<h2></h2>
<h2>2<c:out value='${syndFeed.title}' /> </h2>
<ul>
    <c:forEach var="entry" items="${syndFeed.entries}" varStatus="status">
        <li><a href="<c:out value='/entry?action=${status.index}' />"><c:out value="${entry.title}" /></a></li>
    </c:forEach>
</ul>
</body>
</html>