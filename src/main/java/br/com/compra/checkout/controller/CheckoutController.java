package br.com.compra.checkout.controller;

import br.com.compra.checkout.entity.Checkout;
import br.com.compra.checkout.enums.StatusCheckout;
import br.com.compra.checkout.service.CheckoutService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/checkouts")
public class CheckoutController {

    @Autowired
    private CheckoutService service;

    @Tag(name = "Criar Checkout")
    @PostMapping
    public ResponseEntity<Checkout> criarCheckout(@RequestBody Checkout checkout) {
        checkout.setStatus(StatusCheckout.PENDENTE);
        Checkout checkoutCriado = service.iniciarCheckout(checkout);
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutCriado);
    }
}
