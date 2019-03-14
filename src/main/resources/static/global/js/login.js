$(document).ready(function () {
    $("#login").click(function () {
        var name = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            type: "POST",
            url: "/login/check",
            dataType: "json",
            data: {
                name: name,
                password: password
            },
            success: function (data) {
                alert(data.name + ":" + data.password)
                $("#username").val(data.name);
                $("#demo").val(data.password);
            }
        });
    });
});