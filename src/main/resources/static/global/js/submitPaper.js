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


var testTime;//总秒钟

window.onload = function () {

    var paperId = $("#paperId").val();

    $.ajax({
        type: "POST",
        url: "/user/paper/restTime",
        dataType: "json",
        async: false,
        data: {
            paperId: paperId
        },
        success: function (data) {
            testTime = data.data * 60;
        }
    });
    daojishi();
};


function daojishi() {
    if (testTime >= 0) {
        var ms = testTime % 60;//余数 89%60==29秒
        var mis = Math.floor(testTime / 60);//分钟
        var timeStr;
        if (mis >= 60) {
            var hour = Math.floor(mis / 60);
            mis = Math.floor((testTime - hour * 60 * 60) / 60);
            timeStr = hour + "小时" + mis + "分" + ms + "秒";
        } else if (mis >= 1) {
            timeStr = mis + "分" + ms + "秒";
        } else {
            timeStr = ms + "秒";
        }
        $("#mss").text(timeStr);
        testTime--;
        vartt = window.setTimeout("daojishi()", 1000);
    } else {
        window.clearTimeout(vartt);
        window.confirm("考试时间结束");
        submitPaper()
    }
}

function saveAnswerTime() {
    /*结束时保存设备状态*/
    window.onbeforeunload = function () {//必须使用beforeunload
        var paperId = $("#paperId").val();
        var answer = $("#answer").val();
        $.ajax({
            type: "PATCH",
            url: "/user/report/answerTime",
            async: false,                //必须采用同步方法
            data: {
                paperId: paperId,
                answer: answer
            }
        });
    }
}

saveAnswerTime();
