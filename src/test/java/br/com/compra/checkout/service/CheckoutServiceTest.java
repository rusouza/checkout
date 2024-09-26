package br.com.compra.checkout.service;

import br.com.compra.checkout.entity.Checkout;
import br.com.compra.checkout.enums.StatusCheckout;
import br.com.compra.checkout.repository.CheckoutRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CheckoutServiceTest {

    public static final Long ID = 3L;
    public static final String ITEM_1 = "item1";
    public static final String ITEM_2 = "item2";
    public static final String NOME_CLIENTE = "Cliente Teste";
    public static final BigDecimal VALOR_TOTAL = BigDecimal.valueOf(100.0);

    @InjectMocks
    private CheckoutService service;

    @Mock
    private CheckoutRepository repository;

    private Checkout checkout;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);

        checkout = new Checkout();
        checkout.setId(ID);
        checkout.setItens(Arrays.asList(ITEM_1, ITEM_2));
        checkout.setNomeCliente(NOME_CLIENTE);
        checkout.setValorTotal(VALOR_TOTAL);
        checkout.setStatus(StatusCheckout.PENDENTE);
    }

    @Test
    void whenInsertThenReturnSucess() {
        when(repository.save(any(Checkout.class))).thenReturn(checkout);

        Checkout response = service.iniciarCheckout(checkout);
        assertNotNull(response);
        assertEquals(Checkout.class, response.getClass());
        assertEquals(NOME_CLIENTE, response.getNomeCliente());
        assertEquals(VALOR_TOTAL, response.getValorTotal());
        assertEquals(StatusCheckout.PENDENTE, response.getStatus());
    }
}