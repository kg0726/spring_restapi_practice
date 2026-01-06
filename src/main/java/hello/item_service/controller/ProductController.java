package hello.item_service.controller;

import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;
import hello.item_service.service.ProductService;
import hello.item_service.service.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    // 의존관계 주입
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 정보 저장
    @PostMapping
    public Product addProduct(@RequestBody ProductRequestDTO requestDTO) {
        productService.addProduct(requestDTO)
    }
}
