package dev.java.ecommece.basketService.Repository;
import dev.java.ecommece.basketService.Entity.Basket;
import dev.java.ecommece.basketService.Entity.Status;
import dev.java.ecommece.basketService.Request.BasketRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface basketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientAndStatus(Long client, Status status);

    Optional<Basket> getBasketById(String id);
}
