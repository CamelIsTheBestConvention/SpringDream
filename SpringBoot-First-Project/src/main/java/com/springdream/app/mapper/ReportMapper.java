package com.springdream.app.mapper;

import com.springdream.app.domain.ReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {

    public void insert(ReportVO reportVO);

    public ReportVO select(Long reportNumber);

    public List<ReportVO> selectAll();

}
