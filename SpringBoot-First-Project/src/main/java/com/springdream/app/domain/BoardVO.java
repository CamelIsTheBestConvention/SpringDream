package com.springdream.app.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BoardVO {
    private Long boardNumber;
    private String boardTitle;
    private String boardContent;
    private int boardReward;
    private String boardCategory;
    private int boardAdopt;
    private int boardReport;
    private Long memberNumber;

    public void create( String boardCategory, String boardTitle, String boardContent, int boardReward, Long memberNumber) {
        this.boardCategory = boardCategory;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardReward = boardReward;
        this.memberNumber = memberNumber;
    }
}

