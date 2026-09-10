package dev.java.ecommece.basketService.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Product {

    @Id
    private String id;

    private String title;

    private BigDecimal price;

    private Integer quantity;
}
