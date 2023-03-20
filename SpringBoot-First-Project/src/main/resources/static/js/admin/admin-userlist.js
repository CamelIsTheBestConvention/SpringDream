function removeMember(memberNumber) {
    if(window.confirm("사용자를 삭제합니까?")){
        $.ajax({
            url: "/admin/userlist.remove",
            type: "POST",
            data: { memberNumber : memberNumber},
            success : function (data) {
                alert("삭제 완료.");
            }
        });
        location.reload();
    } else return;
}

function quitMember(memberNumber) {
    if(window.confirm("사용자를 탈퇴시킵니까?")){
        $.ajax({
            url: "/admin/userlist.quit",
            type: "POST",
            data: { memberNumber : memberNumber},
            success : function (data) {
                alert("탈퇴처리 완료.");
            }
        });
        location.reload();
    } else return;
}

