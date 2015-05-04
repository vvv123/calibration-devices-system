<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Provider page</title>
    <link rel="stylesheet" href="resources/assets/styles/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/styles/main.css">
</head>
<body id="providerModule">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/client">Головна</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="#/account">Акаунт</a></li>
                <li><a href="#/devices">Мої лічильники</a></li>
                <li><a href="#/add-application">Подати заявку на перевірку</a></li>
            </ul>
        </div>
    </div>
</nav>

<div data-ng-view></div>

<script type="text/javascript" data-main="resources/app/client/run-app"
        src="resources/assets/javascripts/require.js"></script>

</body>
</html>
