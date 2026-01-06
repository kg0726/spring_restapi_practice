package hello.item_service.dto;


import hello.item_service.domain.Product;
import lombok.Getter;
import lombok.Setter;

// 응답 포맷을 결정
@Getter
@Setter
public class ProductResponseDTO {

    private Long productId;
    private String productName;
    private int productPrice;
    private int productAmount;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(Long productId, String productName, int productPrice, int productAmount) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
    }

    public ProductResponseDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productAmount = product.getProductAmount();
    }
}
