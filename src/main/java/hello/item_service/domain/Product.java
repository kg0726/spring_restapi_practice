package hello.item_service.domain;

import hello.item_service.dto.ProductRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long productId;
    private String productName;
    private int productPrice;
    private int productAmount;

    // 서버에 저장될 이미지 파일 이름
    private String imageFileName;

    public Product(ProductRequestDTO requestDTO) {
        this.productAmount = requestDTO.getProductAmount();
        this.productName = requestDTO.getProductName();
        this.productPrice = requestDTO.getProductPrice();
    }
}
