<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
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
</head>
<body>
<div class="pure-g">
    <div class="pure-u-1-3">&nbsp;</div>
    <div class="pure-u-1-3">
        <p><h1><c:out value="${entry.title}"/></h1>
        <h2><c:out value="${entry.publishedDate}" /> </h2>
        <c:out value="${entry.contents}" escapeXml="false" />
    </div>
    <div class="pure-u-1-3">&nbsp;</div>
</div>

</body>
</html>