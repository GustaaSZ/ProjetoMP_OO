// package test;

// import main.controller.ArtistaController;
// import main.controller.MusicaController;
// import main.model.Musica;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import java.util.Date;

// import static main.controller.Instanciacao.instanciar;
// import static org.junit.jupiter.api.Assertions.*;

// class MusicaControllerTest{

//     @BeforeEach
//     void setUp() {
//         instanciar();
//     }

//     @Test
//     void buscarMusicaPorNome() {
//         String musicaNaoCadastrada = "Musica nao cadastrada";
//         Musica result1 = MusicaController.buscarMusicaPorNome(musicaNaoCadastrada);
//         assertNull(result1);

//         String musicaCadastrada = "Quieto";
//         Musica result2 = MusicaController.buscarMusicaPorNome(musicaCadastrada);
//         assertEquals(musicaCadastrada, result2.getNome());
//     }

//     @Test
//     void removerMusica() {
//         boolean result = MusicaController.removerMusica(
//                 new Musica("cadastrando musica", "aaaaaa","genero",  new Date())
//         );
//         assertTrue(result);
//     }

//     @Test
//     void adicionarArtista() {
//         MusicaController musicaController = new MusicaController(MusicaController.buscarMusicaPorNome("Quieto"));
//         boolean result1 = musicaController.adicionarArtista(ArtistaController.buscarArtistaPorNome("Leviano"));
//         assertFalse(result1);

//         boolean result2 = musicaController.adicionarArtista(ArtistaController.buscarArtistaPorNome("Veigh"));
//         assertTrue(result2);
//     }
// }