package hello.item_service.controller;

import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;
import hello.item_service.dto.ProductResponseDTO;
import hello.item_service.service.ProductService;
import hello.item_service.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ProductResponseDTO> addProducts(@RequestBody ProductRequestDTO requestDTO) {
        ProductResponseDTO responseDTO = productService.addProduct(requestDTO);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    // 상품 전체 조회
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getProductList() {
        System.out.println(productService.getProductList());
        return new ResponseEntity(productService.getProductList(), HttpStatus.OK);
    }

    // 상품 단일 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    // 상품 업데이트
    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable Long productId, @RequestBody ProductRequestDTO requestDTO
    ) {
        return new ResponseEntity<>(productService.updateProduct(productId, requestDTO), HttpStatus.OK);
    }
}
