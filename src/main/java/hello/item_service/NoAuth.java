package hello.item_service;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 런타임(애플리케이션 실행) 시점에도 애너테이션을 유지함
@Retention(RetentionPolicy.RUNTIME)
public @interface NoAuth {
}
