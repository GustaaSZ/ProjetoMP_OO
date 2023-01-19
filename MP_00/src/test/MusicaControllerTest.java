/*package test;

import main.controller.ArtistaController;
import main.controller.MusicaController;
import main.model.Musica;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static main.util.Instanciacao.instanciar;
import static org.junit.jupiter.api.Assertions.*;

class MusicaControllerTest{
    @Test
    void buscarMusicaPorNome() {
        instanciar();
        String nome = "exemplo musica nao cadastrada";
        Musica result = MusicaController.buscarMusicaPorNome(nome);
        assertNull(result);
    }

    @Test
    void removerMusica() {
        boolean result = MusicaController.removerMusica(
                new Musica("cadastrando musica", "aaaaaa","genero",  new Date())
        );
        assertTrue(result);
    }

    @Test
    void adicionarArtista() {
        instanciar();
        MusicaController musicaController = new MusicaController(MusicaController.buscarMusicaPorNome("Quieto"));
        boolean result = musicaController.adicionarArtista(ArtistaController.buscarArtistaPorNome("Leviano"));
        assertFalse(result);
    }
}*/