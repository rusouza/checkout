package br.com.compra.checkout.entity;

import br.com.compra.checkout.enums.StatusCheckout;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkouts")
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> itens;

    private String nomeCliente;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusCheckout status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        return Objects.equals(id, checkout.id) && Objects.equals(itens, checkout.itens) && Objects.equals(nomeCliente, checkout.nomeCliente) && Objects.equals(valorTotal, checkout.valorTotal) && Objects.equals(status, checkout.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itens, nomeCliente, valorTotal, status);
    }
}
