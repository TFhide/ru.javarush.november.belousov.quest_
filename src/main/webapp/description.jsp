
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<html>
<head>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">

    <style>
        .center-text {
            text-align: center;
            font-size: 24px;
            color: #664d03;
            font-family: Arial sans-serif;
        }
    </style>
</head>
<body>

<section class="text-center">
    <div class="about">
        <div class="container">
    <div id="descriptionQuest">
        <div class="row">
                <div id="descriptionImage" style="text-align: center;"><img src="" alt="" width="400" height="300"></div>
        </div>
            <div class="row">
                <div class="center-text" id="description">
                </div>
            </div>
    </div>
    <div class="row">
        <a href="/" class="start-link">Главная страница</a>
    </div>
        </div>
        </div>
</section>

<footer
        id="footer" style="padding: 30px">
</footer>
<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>
