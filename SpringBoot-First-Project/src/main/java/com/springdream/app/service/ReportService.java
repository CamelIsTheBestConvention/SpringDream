package com.springdream.app.service;

import com.springdream.app.domain.ReportVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {

    public void register(ReportVO reportVO);

    public ReportVO show(Long reportNumber);

    public List<ReportVO> showAll();
}
