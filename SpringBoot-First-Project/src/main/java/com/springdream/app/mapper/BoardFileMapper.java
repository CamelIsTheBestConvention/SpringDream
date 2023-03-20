package com.springdream.app.mapper;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.ReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardFileMapper {

    //    추가
    public void insert(ReportVO supportVO);
    //    수정
    public void update(BoardDTO boardDTO);
    //    삭제
    public void delete(Long boardNumber);
    //    조회
    public BoardDTO select(Long boardNumber);
    //    전체 조회
    public List<BoardDTO> selectAll();
}
