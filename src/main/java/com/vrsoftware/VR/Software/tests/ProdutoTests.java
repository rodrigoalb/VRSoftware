package com.vrsoftware.VR.Software.tests;

import com.vrsoftware.VR.Software.entities.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTests {

    @Test
    void ConstructorShouldCreateProdutoWithValidData() {
        Produto produto = new Produto(1L, "001", "Produto Teste", 100.0);

        assertEquals(1L, produto.getId());
        assertEquals("001", produto.getCodigo());
        assertEquals("Produto Teste", produto.getDescricao());
        assertEquals(100.0, produto.getPreco());
    }

    @Test
    void ConstructorShouldThrowIllegalArgumentExceptionWhenPrecoIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto(1L, "001", "Produto Teste", -100.0);
        });
    }

    @Test
    void ConstructorShouldThrowIllegalArgumentExceptionWhenCodigoIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto(1L, null, "Produto Teste", 100.0);
        });
    }

    @Test
    void ConstructorShouldThrowIllegalArgumentExceptionWhenDescricaoIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Produto(1L, "001", null, 100.0);
        });
    }
}