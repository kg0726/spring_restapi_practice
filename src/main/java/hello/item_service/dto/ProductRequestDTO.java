package hello.item_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;


// httpmessageconverter가 요청으로 들어온 파라미터(json)를 해당 클래스의 get 메서드들을 보고 자바 객체로 매핑해줌
@Getter
@NoArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "상품 이름은 공백일 수 없습니다.")
    private String productName;

    @NotNull
    @Min(value = 100, message = "상품 최소 가격은 100원입니다.")
    private int productPrice;

    @NotNull
    @Min(value = 1, message = "상품은 최소 1개 이상이어야 합니다.")
    private int productAmount;
}
