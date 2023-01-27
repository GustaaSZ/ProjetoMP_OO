 package test;

 import main.controller.ArtistaController;
 import main.model.Artista;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

 import static main.util.Instanciacao.instanciar;
 import static org.junit.jupiter.api.Assertions.*;

 /**
  * Classe de testes para a classe ArtistaController
  */
 class ArtistaControllerTest {

     @BeforeEach
     void setUp() {
         instanciar();
     }

     /**
      * Testa o método buscarArtistaPorNome
      */
     @Test
     void buscarArtistaPorNome() {
         String artistaNaoCadastrado = "artista nao cadastrado";
         Artista result1 = ArtistaController.buscarArtistaPorNome(artistaNaoCadastrado);
         assertNull(result1);

         String artistaCadastrado = "Veigh";
         Artista result2 = ArtistaController.buscarArtistaPorNome(artistaCadastrado);
         assertEquals(artistaCadastrado, result2.getNome());
     }

        /**
        * Testa o método removerArtista
        */
     @Test
     void removerArtista() {
         boolean result = ArtistaController.removerArtistaCadastrado(
                 ArtistaController.buscarArtistaPorNome("Veigh")
         );
         assertFalse(result);
     }
 }