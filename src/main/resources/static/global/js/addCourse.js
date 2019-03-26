$(document).on("click", "#create", function () {
    var name = $("#name").val();
    var min = $("#min").val();
    var deadlineStr = $("#deadlineStr").val();
    $.ajax({
        type: "POST",
        url: "/admin/course/new",
        dataType: "json",
        data: {
            name: name,
            min: min,
            deadlineStr: deadlineStr
        },
        success: function (data) {
            alert(data.message);
        }
    });
});