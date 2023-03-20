package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyDTO {
    private Long replyNumber;
    private String replyTitle;
    private String replyContent;
    private int replyAdopt;
    private int replyReport;
    private String replyDate;
    private String replyUpdateDate;
    private Long memberNumber;
    private Long boardNumber;
    private String memberId;
    private String memberName;
    private String memberRank;
}
