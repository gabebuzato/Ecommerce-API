package dev.java.ecommece.basketService.Docs;

import dev.java.ecommece.basketService.Client.Response.PlatziProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Tag(name="Product",
description = "Endpoints who get and get products by our ID "
)
public interface ProductControllerDoc {

    @Operation(
            summary = "Get products",
            description = "Return the products of an external API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "The products are sucefully getted"
    )
    ResponseEntity<List<PlatziProductResponse>> getAllProducts();



    @Operation(
            summary = "Get an product by our ID",
            description = "Receive an ID and return the product who have the required ID of an external API"
    )
    @ApiResponse(
            responseCode = "200",
            description = "The product are sucefully getted"
    )
    ResponseEntity<PlatziProductResponse> getProductById(@PathVariable Long id);
}
