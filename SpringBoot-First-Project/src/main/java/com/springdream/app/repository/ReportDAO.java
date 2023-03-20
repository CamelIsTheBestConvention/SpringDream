package com.springdream.app.repository;

import com.springdream.app.domain.ReportVO;
import com.springdream.app.mapper.ReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportDAO {
    private final ReportMapper reportMapper;

    public void register(ReportVO reportVO){
        reportMapper.insert(reportVO);
    }

    public ReportVO select(Long reportNumber){
        return reportMapper.select(reportNumber);
    }

    public List<ReportVO> selectAll(){
        return reportMapper.selectAll();
    }
}
