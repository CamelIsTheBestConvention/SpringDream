package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MemberDTO {

    //    FILE_NAME VARCHAR2(500),
//    FILE_UPLOAD_PATH VARCHAR2(500),
//    FILE_UUID VARCHAR2(500)
    private long memberNumber;
    private String memberId;
    private String memberPw;
    private String memberEmail;
    private String memberName;
    private String memberNickname;
    private String memberMobile;
    private String memberRank;
    private int memberStatus;
    private int memberBoardCount;
    private int memberReplyCount;

    private String fileName;
    private String fileUploadPath;
    private String fileUUID;

    // 파일 업로드 O
    public void create(Long memberNumber, String memberId, String memberPw, String memberEmail, String memberName, String memberNickname, String memberMobile, String memberRank, int memberStatus, int memberBoardCount, int memberReplyCount , String fileName, String fileUploadPath, String fileUUID) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberMobile = memberMobile;
        this.memberRank = memberRank;
        this.memberStatus = memberStatus;
        this.memberBoardCount = memberBoardCount;
        this.memberReplyCount = memberReplyCount;
        this.fileName = fileName;
        this.fileUploadPath = fileUploadPath;
        this.fileUUID = fileUUID;
    }

    // 파일 업로드 X
    public void create(String memberId, String memberPw, String memberEmail, String memberName, String memberNickname, String memberMobile, String memberRank, int memberStatus, int memberBoardCount, int memberReplyCount) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberEmail = memberEmail;
        this.memberName = memberName;
        this.memberNickname = memberNickname;
        this.memberMobile = memberMobile;
        this.memberRank = memberRank;
        this.memberStatus = memberStatus;
        this.memberBoardCount = memberBoardCount;
        this.memberReplyCount = memberReplyCount;
    }

}
