$(document).on("click", "#edit", function () {
    var id = $("#id").val();
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