package br.com.compra.checkout.controller;

import br.com.compra.checkout.entity.Checkout;
import br.com.compra.checkout.enums.StatusCheckout;
import br.com.compra.checkout.service.CheckoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Checkout")
@RestController
@RequestMapping(value = "api/checkouts")
public class CheckoutController {

    @Autowired
    private CheckoutService service;

    @Operation(summary = "Buscar todos os checkouts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Checkout.class))
            })
    })
    @GetMapping
    public ResponseEntity<List<Checkout>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }

    @Operation(summary = "Criar um novo checkout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Checkout criado com sucesso", content = {
                    @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Checkout.class))
            })
    })
    @PostMapping
    public ResponseEntity<Checkout> criarCheckout(@RequestBody Checkout checkout) {
        checkout.setStatus(StatusCheckout.PENDENTE);
        Checkout checkoutCriado = service.iniciarCheckout(checkout);
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutCriado);
    }
}
