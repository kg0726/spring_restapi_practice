package hello.item_service.interceptor;

import hello.item_service.NoAuth;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // handler가 spring 컨트롤러에 등록된 메서드인지 확인
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            // 해당 메서드나 클래스에 NoAuth 어노테이션이 붙어있다면 로그인을 확인하지 않고 통과
            if (hm.getMethodAnnotation(NoAuth.class) != null) {
                return true;
            }
        }

        // 세션이 있으면 해당 세션을 반환하고 없으면 null을 반환
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("loginMember") == null) {
            // 로그인 안된 사용자라면 401 에러를 던지거나 거절함
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        // 로그인 성공
        return true;
    }
}
