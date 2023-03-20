package com.springdream.app.service;


import com.springdream.app.domain.BoardDTO;
import com.springdream.app.repository.BoardDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor @Qualifier("main") @Primary
public class MainSearchService implements MainService{

    private final BoardDAO boardDAO;

    @Override
    public List<BoardDTO> showByKeywordAll(String keyword) {
        return boardDAO.searchByKeywordAll(keyword);
    }
}
