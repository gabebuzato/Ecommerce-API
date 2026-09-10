package dev.java.ecommece.basketService.Controller;

import dev.java.ecommece.basketService.Client.Response.PlatziProductResponse;
import dev.java.ecommece.basketService.Docs.ProductControllerDoc;
import dev.java.ecommece.basketService.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController implements ProductControllerDoc {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<PlatziProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatziProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

}
