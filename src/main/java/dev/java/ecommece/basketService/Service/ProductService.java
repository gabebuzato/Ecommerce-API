package dev.java.ecommece.basketService.Service;

import dev.java.ecommece.basketService.Client.PlatziStoreClient;
import dev.java.ecommece.basketService.Client.Response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts() {
        log.info("getAllProducts()");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#productId")
    public PlatziProductResponse getProductById(Long productId) {
        log.info("getProductById({})", productId);
        return platziStoreClient.getProductById(productId);
    }
}
