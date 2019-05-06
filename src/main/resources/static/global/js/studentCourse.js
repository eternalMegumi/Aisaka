function arrange(studentId, courseId) {
    if (confirm("确认选课?")) {
        addStudy(studentId, courseId);
    }
}

function deletes(studentId, courseId) {
    if (confirm("退选会导致学习时间归零!!! 确认?")) {
        deleteStudy(studentId, courseId);
    }
}

function addStudy(student, course) {
    $.ajax({
        type: "POST",
        url: "/user/duration/add",
        dataType: "json",
        data: {
            studentId: student,
            courseId: course
        },
        success: function (data) {
            alert(data.message);
            location.reload(true);
        }
    });
}

function deleteStudy(student, course) {
    $.ajax({
        type: "DELETE",
        url: "/user/duration/delete",
        dataType: "json",
        data: {
            studentId: student,
            courseId: course
        },
        success: function (data) {
            alert(data.message);
            location.reload(true);
        }
    });
}

function startStudy(id, courseId) {
    var deadline = $("#deadlineStr_" + id + "").text();
    if (checkTime(deadline)) {
        window.location.href = '/user/course/' + courseId;
    } else {
        alert("已过截止日期！")
    }
}

/**
 * 与当前时间比较，小于为false，大于为true
 * @param deadline
 * @returns {boolean}
 */
function checkTime(deadline) {
    var arrs = deadline.split("-");
    var deadlineTime = new Date(arrs[0], arrs[1], arrs[2]);
    var deadlineTimes = deadlineTime.getTime();


    //当前时间
    var thisDate = new Date();
    var thisDates = thisDate.getFullYear() + "-" + (thisDate.getMonth() + 1) + "-" + thisDate.getDate();
    var arrn = thisDates.split("-");
    var nowTime = new Date(arrn[0], arrn[1], arrn[2]);
    var nowTimes = nowTime.getTime();

    if (deadlineTimes < nowTimes) {
        return false;
    } else {
        return true;
    }
}
