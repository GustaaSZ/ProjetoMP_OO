 package test;

 import main.controller.ArtistaController;
 import main.controller.MusicaController;
 import main.model.Musica;
 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.Test;

 import java.util.Date;

 import static main.util.Instanciacao.instanciar;
 import static org.junit.jupiter.api.Assertions.*;

    /**
    * Classe de testes para a classe MusicaController
    */
 class MusicaControllerTest{

     @BeforeEach
     void setUp() {
         instanciar();
     }

     /**
      * Testa o método buscarMusicaPorNome
      */
     @Test
     void buscarMusicaPorNome() {
         String musicaNaoCadastrada = "Musica nao cadastrada";
         Musica result1 = MusicaController.buscarMusicaPorNome(musicaNaoCadastrada);
         assertNull(result1);

         String musicaCadastrada = "Quieto";
         Musica result2 = MusicaController.buscarMusicaPorNome(musicaCadastrada);
         assertEquals(musicaCadastrada, result2.getNome());
     }

        /**
        * Testa o método removerMusica
        */
     @Test
     void removerMusica() {
         boolean result = MusicaController.removerMusica(
                 new Musica("cadastrando musica", "aaaaaa","genero",  new Date())
         );
         assertTrue(result);
     }

        /**
        * Testa o método adicionarArtista
        */
     @Test
     void adicionarArtista() {
         MusicaController controller = new MusicaController(MusicaController.buscarMusicaPorNome("Quieto"));
         boolean result1 = controller.adicionarArtista(ArtistaController.buscarArtistaPorNome("Leviano"));
         assertFalse(result1);

         boolean result2 = controller.adicionarArtista(ArtistaController.buscarArtistaPorNome("Veigh"));
         assertTrue(result2);
     }
 }