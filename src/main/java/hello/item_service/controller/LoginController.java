package hello.item_service.controller;

import hello.item_service.domain.Member;
import hello.item_service.dto.LoginRequestDTO;
import hello.item_service.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginRequest, HttpServletRequest request) {
        Member loginMember = loginService.login(loginRequest.getLoginId(), loginRequest.getPassword());

        if (loginMember == null) return "로그인 실패";

        // 세션이 있으면 세션을 반환하고 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);
        return "로그인 성공";
    }
}
