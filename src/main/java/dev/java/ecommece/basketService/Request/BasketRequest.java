package dev.java.ecommece.basketService.Request;

import dev.java.ecommece.basketService.Request.ProductRequest;

import java.util.List;

public record BasketRequest(Long clientId,List<ProductRequest> products) {
}
