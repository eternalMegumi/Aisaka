$(document).on("click", "#submit", function () {
    if (confirm("确认提交?")) {
        submitPaper();
    }
});

function submitPaper() {
    var paperId = $("#paperId").val();
    var answer = $("#answer").val();
    $.ajax({
        type: "POST",
        url: "/user/paper/submit",
        dataType: "json",
        async: false,
        data: {
            paperId: paperId,
            answer: answer
        },
        success: function (data) {
            var score = data.data;
            alert("你的得分是：" + score + ", 答题详情请见成绩栏");
        }
    });
    window.location.href = '/user/course/mine';
}