package com.springdream.app.controller;

import com.springdream.app.domain.BoardDTO;
import com.springdream.app.domain.MemberVO;
import com.springdream.app.domain.PointVO;
import com.springdream.app.domain.ReplyDTO;
import com.springdream.app.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/*")
public class MemberController {

    private final MainMemberService memberService;
    private final MypageBoardService boardService;
    private final MypageReplyService replyService;
    private final PointService pointService;


    //    회원가입
    @GetMapping("/join")
    public String join() {
        return "member/join.html";
    }

    @PostMapping("/join")
    public RedirectView join(MemberVO member) {
        memberService.register(member);

        PointVO pointVO = new PointVO();
        // 기본 충전 포인트 : 500
        pointVO.setCurrentPoint(500L);
        pointVO.setTotalPoint(500L);

        int memberNumber = memberService.login(member);

        pointVO.setMemberNumber(memberNumber);
        pointService.insert(pointVO);
        return new RedirectView("/member/login");
    }

    //  아이디 중복검사
    @PostMapping("/checkId")
    @ResponseBody
    public Map<Object, Object> checkId(HttpServletRequest request) {

        Map<Object, Object> resultMap = new HashMap<>();
        String memberId = request.getParameter("memberId");
        if(memberId.equals("")){
            resultMap.put("count", -1);
            return resultMap;
        }

        resultMap.put("count", memberService.checkId(memberId));
        return resultMap;
    }

    //    로그인
    @GetMapping("/login")
    public String login() {
        return "member/login.html";
    }

    @PostMapping("/login")
    public String login(String memberId, String memberPw, HttpServletRequest request, HttpServletResponse response, Model model) {
        String url = "redirect:/main/index";

        if(request.getSession().getAttribute("memberNumber") != null){
            return url;
        }

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberId(memberId);
        memberVO.setMemberPw(memberPw);
        int memberNumber = memberService.login(memberVO);
        // 로그인 실패
        if(memberNumber == 0){
            model.addAttribute("loginFail", "로그인 실패. 아이디 혹은 비밀번호를 확인해주세요.");
            url = "/member/login";
        } else {
            // 로그인 성공
            HttpSession session = request.getSession();
            Cookie cookie = new Cookie("memberNumber", String.valueOf(memberNumber));
            cookie.setMaxAge(60*60*6);
            response.addCookie(cookie);
            session.setAttribute("memberNumber", memberNumber);
        }
        return url;
    }

    //    아이디/비밀번호 찾기
    @GetMapping("/findId")
    public String findId() { return "member/findId"; }

    @PostMapping("/findId")
    public String findId(String memberName, String memberMobile){
        return "member/findId";
    }

    //    로그아웃
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("memberNumber");

        // 회원번호 쿠키 제거
        Cookie cookie = new Cookie("memberNumber", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/main/index");
        mav.addObject("msg", "logout");
        return mav;
    }

    //    마이페이지 내 정보 수정
    @GetMapping("/myinfo")
    public String myinfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("memberNumber") == null){
            return "/main/index";
        } else {
            int memberNumber = (Integer) session.getAttribute("memberNumber");
            MemberVO memberVO = memberService.select(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("memberVO", memberVO);
            return "/mypage/mypage_info";
        }
    }

    @PostMapping("/myinfo")
    public String myinfo(MemberVO memberVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("memberNumber") == null){
            return "main/index";
        } else {
            int memberNumber = (Integer) session.getAttribute("memberNumber");
            memberVO.setMemberNumber(Long.parseLong(String.valueOf(memberNumber)));
            memberService.modify(memberVO);
            return "mypage/mypage_info";
        }
    }

    //    마이페이지 나의 글 목록
    @GetMapping("/myboard")
    public String myboard(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("memberNumber") == null){
            return "main/index";
        } else {
            int memberNumber = (Integer) session.getAttribute("memberNumber");
            MemberVO memberVO = memberService.select(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("memberVO", memberVO);
            List<BoardDTO> boards = boardService.showMemberBoardAll(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("boards", boards);
            return "mypage/mypage_boards.html";
        }
    }

    @PostMapping("/myboard")
    public void popular(Model model, Long memberNumber) {
        model.addAttribute("selectMemberBoardAll", boardService.showMemberBoardAll(memberNumber));
    }

    //    마이페이지 나의 답글 목록
    @GetMapping("/myreply")
    public String myreply(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("memberNumber") == null){
            return "main/index";
        } else {
            int memberNumber = (Integer) session.getAttribute("memberNumber");
            MemberVO memberVO = memberService.select(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("memberVO", memberVO);
            List<ReplyDTO> replies = replyService.showMemberReplyAll(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("replies", replies);
            return "mypage/mypage_reply.html";
        }
    }
    @PostMapping("/myreply")
    public void popular(Long memberNumber, Model model) {
        model.addAttribute("selectMemberReplyAll", replyService.showMemberReplyAll(memberNumber));
    }

    //    마이페이지 내 포인트
    @GetMapping("/mypoints")
    public String mypoints(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("memberNumber") == null){
            return "main/index";
        } else {
            int memberNumber = (Integer) session.getAttribute("memberNumber");
            MemberVO memberVO = memberService.select(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("memberVO", memberVO);
            PointVO pointVO = pointService.getMemberPoint(Long.parseLong(String.valueOf(memberNumber)));
            model.addAttribute("pointVO", pointVO);
            return "mypage/mypage_points.html";
        }
    }

    //    마이페이지 충전내역 확인
    @GetMapping("/mycash")
    public String mycash() {
        return "mypage/mypage_cash.html";
    }

    // 유저 포인트 충전
    @PostMapping("/payment")
    @ResponseBody
    public String payment(HttpServletRequest request){
        String amount = request.getParameter("amount");
        String msg = amount + "포인트" + "충전이 완료되었습니다";
        Long memberNumber = Long.parseLong(request.getSession().getAttribute("memberNUmber").toString());

        pointService.addPoint(Long.parseLong(amount), memberNumber);

        return msg;
    }


}