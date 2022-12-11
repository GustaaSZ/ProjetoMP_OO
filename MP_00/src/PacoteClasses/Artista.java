package PacoteClasses;
import java.util.ArrayList;


public class Artista extends Pessoa {

	// Atributo
	
	private String estiloMusical;
	
	// Como um Artista pode ter nenhuma ou várias musicas, pegamos uma lista de musicas e colocamos na classe Artista
	private ArrayList<Musica> musicas;
	
	// Encapsulamento do atributo:
	
	public String getEstiloMusical() {
		
		return estiloMusical;
	}
	
	public void setEsiloMusical(String estiloMusical) {
		
		this.estiloMusical = estiloMusical;
	}

	/* 
	 * Criando o método construtor da classe Artista, assim, quando um artista for criado, criamos também uma lista de musicas :
	*/
	public Artista() {
		musicas = new ArrayList<Musica>();
	}
	
	
	//------------------------- Manipulando a lista de musicas na classe Artista: -----------------------------
	
	//1º
	public void adicionarMusica(Musica musica) {
		// add musica
		musicas.add(musica);
	}
	
	//2º
	public int quantidadeMusicas() {
		// Retorna a quantidade de musicas
		return musicas.size();
	}
	
	//3º
	public void excluirMusica(Musica musica) {
		// exclui musica
		musicas.remove(musica);
	}
	
	//4º
	public Musica getMusica(int posicao) {
		// Retorna as musicas de cada posição
		return musicas.get(posicao);
	}
	
	public ArrayList<Musica> getMusicas() {
		return musicas;
	}
	
	public void listarMusicas() {
		for (Musica musica : musicas) {
			System.out.println(musica.getNomeMusica());
		}
	}
}
