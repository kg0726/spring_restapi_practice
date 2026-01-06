package hello.item_service.service;

import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;

import java.util.List;

public interface ProductService {
    // 상품 리스트 목록 가져오기
    List<Product> getProductList();

    // 상품 상세 조회
    Product getProduct(Long productId);

    // 상품 저장
    Product addProduct(ProductRequestDTO requestDTO);

    // 상품 수정
    void updateProduct(Long productId, Product updateParam);
}
