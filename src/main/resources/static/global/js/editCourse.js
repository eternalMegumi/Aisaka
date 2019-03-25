$(document).on("click", "#edit", function () {
    var id = $("#courseId").val();
    var name = $("#name").val();
    var min = $("#min").val();
    var deadlineStr = $("#deadlineStr").val();
    $.ajax({
        type: "PATCH",
        url: "/course/edit",
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
        url: "/material/upload",
        data: form,
        cache: false,
        async: false,
        type: "POST",
        dataType: "json",
        processData: false,
        contentType: false,
        success: function (data) {
            alert(data.url);
        }
    })
});