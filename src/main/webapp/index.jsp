<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">
    <meta charset="UTF-8">
    <style>
        .center-text {
            text-align: center;
            font-size: 24px;
            color: var(--color1);
            font-family: Arial sans-serif;
        }
    </style>
    <title>Путешествие принца Персии!</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script.js"></script>
</head>
<body>

<header style="padding: 80px;">
    <div class="container">
        <div class="row">
            <div class="col-12"></div>
            <div class="center-text">
                <h1 style="color: var(--color1); margin-top: 50px; padding-left: 120px; font-size: xxx-large">Путешествие принца Персии: Легенда о затерянной цитадели</h1>
            </div>
        </div>
    </div>
</header>

<section>
    <div class="about">
    <div id="content">
        <img src="image/start_page.png" alt="Image Left" class="icon-left">
        <img src="image/start_page2.png" alt="Image Right" class="icon-right">
        <div class="center-text">
            <div class="row">
                <p><a href="#" class="description-link" style="margin-top: 20px;">
                    <span class="quests-icon icon-down-open"></span>Предыстория</a></p>
            </div>
            <div class="row">
                <p><a href="#" class="section-link" style="margin-top: 10px;"><span class="quests-icon icon-paper-plane"></span>Запуск квеста</a></p>
            </div>
            <div class="row">
                <p><a href="#" class="statistic-link" style="margin-top: 10px;"><span class="quests-icon icon-chart-bar"></span>Статистика</a></p>
            </div>
        </div>
    </div>
    </div>
</section>

<footer
        id="footer" style="padding: 50px">
</footer>

</script>
</body>
</html>
