package com.springdream.app.service;

import com.springdream.app.domain.ReportVO;
import com.springdream.app.repository.ReportDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminReportService implements ReportService {

    private final ReportDAO reportDAO;

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
