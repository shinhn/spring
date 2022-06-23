package com.selecshop.week4.controller;

import com.selecshop.week4.models.Product;
import com.selecshop.week4.models.ProductMypriceRequestDto;
import com.selecshop.week4.models.ProductRepository;
import com.selecshop.week4.models.ProductRequestDto;
import com.selecshop.week4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(id, requestDto);
    }
}
