$(document).on("click", "#submit", function () {
    var paperId = $("#paperId").val();
    var answer = $("#answer").val();
    $.ajax({
        type: "POST",
        url: "/user/paper/submit",
        dataType: "json",
        data: {
            paperId: paperId,
            answer:answer
        },
        success: function (data) {
            alert(data.message);
        }
    });
});