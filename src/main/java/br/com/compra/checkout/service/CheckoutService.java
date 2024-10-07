package br.com.compra.checkout.service;

import br.com.compra.checkout.entity.Checkout;
import br.com.compra.checkout.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    private CheckoutRepository repository;

    @Autowired
    public CheckoutService(CheckoutRepository repository) {
        this.repository = repository;
    }

    public List<Checkout> buscarTodos() {
        return repository.findAll();
    }

    public Checkout iniciarCheckout(Checkout checkout) {
        return repository.save(checkout);
    }
}
