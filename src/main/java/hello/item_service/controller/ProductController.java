package hello.item_service.controller;

import hello.item_service.NoAuth;
import hello.item_service.domain.IpPort;
import hello.item_service.domain.Product;
import hello.item_service.dto.ProductRequestDTO;
import hello.item_service.dto.ProductResponseDTO;
import hello.item_service.service.ProductService;
import hello.item_service.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final MessageSource messageSource;

    // 의존관계 주입
    public ProductController(ProductService productService, MessageSource messageSource) {
        this.productService = productService;
        this.messageSource = messageSource;
    }

    // 상품 정보 저장
    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProducts(@RequestPart(value = "image", required = false) MultipartFile imageFile, @Valid @RequestBody ProductRequestDTO requestDTO) throws IOException {
        // 파일이 들어왔다면 서버에 저장
        String savedFileName = "";
        if (imageFile != null && !imageFile.isEmpty()) {
            savedFileName = imageFile.getOriginalFilename();
            String fullPath = "C:/upload/" + savedFileName; // 저장 경로
            imageFile.transferTo(new File(fullPath));
        }
        ProductResponseDTO responseDTO = productService.addProduct(requestDTO);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    // 상품 전체 조회
    @GetMapping
    @NoAuth
    public ResponseEntity<List<ProductResponseDTO>> getProductList() {
        System.out.println(productService.getProductList());
        return new ResponseEntity(productService.getProductList(), HttpStatus.OK);
    }

    // 상품 단일 조회
    @GetMapping("/{productId}")
    @NoAuth
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

    // 국제화 예제
    @GetMapping("properties")
    public String getHello(@RequestHeader(name = "Accept-Language", required = false)Locale locale) {
        // locale 정보를 바탕으로 hello 라는 키에 해당하는 메시지를 가져옴
        return messageSource.getMessage("hello", null, locale);
    }

    @GetMapping("/test/ip-port")
    public String ipPort(@RequestParam IpPort ipPort) {
        System.out.println("ipPort.getIp() = " + ipPort.getIp());
        System.out.println("ipPort.getPort() = " + ipPort.getPort());
        return "ok";
    }
}
