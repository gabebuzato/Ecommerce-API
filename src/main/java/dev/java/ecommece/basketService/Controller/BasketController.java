package dev.java.ecommece.basketService.Controller;

import dev.java.ecommece.basketService.Entity.Basket;
import dev.java.ecommece.basketService.Repository.basketRepository;
import dev.java.ecommece.basketService.Request.BasketRequest;
import dev.java.ecommece.basketService.Request.PaymentRequest;
import dev.java.ecommece.basketService.Service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {

private final BasketService basketService;

@PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest basketRequest){
    return ResponseEntity.status(HttpStatus.CREATED).body(basketService.createBasket(basketRequest));
}

@GetMapping
    public ResponseEntity<Basket> getBasketById(@PathVariable String id){
        return ResponseEntity.ok(basketService.getBasketById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable String id, @RequestBody BasketRequest basketRequest){
        return ResponseEntity.status(HttpStatus.OK).body(basketService.updateBasket(id, basketRequest));
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> payBasket(@PathVariable String id, @RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.status(HttpStatus.OK).body(basketService.payBasket(id, paymentRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasketById(@PathVariable String id){
    basketService.deleteBasketById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
