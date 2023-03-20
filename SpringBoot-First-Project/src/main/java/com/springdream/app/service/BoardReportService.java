package com.springdream.app.service;

import com.springdream.app.domain.ReportVO;
import com.springdream.app.repository.ReportDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("board") @Primary
public class BoardReportService implements ReportService{

    private final ReportDAO reportDAO;
    private final String REPORT_TYPE_1 = "불건전하거나 불쾌감을 주는 내용";
    private final String REPORT_TYPE_2 = "도배성 게시글";
    private final String REPORT_TYPE_3 = "게시판 카테고리에 맞지 않는 내용";

    @Override
    public void register(ReportVO reportVO) {
        reportDAO.register(reportVO);
    }

    @Override
    public ReportVO show(Long reportNumber) {
        return reportDAO.select(reportNumber);
    }

    @Override
    public List<ReportVO> showAll() {
        return reportDAO.selectAll();
    }
}
