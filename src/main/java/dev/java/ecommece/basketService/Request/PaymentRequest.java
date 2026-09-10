package dev.java.ecommece.basketService.Request;

import dev.java.ecommece.basketService.Entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record PaymentRequest(PaymentMethod paymentMethod) {
}
