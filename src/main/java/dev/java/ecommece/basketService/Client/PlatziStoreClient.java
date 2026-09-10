package dev.java.ecommece.basketService.Client;

import dev.java.ecommece.basketService.Client.Response.PlatziProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}", configuration = {CustomErrorDecoder.class})
public interface PlatziStoreClient {

    @GetMapping
    List<PlatziProductResponse> getAllProducts();

    @GetMapping("/{id}")
    PlatziProductResponse getProductById(@PathVariable Long id);
}
