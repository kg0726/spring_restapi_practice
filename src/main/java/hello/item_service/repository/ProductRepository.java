package hello.item_service.repository;

import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private static final Map<Long, Product> productMap = new HashMap<>();
    private static Long sequence = 0L;

    // 상품 리스트 반환
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    // 상품 정보 상세 조회
    public Product findById(Long productId) {
        return productMap.get(productId);
    }

    // 상품 등록
    public Product save(ProductRequestDTO requestDTO) {
        Product product = new Product(requestDTO);
        product.setProductId(++sequence);
        return product;
    }

    // 상품 업데이터
    public void update(Long productId, Product updateParam) {
        Product product = findById(productId);
        product.setProductName(updateParam.getProductName());
        product.setProductAmount(updateParam.getProductAmount());
        product.setProductPrice(updateParam.getProductPrice());
    }
}
