$(document).ready(function () {
    $("#create").click(function () {
        var name = $("#name").val();
        var min = $("#min").val();
        var deadline = $("#deadline").val();
        $.ajax({
            type: "POST",
            url: "/course/new",
            dataType: "json",
            data: {
                name: name,
                min: min,
                deadline: deadline
            },
            success: function (data) {
                alert(data.message);
            }
        });
    });
});