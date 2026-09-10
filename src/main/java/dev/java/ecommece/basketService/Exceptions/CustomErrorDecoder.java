package dev.java.ecommece.basketService.Exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new DataNotFoundException("Product/Basket not found");
            default:
                return new Exception("Exeception while getting product");
        }
    }
}
