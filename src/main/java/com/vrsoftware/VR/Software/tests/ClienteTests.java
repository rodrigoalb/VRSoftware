package com.vrsoftware.VR.Software.tests;

import com.vrsoftware.VR.Software.entities.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteTests {

    @Test
    public void constructorShouldCreateObjectWhenValidData() {
        Long id = 1L;
        String codigo = "ABC123";
        String nome = "Cliente Teste";
        Double limiteCompra = 3000.00;
        Integer fechamentoFatura = 15;

        Cliente cliente = new Cliente(id, codigo, nome, limiteCompra, fechamentoFatura);

        Assertions.assertEquals(id, cliente.getId());
        Assertions.assertEquals(codigo, cliente.getCodigo());
        Assertions.assertEquals(nome, cliente.getNome());
        Assertions.assertEquals(limiteCompra, cliente.getLimiteCompra());
        Assertions.assertEquals(fechamentoFatura, cliente.getFechamentoFatura());
    }

    @Test
    void ConstructorShouldThrowIllegalArgumentExceptionWhenFechamentoFaturaIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(1L, "ABC123", "Cliente Teste", 1000.00, 32);
        });
    }

    @Test
    public void setIdShouldUpdateDataWhenValidData() {
        Cliente cliente = new Cliente();
        Long id = 2L;

        cliente.setId(id);

        Assertions.assertEquals(id, cliente.getId());
    }

    @Test
    public void setCodigoShouldUpdateDataWhenValidData() {
        Cliente cliente = new Cliente();
        String codigo = "XYZ789";

        cliente.setCodigo(codigo);

        Assertions.assertEquals(codigo, cliente.getCodigo());
    }

    @Test
    public void setNomeShouldUpdateDataWhenValidData() {
        Cliente cliente = new Cliente();
        String nome = "Cliente Atualizado";

        cliente.setNome(nome);

        Assertions.assertEquals(nome, cliente.getNome());
    }

    @Test
    public void setLimiteCompraShouldUpdateDataWhenValidData() {
        Cliente cliente = new Cliente();
        Double limiteCompra = 5000.00;

        cliente.setLimiteCompra(limiteCompra);

        Assertions.assertEquals(limiteCompra, cliente.getLimiteCompra());
    }

    @Test
    public void setFechamentoFaturaShouldUpdateDataWhenValidData() {
        Cliente cliente = new Cliente();
        Integer fechamentoFatura = 10;

        cliente.setFechamentoFatura(fechamentoFatura);

        Assertions.assertEquals(fechamentoFatura, cliente.getFechamentoFatura());
    }

    @Test
    public void getIdShouldReturnCorrectData() {
        Long id = 3L;
        Cliente cliente = new Cliente(id, "ABC123", "Cliente Teste", 4000.00, 25);

        Assertions.assertEquals(id, cliente.getId());
    }

    @Test
    public void getCodigoShouldReturnCorrectData() {
        String codigo = "DEF456";
        Cliente cliente = new Cliente(4L, codigo, "Cliente Teste", 4000.00, 25);

        Assertions.assertEquals(codigo, cliente.getCodigo());
    }

    @Test
    public void getNomeShouldReturnCorrectData() {
        String nome = "Cliente Teste";
        Cliente cliente = new Cliente(5L, "GHI789", nome, 4000.00, 25);

        Assertions.assertEquals(nome, cliente.getNome());
    }

    @Test
    public void getLimiteCompraShouldReturnCorrectData() {
        Double limiteCompra = 4000.00;
        Cliente cliente = new Cliente(6L, "JKL012", "Cliente Teste", limiteCompra, 25);

        Assertions.assertEquals(limiteCompra, cliente.getLimiteCompra());
    }

    @Test
    public void getFechamentoFaturaShouldReturnCorrectData() {
        Integer fechamentoFatura = 25;
        Cliente cliente = new Cliente(7L, "MNO345", "Cliente Teste", 4000.00, fechamentoFatura);

        Assertions.assertEquals(fechamentoFatura, cliente.getFechamentoFatura());
    }
}