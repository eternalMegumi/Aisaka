$(document).ready(function () {
    $("#register").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "POST",
            url: "/student",
            dataType: "json",
            data: {
                username: username,
                password: password
            },
            success: function (data) {
                alert(data.message);
            }
        });
    });
});