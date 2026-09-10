package dev.java.ecommece.basketService.Docs;

import dev.java.ecommece.basketService.Entity.Basket;
import dev.java.ecommece.basketService.Request.BasketRequest;
import dev.java.ecommece.basketService.Request.PaymentRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Basket",
description = "Endpoints who add, update, delete and get products of basket")
public interface BasketControllerDoc {

    @Operation(
    summary = "Create a new basket",
    description = "Receives a valid basket and search for the client, if that client haven't an open basket, create one "
    )
    @ApiResponse(
    responseCode = "400",
    description = "There is already an open basket for this client"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Basket Created"
    )
    ResponseEntity<Basket> createBasket (@RequestBody BasketRequest basketRequest);

    @Operation(
            summary = "Get an Basket with an ID",
            description = "Receives a valid Id and search for the Basket"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Basket not found"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Return the basket whith the required id"
    )
    ResponseEntity<Basket> getBasketById(@PathVariable String id);




    @Operation(
            summary = "Update an Basket",
            description = "Receives a valid Id and search for the Basket, if that Basket exists update with the new data"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Basket not found"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Return the updated basket whith the required id"
    )
    ResponseEntity<Basket> updateBasket(@PathVariable String id, @RequestBody BasketRequest basketRequest);




    @Operation(
            summary = "Update the payment method of an basket",
            description = "Receives a valid Id and an payment method and search for the Basket, if that Basket exists update with the payment method"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Basket not found"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Return the updated basket whith the required id"
    )
    ResponseEntity<Basket> payBasket(@PathVariable String id, @RequestBody PaymentRequest paymentRequest);



    @Operation(
            summary = "Delete an opened basket",
            description = "Receives a valid Id  and search for the Basket, if that Basket exists delete it"
    )
    @ApiResponse(
            responseCode = "404",
            description = "Basket not found"
    )
    @ApiResponse(
            responseCode = "204",
            description = "The basket was deleted"
    )
    ResponseEntity<Void> deleteBasketById(@PathVariable String id);
}
