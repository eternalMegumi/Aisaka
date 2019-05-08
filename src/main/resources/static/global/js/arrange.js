function arrange(studentId, courseId) {
    if (confirm("确认安排?")) {
        addStudy(studentId, courseId);
    }
}

function deletes(studentId, courseId) {
    if (confirm("删除会导致学习时间归零!!! 确认?")) {
        deleteStudy(studentId, courseId);
    }
}

function addStudy(student, course) {
    $.ajax({
        type: "POST",
        url: "/admin/duration",
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
        url: "/admin/duration",
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