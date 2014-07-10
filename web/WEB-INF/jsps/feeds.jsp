<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>MaRSS</title>

    <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
        body {
            color: #333;
            font-size: 70%;
        }

        .list-fix {
            border-bottom: 1px #eee solid;
            padding-left: 0 !important;
            margin-left: 0;
        }

        .darker-back {
            color: #000 !important;
        }

        #loading {
            background-color: #000;
            width:50px;
            height: 50px;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).ready(function() {
            get('feeds', function(responseText) {
                $('syndEntries').text(responseText);
            });
        });
    </script>

</head>
<body>
<div class="pure-g">
    <div class="pure-u-1-3">&nbsp;</div>
    <div class="pure-u-1-3">
        <p><h1>MaRSS</h1>
        <h2>A very minimal reader.</h2>
        <div class="pure-menu pure-menu-open">
        <ul>
            <c:forEach var="entry" items="${syndEntries}" varStatus="status">
                <li class="list-fix <c:choose><c:when test="${status.index % 2 == 0}">darker-back</c:when></c:choose>"><a href="<c:out value='/entry?action=${status.index}' />"><c:out value="${entry.title}" /></a></li>
            </c:forEach>
        </ul>
        </div>
    </div>
    <div class="pure-u-1-3">&nbsp;</div>
</div>

</body>
</html>