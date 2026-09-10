package dev.java.ecommece.basketService.Request;

import dev.java.ecommece.basketService.Entity.PaymentMethod;

public record PaymentRequest(PaymentMethod paymentMethod) {
}
