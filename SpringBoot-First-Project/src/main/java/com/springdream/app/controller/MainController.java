package com.springdream.app.controller;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.RankingDTO;
import com.springdream.app.service.MainService;
import com.springdream.app.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainController {
    private final RankingService rankingService;

    private MainService mainService;

    @GetMapping("index")
    public String index(@CookieValue(name = "memberNumber", required = false) String memberNumber , Model model, HttpServletRequest request){

        model.addAttribute("memberNumber", request.getSession().getAttribute("memberNumber"));

        if(memberNumber != null){
            model.addAttribute("memberNumber", Integer.valueOf(memberNumber));
        }
        List<RankingDTO> points = rankingService.rankingListService();
        model.addAttribute("points", points);

        return "main/index";
    }

    @GetMapping("searchResult")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDTO> boardDTOList = mainService.showByKeywordAll(keyword);
        model.addAttribute("keyword", keyword);
        model.addAttribute("boardCount", mainService.showByKeywordAll(keyword).size());
        model.addAttribute("boardList", boardDTOList);

        return "fix/searchResult";
    }

}
