package hello.item_service.controller;

import hello.item_service.dto.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * RestController에서 발생하는 예외를 잡아서 처리함
 */
@RestControllerAdvice
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResult handleValidationException(MethodArgumentNotValidException e) {
        // 발생한 에러 중 첫번째 에러 메시지를 가져옴
        String errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return new ErrorResult(HttpStatus.BAD_REQUEST.toString(), errorMessage);
    }
}
