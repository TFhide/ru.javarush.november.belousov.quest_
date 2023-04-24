
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/style.css">
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="script.js"></script>
</head>
<body>

<div class="about" style="padding: 60px">
<div id="question-container">
<div class="row">
    <div class="center-text" id="question" style="margin-top: -50px; font-size: 30px">
    </div>
</div>
    <div class="row">
        <div id="questionImage" style="text-align: center;"><img src="" alt="" width="400" height="300"></div>
    </div>
        <div class="row">
            <div class="center-text" id="answer1" style="margin-top: 20px">
                <p><a href="#" class="answer-link" data-answer="1"></a></p>
            </div>
        </div>
        <div class="row">
            <div class="center-text" id="answer2" style="margin-top: 10px">
                <p><a href="#" class="answer-link" data-answer="2"></a></p>
            </div>
        </div>
</div>
    </div>
</body>
</html>