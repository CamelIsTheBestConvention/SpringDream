package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long replyNumber;
    private String replyTitle;
    private String replyContent;
    private String replyDate;
    private String replyUpdateDate;
    private Long memberNumber;
    private Long boardNumber;

    public void create( String replyTitle, String replyContent, Long boardNumber, Long memberNumber) {
        this.replyTitle = replyTitle;
        this.replyContent = replyContent;
        this.boardNumber = boardNumber;
        this.memberNumber = memberNumber;

    }
}
