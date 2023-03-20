package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReportVO {

    private Long reportNumber;
    private String reportDate;
    private String reportTitle;
    private String reportContent;
    private String reportType;
    private Long memberNumber;
    private Long boardNumber;

    public void create(String reportTitle, String reportContent, String reportType, Long memberNumber, Long boardNumber) {
        this.reportTitle = reportTitle;
        this.reportContent = reportContent;
        this.reportType = reportType;
        this.memberNumber = memberNumber;
        this.boardNumber = boardNumber;
    }
}
