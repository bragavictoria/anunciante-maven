package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteProdutoBean {

    private ProdutoBean produtoA;
    private ProdutoBean produtoB;

    public void setUp() {
        produtoA = new ProdutoBean("A001", "Produto A", "Descrição do Produto A", 100.0, "SP");
        produtoB = new ProdutoBean("B002", "Produto B", "Descrição do Produto B", 50.0, "RJ");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("A001", produtoA.getCodigo());
        assertEquals("Produto A", produtoA.getNome());
        assertEquals("Descrição do Produto A", produtoA.getDescricao());
        assertEquals(100.0, produtoA.getValor());
        assertEquals("SP", produtoA.getEstado());

        produtoA.setCodigo("A002");
        assertEquals("A002", produtoA.getCodigo());

        produtoA.setNome("Novo Nome");
        assertEquals("Novo Nome", produtoA.getNome());

        produtoA.setDescricao("Nova Descrição");
        assertEquals("Nova Descrição", produtoA.getDescricao());

        produtoA.setValor(200.0);
        assertEquals(200.0, produtoA.getValor());

        produtoA.setEstado("RS");
        assertEquals("RS", produtoA.getEstado());
    }

    @Test
    public void testCompareTo() {
        ProdutoBean produtoA = new ProdutoBean("A001", "Produto A", "Descrição A", 100.0, "SP");
        ProdutoBean produtoB = new ProdutoBean("B002", "Produto B", "Descrição B", 50.0, "RJ");
        ProdutoBean produtoC = new ProdutoBean("C003", "Produto C", "Descrição C", 150.0, "MG");

        assertTrue(produtoA.compareTo(produtoB) > 0);  // Produto A tem valor 100.0 e Produto B tem valor 50.0
        assertTrue(produtoB.compareTo(produtoA) < 0);  // Produto B tem valor 50.0 e Produto A tem valor 100.0
        assertEquals(0, produtoA.compareTo(produtoA)); // Produto A deve ser igual a ele mesmo

        assertTrue(produtoC.compareTo(produtoA) > 0);  // Produto C tem valor 150.0 e Produto A tem valor 100.0
        assertTrue(produtoA.compareTo(produtoC) < 0);  // Produto A tem valor 100.0 e Produto C tem valor 150.0
    }
}