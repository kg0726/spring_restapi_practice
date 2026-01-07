package hello.item_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResult {
    private String code;  // 에러 응답 코드
    private String message; // 에러 메시지
}
