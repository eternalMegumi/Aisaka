$(document).on("click", "#edit", function () {
    var id = $("#courseId").val();
    var name = $("#name").val();
    var min = $("#min").val();
    var deadlineStr = $("#deadlineStr").val();
    $.ajax({
        type: "PATCH",
        url: "/admin/course/edit",
        dataType: "json",
        data: {
            id: id,
            name: name,
            min: min,
            deadlineStr: deadlineStr
        },
        success: function (data) {
            alert(data.message);
        }
    });
});

$(document).on("click", "#uploadMaterial", function () {
    var form = new FormData();
    form.append("material", document.getElementById("material").files[0]);
    form.append("courseId", $("#courseId").val());
    $.ajax({
        url: "/admin/material/upload",
        data: form,
        cache: false,
        async: false,
        type: "POST",
        dataType: "json",
        processData: false,
        contentType: false,
        success: function (data) {
            var materialList = data.data;
            var trStr = "";
            for (var i = 0; i < materialList.length; i++) {
                trStr += "<tr><td>" + materialList[i].name + "</td></tr>";
            }
            $("#materialTableBody").html(trStr);
        }
    })
});

$(document).on("click", "#uploadPaper", function () {
    var form = new FormData();
    form.append("file", document.getElementById("paper").files[0]);
    form.append("id", $("#paperId").val());
    form.append("courseId", $("#courseId").val());
    $.ajax({
        url: "/admin/paper/upload",
        data: form,
        cache: false,
        async: false,
        type: "POST",
        dataType: "json",
        processData: false,
        contentType: false,
        success: function (data) {
            var paper = data.data;
            $("#paperName").html(paper.name);
            $("#paperId").val(paper.id);
        }
    })
});

$(document).on("click", "#editPaper", function () {
    var id = $("#paperId").val();
    var answer = $("#answer").val();
    var value = $("#value").val();
    var time = $("#time").val();
    $.ajax({
        type: "PATCH",
        url: "/admin/paper/edit",
        dataType: "json",
        data: {
            id: id,
            answer: answer,
            value: value,
            time: time
        },
        success: function (data) {
            alert(data.message);
        }
    });
});