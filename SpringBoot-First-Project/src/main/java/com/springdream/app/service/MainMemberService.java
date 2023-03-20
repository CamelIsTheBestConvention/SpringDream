package com.springdream.app.service;

import com.springdream.app.domain.MemberDTO;
import com.springdream.app.domain.MemberVO;
import com.springdream.app.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service @Qualifier("memberMain")
@RequiredArgsConstructor
public class MainMemberService implements MemberService{

    private final MemberDAO memberDAO;

    //  회원가입
    @Override
    public void register(MemberVO memberVO) {
        // MEMBER_RANK 디폴드값 E 설정
        // MEMBER_STATUS 디폴드값 1 설정
        memberVO.setMemberStatus(1);
        memberDAO.join(memberVO);
    }

    //  정보 수정
    @Override
    public void modify(MemberVO memberVO) {
        memberDAO.update(memberVO);
    }

    //  회원탈퇴
    @Override
    public void quit(Long memberNumber) {
        memberDAO.quit(memberNumber);
    }

    //  회원조회
    public MemberVO select(Long memberNumber){
        return memberDAO.select(memberNumber);
    }

    //  전체 회원조회
    @Override
    public List<MemberVO> selectAll(){
        return null;
    }

    //  회원 게시글 수 조회
    public int boardCount(Long memberNumber){
        return memberDAO.getBoardNum(memberNumber);
    }

    // 회원 답글 수 조회
//    public int replyCount(Long memberNumber){
//        return replyDAO.getBoardNum(memberNumber);
//    }


    //  아이디 중복확인  public int checkId(String memberId);
    @Override
    public int checkId(String memberId) {return memberDAO.checkId(memberId); }

    //  로그인
    //  로그인 성공 시 memberNumber, 실패 시 0 출력
    @Override
    public int login(MemberVO memberVO) { return memberDAO.login(memberVO); }

    //    로그아웃
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
