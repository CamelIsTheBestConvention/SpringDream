package com.springdream.app.service;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.domain.Criteria;
import com.springdream.app.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("subject") @Primary
public class SubjectBoardService implements BoardService{

    private final BoardDAO boardDAO;

    @Override
    public void register(BoardVO boardVO) {
        boardDAO.save(boardVO);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        boardDAO.setBoardDTO(boardDTO);
    }

    @Override
    public void remove(Long boardNumber) {

    }

    @Override
    public List<BoardDTO> showMemberBoardAll(Long memberNumber) {
        return boardDAO.findMemberBoardAll(memberNumber);
    }

    @Override
    public BoardDTO show(Long boardNumber) {
        return boardDAO.findByBoard(boardNumber);
    }

    @Override
    public List<BoardDTO> showAll(Criteria criteria) {
        return boardDAO.findUnreportAll();
    }

    @Override
    public List<BoardDTO> popularPost() {
        return boardDAO.popularPost();
    }

    @Override
    public List<BoardDTO> recentPost() {
        return boardDAO.recentPost();
    }

    @Override
    public List<BoardDTO> categoryPost(String category) {
        return boardDAO.categoryPost(category);
    }

    public void addViewCount(Long boardNumber) { boardDAO.addViewCount(boardNumber); }

}
