/**
 * 提交回复
 */
function post() {
    var bid = $("#bid").val();
    var ccontent = $("#comment_content").val();
    alert(ccontent);
    comment2target(bid,ccontent);
}

function comment2target(bid,ccontent) {
    if (!ccontent) {
        alert("不能回复空内容~~~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "bid": bid,
            "ccontent": ccontent
        }),
        success: function (response) {
            alert("回复成功");
        },
        dataType: "json"
    });
}