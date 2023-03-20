package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class NoticeVO {
    private Long noticeNumber;
    private String noticeDate;
    private String noticeTitle;
    private String noticeContent;



//    NOTICE_NUMBER NUMBER CONSTRAINT PK_NOTICE_NUMBER PRIMARY KEY,
//    NOTICE_DATE DATE DEFAULT SYSDATE,
//    NOTICE_TITLE VARCHAR2(500),
//    NOTIE_CONTENT VARCHAR2(500)
}
