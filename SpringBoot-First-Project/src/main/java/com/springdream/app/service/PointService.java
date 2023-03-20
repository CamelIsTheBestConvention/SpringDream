package com.springdream.app.service;

import com.springdream.app.domain.Criteria;
import com.springdream.app.domain.PointVO;
import com.springdream.app.repository.PointDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

// worker: LeeJunSang
// lastUpdate : 221202
@Service
@RequiredArgsConstructor @Qualifier("point") @Primary
public class PointService {

    private final PointDAO pointDAO;

    // 임시로 만듦
    public void insert(PointVO pointVO){
        pointDAO.insertPoint(pointVO);
    }

    // 임시로 만듦
    public void addPoint(Long point, Long memberNumber) { pointDAO.addPoint(point, memberNumber); }

    public PointVO getMemberPoint(Long memberNumber) { return pointDAO.findById(memberNumber); }
}

