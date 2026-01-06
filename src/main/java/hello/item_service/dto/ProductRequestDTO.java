package hello.item_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductRequestDTO {

    private String productName;
    private int productPrice;
    private int productAmount;
}
