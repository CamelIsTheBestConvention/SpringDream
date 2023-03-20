package com.springdream.app.service;

import com.springdream.app.domain.MemberVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface MemberService {
    //  회원가입
    public void register(MemberVO memberVO);
    //  정보 수정
    public void modify(MemberVO memberVO);

    //  회원탈퇴
    public void quit(Long memberNumber);

    // 회원조회 (VO)
    public MemberVO select(Long memberNumber);

    //  전체 회원조회 (VO)
    public List<MemberVO> selectAll();

//    // 최근 N개 회원조회
//    public List<MemberDTO> newMembers(int criteria);

    //  아이디 중복확인
    public int checkId(String memberId);

    //  로그인
    //  로그인 성공 시 memberNumber, 실패 시 0 출력
    public int login(MemberVO memberVO);

    //    로그아웃
    public void logout(HttpSession session);
}
