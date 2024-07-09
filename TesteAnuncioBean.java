package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TesteAnuncioBean {

    private ProdutoBean produto;
    private ArrayList<URL> fotosUrl;
    private Double desconto;

    public void setUp() throws MalformedURLException {
        produto = new ProdutoBean("P001", "Produto Teste", "Descrição do Produto", 100.0, "SP");
        fotosUrl = new ArrayList<>();
        fotosUrl.add(new URL("http://example.com/foto1.jpg"));
        fotosUrl.add(new URL("http://example.com/foto2.jpg"));
        desconto = 0.2; // 20% de desconto
    }

    @Test
    public void testGetValor() {
        AnuncioBean anuncio = new AnuncioBean(produto, fotosUrl, desconto);

        // Valor esperado: 100.0 * (1 - 0.2) = 80.0
        assertEquals(80.0, anuncio.getValor());

        // Teste adicional para garantir que o valor do produto não seja alterado incorretamente
        assertEquals(100.0, produto.getValor());
    }
}