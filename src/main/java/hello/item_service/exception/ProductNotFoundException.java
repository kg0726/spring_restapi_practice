package hello.item_service.exception;

public class ProductNotFoundException extends RuntimeException{
    // 파일을 찾을 수 없다는 예외
    public ProductNotFoundException(String message) {
        super(message);
    }
}
