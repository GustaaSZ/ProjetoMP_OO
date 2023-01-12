package controller;

import static model.Musica.musicasCadastradas;

import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

import model.Artista;
import model.Musica;
import model.LetraMusica;
import static util.Conversor.stringToDate;
import java.text.ParseException;

public class MusicaController {

	private final Musica musica;
	
	// construtor
	public MusicaController(Musica musica) {
		this.musica = musica;
	}
	
	// Métodos de Edição do CRUD
	
	//------------------ FUNÇÃO DE ADD ARTISTA NA MUSICA --------------------
	
	public boolean adicionarArtista(Artista artista) {
		
		/*
		 * contains(): Ele serve para você verificar se na sua Collection
		 *  (o teu ArrayList) possui um determinado elemento
		*/
		
		// Se o artista já existir ao tentar add ele, será mostrada a seguinte mensagem
		
		if(musica.getArtistas().contains(artista)) {
			System.out.println("Artista ja cadastrado!");
			return false;
		}
		
		// Add o artista á musica
		musica.getArtistas().add(artista);
		
		// add a musica no artista
		artista.getMusicas().add(musica);
		return true;
	}
	
//	---------------------------------------------------------------
	
	public boolean adicionarArtista(ArrayList<Artista> artistas) {
		
		//musica nao pode ter artista repetido
		for (Artista artista : artistas) {
			if (musica.getArtistas().contains(artista)) {
				return false;
			}
		}
		musica.getArtistas().addAll(artistas);
		for (Artista artista : artistas) {
			artista.getMusicas().add(musica);
		}
		return true;
	}
	
			
	//------------------- FUNÇÃO DE REMOVER ARTISTA DA MUSICA ---------------------
			
	public void removerArtista(Artista artista) {
		
		// Lendo todos os artistas que estão cadastrados á determinada musica, se esse artista n for encontrado...
		
		if(!musica.getArtistas().contains(artista)) {
			
			System.out.println("Artista Nao Cadastrado!");
            return;
		}
		// remove artista da musica
		musica.getArtistas().remove(artista);
		
		// remove musica do artista
		artista.getMusicas().remove(musica);
	}
	
	//------------------- FUNÇÃO DE ATT MUSICA ---------------------
	
	public void atualizarMusica(String nome, String genero, String lancamento, String letra) {
		try {
		this.musica.setNome(nome);
		this.musica.setGenero(genero);
		this.musica.setLancamento(stringToDate(lancamento));
		this.musica.getletra().setLetra(new LetraMusica(letra).getLetra());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	//------------------- FUNÇÃO DE LISTAR ARTISTAS---------------------
	
	public void listarArtistas() {
		
		System.out.println("--------------------------------------------------");
        System.out.println("Artistas da musica " + musica.getNome() + ":");
        
        // 
        for (Artista artista : musica.getArtistas()) {
        	
            System.out.println(artista);
        }
        System.out.println("--------------------------------------------------");
	}
	
//	---------------------------------------------------------------
	
	// Método de editar nome da Musica
	
	public void editarNome(String nome) {
		musica.setNome(nome);
	}
	
	// Método de editar letra da Musica
	
	public void editarLetra(String letra) {
		musica.getletra().setLetra(letra);
	}
	
	// Método que retorna a quantidade de artistas
	
	public int quantidadeArtistas(Artista artista) {
		return musica.getArtistas().size();
	}
	
	// Método que permite o usuário fazer uma busca pelo artita atrávez de um caracter
	public int indexArtista(Artista artista) {
		
		//Método indexOf – Permite localizar a primeira ocorrência de uma sequência de caracteres em uma string...
        return musica.getArtistas().indexOf(artista);
    }

    public Artista buscarArtistaPorIndex(int index) {
        return musica.getArtistas().get(index);
    }
	
    // ---------------- METODOS ESTATICOS ----------------
    
    //Manipulando as musicas 
    
    public static boolean removerMusica(Musica musica) {
    	
    	// Se ao tentar remover a musica, e ela não estiver cadastrada...
    	if(!musicaExiste(musica)) {
    		System.out.println("Musica Nao Cadastrada!");
            return false;
    	}
    	// removendo a musica
    	musicasCadastradas.remove(musica);
        System.out.println("Musica Removida");
        return true;
    }
    
    // FUNÇÃO DE LISTAR AS MUSICAS
    
//    public static void buscarMusicaPorNome() {
//        for (Musica value : musicasCadastradas) {
//            System.out.println(value);
//        }
//    }

    public static void listarTodasMusicasCadastradas() {
		for (Musica value : musicasCadastradas) {
			System.out.println(value);
		}
	}
    
    public static Musica buscarMusicaPorNome(String nome) {
    	
        for (Musica value : musicasCadastradas) {
            if (Objects.equals(value.getNome(), nome)) {
//                System.out.println(value);
                return value;
            }
        }
        JOptionPane.showMessageDialog(null, "Não foi possível encontrar a música!");
		return null;
    }

    
    private static Boolean musicaExiste(Musica musica) {
        for (Musica value : musicasCadastradas) {
            if (Objects.equals(musica, value)) {
                return true;
            }
        }
        return false;
    }
    
}

