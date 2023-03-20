package com.springdream.app.controller;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.BoardVO;
import com.springdream.app.service.BoardService;
import com.springdream.app.service.SubjectBoardService;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/board/*")
public class BoardController {
    private final BoardService boardService;
    private final SubjectBoardService subjectBoardService;

//    게시글 목록
    @GetMapping("/boardMain")
    public void main(Model model) {

        model.addAttribute("boardCount", boardService.recentPost().size());
        model.addAttribute("boards", boardService.recentPost());
    }

    //    게시글 등록
    @GetMapping("/writePage")
    public String write(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("memberNumber") == null){
            return "redirect:/member/login";
        }
        model.addAttribute("board", new BoardVO());

        return "board/writePage";
    }

    @PostMapping("/writePage")
    public RedirectView write(BoardVO boardVO, HttpServletRequest request, RedirectAttributes redirectAttributes){
        Long memberNumber = Long.parseLong(request.getSession().getAttribute("memberNumber").toString());
        boardVO.setMemberNumber(memberNumber);
        boardService.register(boardVO);
        redirectAttributes.addFlashAttribute("boardNumber", boardVO.getBoardNumber());
        return new RedirectView("/board/boardMain");
    }

//    게시글 상세보기
    @GetMapping("/page")
    public String read(Long boardNumber, Model model){
       String category = boardService.show(boardNumber).getBoardCategory();
        subjectBoardService.addViewCount(boardNumber);
//       model.addAttribute("replylist", replyService.showList());
       model.addAttribute("boardlist", boardService.categoryPost(category));
       model.addAttribute("board", boardService.show(boardNumber));
       return "/board/page";
    }

//    게시글 수정
    @PostMapping("/update")
    public RedirectView update(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        boardService.modify(boardDTO);
        redirectAttributes.addFlashAttribute("boardNumber", boardDTO.getBoardNumber());
        return new RedirectView("/board/read");
    }

//    게시글 삭제
    @GetMapping("/delete")
    public RedirectView delete(Long boardNumber){
        boardService.remove(boardNumber);
        return new RedirectView("/board/boardMain");
    }

    //    인기글
    @GetMapping("/popular")
    public void popular(Model model) {
        model.addAttribute("popular", boardService.popularPost());
    }

    //    최신글
    @GetMapping("/recent")
    public void recent(Model model) {
        model.addAttribute("recent", boardService.recentPost());
    }

    //    카테고리
    @GetMapping("/category")
    public void category(String boardCategory, Model model) {
        model.addAttribute("category", boardService.categoryPost(boardCategory));
    }

}
