package br.com.compra.checkout.service;

import br.com.compra.checkout.entity.Checkout;
import br.com.compra.checkout.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private CheckoutRepository repository;

    @Autowired
    public CheckoutService(CheckoutRepository repository) {
        this.repository = repository;
    }

    public Checkout iniciarCheckout(Checkout checkout) {
        return repository.save(checkout);
    }
}
