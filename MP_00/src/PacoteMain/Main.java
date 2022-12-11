package PacoteMain;
import java.util.ArrayList;
import java.util.Scanner;

import PacoteClasses.Artista;
import PacoteClasses.Dupla;
import PacoteClasses.Musica;
import PacoteClasses.Playlist;

public class Main {

public static void main(String[] args) {
		
		// Atributo usado apenas na classe princial
		int opcao = 0;
		
		// Criano o objeto ler
		Scanner ler = new Scanner(System.in);
		
		ArrayList<Artista> artistasCadastrados = new ArrayList<>();
		ArrayList<Dupla> duplasCadastradas = new ArrayList<>();
		
		// Menu de opções:
		do {
			
			System.out.println("1) Cadastrar Artista.");
			System.out.println("2) Cadastrar Dupla.");
			System.out.println("3) Cadastrar Musica.");
			System.out.println("4) Cadastrar PlayList.");
			System.out.println("5) Listar Musicas.");
			System.out.println("6) Sair do Menu de Opcoes.");
			System.out.println("");
			
			System.out.println("Digite a Opcao desejada:");
			opcao = ler.nextInt();
			System.out.println("");
			switch(opcao) {
			
			case 1: // ARTISTA 
				
				ler.nextLine();
				// Criando o objeto artista1
				
				Artista artista = new Artista();
				
				// Obtendo os dados do Artista que herda atributos de Pessoa
				System.out.println("Digite seu nome:");
				artista.setNome(ler.nextLine());
				
				System.out.println("Digite sua idade: ");
				artista.setIdade(ler.nextInt());
				
				ler.nextLine();
				System.out.println("Digite a nacionalidade do artista: ");
				artista.setNacionalidade(ler.nextLine());
				
				System.out.println(artista.getNome()+", por fim, digite seu estilo musical:");
				artista.setEsiloMusical(ler.nextLine());
				
				artistasCadastrados.add(artista);
				
				System.out.println("");
				System.out.println("");
				
				// Listando os dados do Artista:
				System.out.println("Dados do artista "+artista.getNome());
				System.out.println("");
				System.out.println("Nome: "+artista.getNome());
				System.out.println("Idade: "+artista.getIdade());
				System.out.println("Nacionalidade: "+artista.getNacionalidade());
				System.out.println("Estilo Musical: "+artista.getEstiloMusical());
				System.out.println("");
				System.out.println("");
				
				break;
				
			case 2: // DUPLA

				// Criando o objeto dupla1
				Dupla dupla = new Dupla();
				
				// Obtendo os dados da Dupla que herda atributos de Pessoa
				ler.nextLine();
				System.out.println("Digite seu nome:");
				dupla.setNome(ler.nextLine());
				
				System.out.println("Digite sua idade "+dupla.getNome()+":");
				dupla.setIdade(ler.nextInt());
				
				ler.nextLine();
				
				System.out.println("Digite sua nacionalidade "+dupla.getNome()+":");
				dupla.setNacionalidade(ler.nextLine());
				
				System.out.println("Digite o nome da sua dupla "+dupla.getNome()+":");
				dupla.setNomeDupla(ler.nextLine());
				
				System.out.println("Digite sua idade "+dupla.getNomeDupla()+":");
				dupla.setIdadeDupla(ler.nextInt());
				
				ler.nextLine();
				
				System.out.println("Digite sua nacionalidade "+dupla.getNomeDupla()+":");
				dupla.setNacionalidadeDupla(ler.nextLine());
				
				System.out.println("Por fim, digite o estilo Musical da dupla:");
				dupla.setEstiloMusicalDupla(ler.nextLine());
				
				duplasCadastradas.add(dupla);
				
				// Listando os dados da Dupla:
				
				System.out.println("Dados da Dupla "+dupla.getNome()+" e "+dupla.getNomeDupla());
				System.out.println("");
				System.out.println("Nome: "+dupla.getNome()+" e "+dupla.getNomeDupla());
				System.out.println("* Idade \n- "+dupla.getNome()+": "+dupla.getIdade()+"\n - "+dupla.getNomeDupla()+": "+dupla.getIdadeDupla());
				System.out.println("* Nacionalidade \n- "+dupla.getNome()+": "+dupla.getNacionalidade()+"\n-"+dupla.getNomeDupla()+": "+dupla.getNacionalidadeDupla());
				System.out.println("Estilo Musical: "+dupla.getEstiloMusicalDupla());
				System.out.println("");
				System.out.println("");
				
				break;
				
			case 3: // MUSICA

				if (artistasCadastrados.size() == 0 && duplasCadastradas.size() == 0) {
					System.out.println("Nao existe nenhum artista ou dupla cadastrada!");
					System.out.println("");
					break;
				}
				
				String op;
				String nome;
				boolean verifica = false;
				
				System.out.println("BEM VINDO AO SISTEMA DE CADASTRO DE MUSICA!\n");
				
				//-------------- Criando o objeto musica1 da Classe Musica ----------------------
				
				Musica musica = new Musica();

				// Obtendo os dados da musica
				ler.nextLine();
				System.out.println("Digite o nome da Musica:");
				musica.setNomeMusica(ler.nextLine());
				
				System.out.println("Qual o genero da Musica "+ musica.getNomeMusica()+"?");
				musica.setGeneroMusica(ler.nextLine());
				
				System.out.println("Digite a letra da musica "+ musica.getNomeMusica()+":");
				musica.setLetra(ler.nextLine());
				
				System.out.println("Qual a data de lancamento da musica "+ musica.getNomeMusica()+"?");
				musica.setLancamento(ler.nextLine());
				
				do {
					System.out.println("Adicionar musica para um artista ou uma dupla? (A/D)");
					op = ler.nextLine();
					
					if (op.equalsIgnoreCase("a")) {
						
						System.out.println("Para qual artista deseja cadastrar a musica?");
						nome = ler.nextLine();
						
						for (Artista art : artistasCadastrados) {
							
							if (nome.equalsIgnoreCase(art.getNome())) {
								
								musica.adicionarArtista(art);
								art.adicionarMusica(musica);
								verifica = true;
								
								break;
							}
						}
						
					} else if (op.equalsIgnoreCase("d")) {
						
						System.out.println("Para qual dupla deseja cadastrar a musica?");
						nome = ler.nextLine();
						
						for (Dupla dup : duplasCadastradas) {
							
							if (nome.equalsIgnoreCase(dup.getNome()+" e "+dup.getNomeDupla())) {
								
								musica.adicionarDupla(dup);
								dup.adicionarMusica(musica);
								verifica = true;
								break;
								
							}
						}
						
					} else {
						
						System.out.println("Insira uma opcao valida (A/D)");
					}
						
				}while(!verifica);
				
				// Listando as Musicas
				
				System.out.println("");
				System.out.println("MUSICA CADASTRADA:\n");
				System.out.println("Nome: "+musica.getNomeMusica());
				System.out.println("");
				System.out.println("");
				
				break;
				
				
			case 4:// PLAYLIST
				
				if (artistasCadastrados.size() == 0 && duplasCadastradas.size() == 0) {
					
					System.out.println("Nao existe nenhum artista ou dupla cadastrada!");
					System.out.println("");
					break;
				}
				
				verifica = false;
				String nomeMusica;
				
				// Instanciando o objeto playlist1 da classe Playlist
				Playlist playlist = new Playlist();
				
				// Obtendo os dados de playlist
				ler.nextLine();
				System.out.println("Digite o nome da Playlist:");
				playlist.setNomePlaylist(ler.nextLine());
				
				do {
					System.out.println("Adicionar musica de um artista ou uma dupla? (A/D)");
					op = ler.nextLine();
					
					if (op.equalsIgnoreCase("a")) {
						
						System.out.println("De qual artista deseja adicionar uma musica na playlist?");
						String nomeArtista = ler.nextLine();
						
						for (Artista art : artistasCadastrados) {
							
							if (nomeArtista.equalsIgnoreCase(art.getNome())){
								
								System.out.println("Qual musica do artista " + art.getNome()+"?");
								nomeMusica = ler.nextLine();
								
								for (Musica mus : art.getMusicas()) {
									
									if (mus.getNomeMusica().equalsIgnoreCase(nomeMusica)) {
										
										playlist.adicionarMusica(mus);
										verifica = true;
										break;
									}
								}
								
							}
						}
						
					} else if (op.equalsIgnoreCase("d")) {
						
						System.out.println("De qual dupla deseja adicionar uma musica na playlist?");
						String nomeDupla = ler.nextLine();
						
						for (Dupla dup : duplasCadastradas) {
							
							if (nomeDupla.equalsIgnoreCase(dup.getNome()+ " e "+dup.getNomeDupla() )){
								
								System.out.println("Qual musica da dupla " + dup.getNome()+" e "+dup.getNomeDupla()+"?");
								nomeMusica = ler.nextLine();
								
								for (Musica mus : dup.getMusicas()) {
									
									if (mus.getNomeMusica().equalsIgnoreCase(nomeMusica)) {
										
										playlist.adicionarMusica(mus);
										verifica = true;
										break;
									}
								}
								
							}
						}
					} else {
						System.out.println("Insira uma opcao valida (A/D)");
					}
						
				}while(!verifica);
				
				
				System.out.println("");
				break;
				
			case 5: 
				
				if (artistasCadastrados.size() == 0 && duplasCadastradas.size() == 0) {
					
					System.out.println("Nao existe nenhum artista ou dupla cadastrada!");
					System.out.println("");
					break;
				}
				
				int i;
				
				if (artistasCadastrados.size() > 0) {
					System.out.println("Lista de artistas e suas musicas:");
					System.out.println("");
					for (Artista art : artistasCadastrados) {
						
						i = 1;
						System.out.println(i+ ") " + art.getNome()+ ":");
						art.listarMusicas();
						System.out.println("");
						System.out.println("");
						i++;
					}
				}
				
				if (duplasCadastradas.size() > 0) {
					
					System.out.println("Lista de duplas e suas musicas:");
					System.out.println("");
					
					for (Dupla dup : duplasCadastradas) {
						
						i = 1;
						System.out.println(i+ ") " +dup.getNome()+" e "+ dup.getNomeDupla()+ ":");
						dup.listarMusicas();
						System.out.println("");
						System.out.println("");
						i++;
						
					}
				}
				
				
				break;
			case 6: // Sair do Menu
				
				System.out.println("Obrigado por visitar o site Letras e Musicas.");
				
				break;
				
			default:
				System.out.println("Opcao invalida, tente novamente!");
			}
				
			
		}while(opcao != 6);
		
		ler.close();
	}
	
	
}
