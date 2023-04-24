
$(document).ready(function() {

    $(".section-link").click(function(e) {
        e.preventDefault();
        loadData();
    });
    function loadData() {
        $.ajax({
            type: "GET",
            url: `/dispatcher/view`,
            dataType: "json",
            success: function(response) {
                $('#content').load('question.jsp', function () {
                    $('#question').html(response.question);
                    $("#answer1 .answer-link").text(response.answer1);
                    $("#answer2 .answer-link").text(response.answer2);
                    $('#questionImage img').attr('src', response.image.replace(/\\/g, ''));
                });
            }
        });
    }

    $("#question-container").on("click", ".answer-link", function(e) {
    e.preventDefault();
    let data = {
        "question" : $("#question").text(),
    "answer" : $(this).data("answer")
    };
    $.ajax({
    type: "POST",
    url: '/dispatcher/handler',
    data: data,
    dataType: "json",
    success: function(response) {
        if(response.outcome) {
            $('#content').load('outcome.jsp', function () {
                $('#outcome').html(response.outcome)
            })
        }
        else {
            $('#content').load('question.jsp', function () {
                $('#question').html(response.question);
                $("#answer1 .answer-link").text(response.answer1);
                $("#answer2 .answer-link").text(response.answer2);
                $('#questionImage img').attr('src', response.image.replace(/\\/g, ''));
            });
        }
}
});
});

    $(".description-link").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: `/dispatcher/description`,
            dataType: "json",
            success: function (response) {
                $('#content').load('description.jsp', function () {
                    $('#description').html(response.description);
                    $('#descriptionImage img').attr('src', response.image.replace(/\\/g, ''));
                });
            }
        });
    });

    $(".statistic-link").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: `/dispatcher/statistic`,
            dataType: "json",
            success: function (response) {
                if (response.message) {
                    $('content').load('statistic.jsp', function () {
                        $('#statisticNull').text(response.message);
                    })
                }
                $('#content').load('statistic.jsp', function () {
                    $('#headStatistic').text(response.ipAddress);
                    $('#quantity').text(response.quantity);
                    $('#win').text(response.win);
                    $('#lose').text(response.lose);
                });
            }
        });
    });
});
