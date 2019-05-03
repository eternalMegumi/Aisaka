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