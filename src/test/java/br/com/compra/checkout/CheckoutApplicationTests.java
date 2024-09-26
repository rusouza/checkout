package br.com.compra.checkout;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CheckoutApplicationTests {

	@Test
	void contextLoads() {
		String test = "Iniciando Teste...";
		assertEquals("Iniciando Teste...", test);
	}

}