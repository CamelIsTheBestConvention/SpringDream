function removeBoard(boardNumber) {
    if(window.confirm("게시글을 삭제합니까?")){
        $.ajax({
            url: "/admin/boards.remove",
            type: "POST",
            data: { boardNumber : boardNumber},
            success : function (data) {
                alert("삭제 완료.");
            }
        });
        location.reload();
    } else return;
}
