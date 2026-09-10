package dev.java.ecommece.basketService.Repository;
import dev.java.ecommece.basketService.Entity.Basket;
import dev.java.ecommece.basketService.Entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface basketRepository extends MongoRepository {

    Optional<Basket> findByClientAndStatus(Long client, Status status);

    Optional<Basket> getBasketById(String id);
}
