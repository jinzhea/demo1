function checkName(username) {
    $.ajax({
        type: "post",
        url: "/checkname",
        async: true,
        dataType: "html",
        data: {"username": username},
        success: function (data, textStatus) {
            $("#tip").text(data);
        },
        error: function () {
        }
    })
}

function jump(size) {

    if (size == "") {
        return false;
    } else if (size < 5) {
        alert("最小输入5条数据");
        return false;
    } else {

        $.ajax({
            type: "get",
            url: "/findallByPage",
            async: true,
            datatype: "html",
            data: {"size": size, page: 1},
            success: function (data) {
                var s = $(data).find("div .userlist").html()
                $("div .userlist").html(s);
            }

        })
    }
}

function del() {
    //获取被选中checkbox值
    var checks = $("input[name='ids']:checked");
    if (checks.length == 0) {
        alert('未选中任何项！');
        return false;
    }

    var checkData = new Array();
    checks.each(function () {
        checkData.push($(this).val());
    });


    $.ajax({
        type: "post",
        url: "/del",
        async: true,
        datatype: "html",
        data: {"ids": checkData.toString()},
        success: function (data) {
            var s = $(data).find("div .userlist").html()
            $("div .userlist").html(s);
        },
        error: function () {
            alert("操作失败")
        }

    })
}

$(function () {
    var user = $("#session").text();
    if (user == "") {
        window.location.href = "/"
    }
})