import br.unicamp.ic.inf335.beans.AnuncianteBean;
import br.unicamp.ic.inf335.beans.AnuncioBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteAnuncianteBean {

    private AnuncianteBean anunciante;
    private AnuncioBean anuncio1;
    private AnuncioBean anuncio2;

    public void setUp() {
        // Inicializa os anúncios
        anuncio1 = new AnuncioBean();
        anuncio1.setTitulo("Anúncio 1");
        anuncio1.setValor(100.0); // Exemplo de valor

        anuncio2 = new AnuncioBean();
        anuncio2.setTitulo("Anúncio 2");
        anuncio2.setValor(70.0); // Exemplo de valor

        // Cria a lista de anúncios e adiciona ao anunciante
        ArrayList<AnuncioBean> anuncios = new ArrayList<>();
        anuncios.add(anuncio1);
        anuncios.add(anuncio2);

        // Inicializa o anunciante com nome, CPF e a lista de anúncios
        anunciante = new AnuncianteBean("Fulano", "123456789", anuncios);
    }

    @Test
    public void testValorMedioAnuncios() {
        // Verificando o tamanho da lista de anúncios (deve ser 2, conforme configurado no setUp)
        assertEquals(2, anunciante.getAnuncios().size());

        // Calculando o valor médio usando o anunciante configurado no setUp
        double expected = 85.0; // Valor médio esperado
        double actual = anunciante.valorMedioAnuncios();

        assertEquals(expected, actual, 0.001); // Comparando com uma precisão de 0.001
    }}