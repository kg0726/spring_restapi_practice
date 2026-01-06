package hello.item_service.service;

import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;
import hello.item_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    // 상품 레포
    private final ProductRepository productRepository;

    // 의존관계 주입
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product addProduct(ProductRequestDTO requestDTO) {
        return productRepository.save(requestDTO);
    }

    @Override
    public void updateProduct(Long productId, Product updateParam) {
        productRepository.update(productId, updateParam);
    }
}
