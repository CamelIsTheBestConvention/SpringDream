package com.springdream.app.repository;

import com.springdream.app.domain.PointDTO;
import com.springdream.app.domain.RankingDTO;
import com.springdream.app.mapper.RankingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RankingDAO {
    private final RankingMapper rankingMapper;

    //  누적 포인트 기준 랭킹 리스트
    public List<RankingDTO> findAllOrderByTotalPoint(){
        return rankingMapper.selectAllOrderByTotalPoint();
    }

    //  채택 수 기준 랭킹 리스트
    public List<RankingDTO> findAllOrderByAdoptCount() { return rankingMapper.selectAllOderByAdoptCount(); }

    //  답글 수 기준 랭킹 리스트
    public List<RankingDTO> countReplies() { return rankingMapper.countReplies();}
}
