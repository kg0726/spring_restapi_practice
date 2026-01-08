package hello.item_service;

import hello.item_service.converter.StringToPortConverter;
import hello.item_service.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 로그인 인터셉터 등록
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1) // 우선순위 설정(낮을 수록 먼저 실행)
                .addPathPatterns("/**")  // 어떤 경로에 적용할 지(여기서는 모든 경로에 적용)
                .excludePathPatterns(
                        "/", "/login", "/logout",
                        "/css/**", "/*.ico", "/error"
                ); // 이 경로들은 인터셉터 검사에서 제외함
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 컨버터 추가
        registry.addConverter(new StringToPortConverter());
    }
}
