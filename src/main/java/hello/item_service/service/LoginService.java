package hello.item_service.service;

import hello.item_service.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public Member login(String loginId, String password) {
        // 실제로는 DB를 조회해야 하지만 실습을 위해 admin, 1234면 성공이라고 가정
        if ("admin".equals(loginId) && "1234".equals(password)) {
            Member member = new Member();
            member.setLoginId(loginId);
            member.setName("admin");
            // 로그인 성공 시 사용자 객체를 반환
            return member;
        }
        // 로그인 실패
        return null;
    }
}
