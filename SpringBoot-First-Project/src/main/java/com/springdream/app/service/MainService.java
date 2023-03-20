package com.springdream.app.service;

import com.springdream.app.domain.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MainService {
    public List<BoardDTO> showByKeywordAll(String keyword);
}