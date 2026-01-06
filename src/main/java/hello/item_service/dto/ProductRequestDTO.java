package hello.item_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;


// httpmessageconverter가 요청으로 들어온 파라미터(json)를 해당 클래스의 get 메서드들을 보고 자바 객체로 매핑해줌
@Getter
@NoArgsConstructor
public class ProductRequestDTO {

    private String productName;
    private int productPrice;
    private int productAmount;
}
