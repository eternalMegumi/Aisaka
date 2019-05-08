function saveDuration() {
    /*结束时保存设备状态*/
    window.onbeforeunload = function () {//必须使用beforeunload
        var studentId = $("#studentId").val();
        var courseId = $("#courseId").val();
        $.ajax({
            type: "PATCH",
            url: "/user/duration",
            async: false,                //必须采用同步方法
            data: {
                studentId: studentId,
                courseId: courseId
            }
        });
    }
}

saveDuration();