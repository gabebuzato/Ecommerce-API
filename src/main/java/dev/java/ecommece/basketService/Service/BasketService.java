package dev.java.ecommece.basketService.Service;

import dev.java.ecommece.basketService.Client.Response.PlatziProductResponse;
import dev.java.ecommece.basketService.Entity.Basket;
import dev.java.ecommece.basketService.Entity.Product;
import dev.java.ecommece.basketService.Entity.Status;
import dev.java.ecommece.basketService.Repository.basketRepository;
import dev.java.ecommece.basketService.Request.BasketRequest;
import dev.java.ecommece.basketService.Request.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final basketRepository basketRepository;
    private final ProductService productService;

    public Basket getBasketById(String id){
        return basketRepository.getBasketById(id)
                .orElseThrow(() -> new IllegalArgumentException("Basket not found!"));
    }

    public Basket createBasket(BasketRequest basketRequest) {

        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN).ifPresent(basket -> {
            throw new IllegalArgumentException("There is already an open basket for this client");
        });
        List<Product> products = new ArrayList<>();

        basketRequest.products().forEach(product -> {
                    PlatziProductResponse platziProductResponse = productService.getProductById(product.id());

            products.add(
                    Product.builder()
                    .id(platziProductResponse.id())
                    .price(platziProductResponse.price())
                    .title(platziProductResponse.title())
                    .quantity(product.quantity())
                    .build()
            );
        });

        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();

        basketRepository.save(basketRequest);
        return basket;
    }

    public Basket updateBasket(String id, BasketRequest basketRequest) {
        Basket basket = getBasketById(id);

        List<Product> products = new ArrayList<>();
        basketRequest.products().forEach(product -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(Long.valueOf(basket.getId()));
            products.add(
                    Product.builder()
                            .id(platziProductResponse.id())
                            .title(platziProductResponse.title())
                            .price(platziProductResponse.price())
                            .quantity(product.quantity())
                            .build()
            );
        });
        basket.setProducts(products);
        basket.calculateTotalPrice();
        return (Basket) basketRepository.save(basket);
    }
    public Basket payBasket(String id, PaymentRequest paymentRequest) {
        Basket basket = getBasketById(id);
        basket.setPaymentMethod(paymentRequest.paymentMethod());
        basket.setStatus(Status.SOLD);

        return (Basket) basketRepository.save(basket);
    }

    public void deleteBasketById(String id) {
        Basket basket = getBasketById(id);
        basketRepository.delete(basket);
    }
}
