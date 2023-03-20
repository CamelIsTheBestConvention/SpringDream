package com.springdream.app.controller;

import com.springdream.app.domain.ReportVO;
import com.springdream.app.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    @Qualifier("board")
    private final ReportService reportService;

    @GetMapping("")
    public String main(Model model, String boardNumber){
        model.addAttribute("report", new ReportVO());
        model.addAttribute("boardNumber", boardNumber);
        return "report/reportPage";
    }

    @PostMapping("/submit")
    public RedirectView main(ReportVO reportVO, String boardNumber, HttpServletRequest request) {
        // 테스트용으로 임시 작성, 회원번호 받아와야 함
//        Long memberNumber = Long.parseLong(request.getSession().getAttribute("memberNumber").toString());
//        reportVO.setMemberNumber(memberNumber);
        reportVO.setMemberNumber(23L);

        Long num = Long.parseLong(boardNumber);
        reportVO.setBoardNumber(num);

        reportService.register(reportVO);
        return new RedirectView("/main/index");
    }
}
