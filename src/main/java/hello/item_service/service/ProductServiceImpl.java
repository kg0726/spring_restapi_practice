package hello.item_service.service;

import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;
import hello.item_service.dto.ProductResponseDTO;
import hello.item_service.repository.MemoryProductRepository;
import hello.item_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ProductResponseDTO> getProductList() {
        ArrayList<Product> products = productRepository.findAll();
        List<ProductResponseDTO> responseDTO = new ArrayList<>();
        for (Product product : products) {
            responseDTO.add(new ProductResponseDTO(product));
        }
        return responseDTO;
    }

    @Override
    public ProductResponseDTO getProduct(Long productId) {
        return new ProductResponseDTO(productRepository.findById(productId));
    }

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO requestDTO) {
        // 여기에서 DTO를 product 객체로 변환해서 전달
        Product product = productRepository.save(new Product(requestDTO));
        // 다시 product 객체를 응답 dto로 변환해서 전달
        return new ProductResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long productId, ProductRequestDTO requestDTO) {
        Product updateParam = new Product(requestDTO);
        return new ProductResponseDTO(productRepository.update(productId, updateParam));
    }
}
