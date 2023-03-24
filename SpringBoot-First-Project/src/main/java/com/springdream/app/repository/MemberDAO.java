package com.springdream.app.repository;

import com.springdream.app.domain.Criteria;
import com.springdream.app.domain.MemberVO;
import com.springdream.app.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;
    //  회원가입
    public void join(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    //  정보 수정
    public void update(MemberVO memberVO){
        memberMapper.update(memberVO);
    }

    //  회원탈퇴
    public void quit(Long memberNumber){
        memberMapper.quit(memberNumber);
    }

    //  회원삭제
    public void delete(Long memberNumber) { memberMapper.delete(memberNumber); }

    //  회원조회
    public MemberVO select(Long memberNumber){
        return memberMapper.select(memberNumber);
    }

    //  전체 회원조회
    public List<MemberVO> selectAll(Criteria criteria){
        return memberMapper.selectAll(criteria);
    }

    // 회원 전체갯수 조회
    public int countTotal() { return memberMapper.countTotal(); }

    // 회원 최신 N개 조회
    public List<MemberVO> selectRecent(int criteria) { return memberMapper.selectRecent(criteria); };

    //  아이디 중복확인
    public int checkId(String memberId) { return memberMapper.checkId(memberId);}

    //  닉네임 중복확인
    public int checkNick(String memberNickname) { return memberMapper.checkNick(memberNickname);}

    // 회원 게시글수 조회
    public int getBoardNum(Long memberNumber) { return memberMapper.memberBoardCount(memberNumber); }

    //  로그인
    public int login(MemberVO memberVO) {return memberMapper.login(memberVO);}

    //    로그아웃
    public void logout(HttpSession session) {}

    // 아이디 찾기
    public String findId(String memberName, String memberMobile){ return memberMapper.selectId(memberName, memberMobile);};

    // 비밀번호 찾기
    public String findPw(String memberId, String memberMobile){ return memberMapper.selectPw(memberId, memberMobile);};

}