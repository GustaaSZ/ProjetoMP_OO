package PacoteMain;
import java.util.Date;
import java.util.Scanner;

import PacoteClasses.Artista;
import PacoteClasses.Dupla;
import PacoteClasses.Musica;
import PacoteClasses.Pessoa;
import PacoteClasses.Playlist;

public class Main {

	public static void main(String[] args) {
		
		// Atributo usado apenas na classe princial
		int opcao = 0;
		
		// Criano o objeto ler
		Scanner ler = new Scanner(System.in);
		
		// Criano o objeto ler a Opção digitada pelo usuário
		Scanner lerOpcao = new Scanner(System.in);
		
		// Menu de opções:
		do {
			
			System.out.println("1) Cadastrar Artista e Musica.");
			System.out.println("2) Cadastrar Dupla e Musica.");
			System.out.println("3) Cadastrar Musica.");
			System.out.println("4) Cadastrar PlayList e Musica.");
			System.out.println("5) Sair do Menu de Opções.");
			System.out.println("");
			
			System.out.println("Digite a Opção desejada:");
			opcao = lerOpcao.nextInt();
			System.out.println("");
			
			switch(opcao) {
			
			case 1: // ARTISTA E MUSICA
				
				// Criano o objeto lerArtista
				Scanner lerA = new Scanner(System.in);
				
				// Criando o objeto artista1
				
				Artista artista1 = new Artista();
				
				// Obtendo os dados do Artista que herda atributos de Pessoa
				
				System.out.println("Digite seu nome:");
				artista1.setNome(lerA.nextLine());
				
				System.out.println("Digite sua idade "+artista1.getNome()+":");
				artista1.setIdade(lerA.nextInt());
				
				System.out.println("Digite sua nacionalidade: "+artista1.getNome());
				artista1.setNacionalidade(lerA.next());
				
				System.out.println(artista1.getNome()+" ,por fim, digite seu estilo Musical");
				artista1.setEsiloMusical(lerA.next());
				
				//-------------- Criando o objeto musica1 da Classe Musica ----------------------
				
				Musica musica1 = new Musica();

				// Obtendo os dados da musica1
				
				System.out.println("Digite o nome da Musica:");
				musica1.setNomeMusica(lerA.next());
				
				System.out.println("Qual o genero da Musica? "+musica1.getNomeMusica());
				musica1.setGeneroMusica(lerA.next());
				
				System.out.println("Digite a letra da musica: "+musica1.getNomeMusica());
				musica1.setLetra(lerA.next());
				
				System.out.println("Qual a data de lançamento da musica: "+musica1.getNomeMusica());
				musica1.setLancamento(lerA.next());
				
				
				//----------------- Criando o objeto musica2 da Classe Musica --------------------
				
				Musica musica2 = new Musica();

				// Obtendo os dados da musica2
				
				System.out.println("Digite o nome da Musica:");
				musica2.setNomeMusica(lerA.next());
				
				System.out.println("Qual o genero da Musica? "+musica2.getNomeMusica());
				musica2.setGeneroMusica(lerA.next());
				
				System.out.println("Digite a letra da musica: "+musica2.getNomeMusica());
				musica2.setLetra(lerA.next());
				
				System.out.println("Qual a data de lançamento da musica: "+musica2.getNomeMusica());
				musica2.setLancamento(lerA.next());
				
				
				// Adicionando as musicas á lista artistas e o artista na Lista de Musicas
				artista1.adicionarMusica(musica1);
				artista1.adicionarMusica(musica2);
				
				musica1.adicionarArtista(artista1);
				musica2.adicionarArtista(artista1);
				
				// Listando os dados do Artista:
				System.out.println("Dados do artista "+artista1.getNome());
				System.out.println("");
				System.out.println("Nome: "+artista1.getNome());
				System.out.println("Idade: "+artista1.getIdade());
				System.out.println("Nacionalidade: "+artista1.getNacionalidade());
				System.out.println("Estilo Musical: "+artista1.getEstiloMusical());
				System.out.println("");
				System.out.println("Musicas do Artista "+artista1.getNome());
				System.out.println("");
				/* 
				 * Estrutura de repetição que vai printar na tela as musicas pertencentes ao artista1
				   Para isso definimos um contador que vai percorrer a quantidade de alunos e logo
				   depois vai imprimir o nome do aluno da posição i, até chegar a quantidade de alunos cadastrados.
				 */
				
				for(int i = 0; i < artista1.quantidadeMusicas(); i++) {
					System.out.println(artista1.getMusica(i).getNomeMusica());
				}
				
				System.out.println("");
				System.out.println("Artistas que fizeram a musica "+musica1.getNomeMusica()+" e a musica "+musica2.getNomeMusica());
				System.out.println("");
				
				/* 
				 * Estrutura de repetição que vai printar na tela as musicas pertencentes ao artista1
				   Para isso definimos um contador que vai percorrer a quantidade de alunos e logo
				   depois vai imprimir o nome do aluno da posição i, até chegar a quantidade de alunos cadastrados.
				 */
				
				for(int i = 0; i < musica1.quantidadeArtistas() && i < musica2.quantidadeArtistas(); i++) {
					System.out.println(musica1.getArtista(i).getNome());
					System.out.println(musica2.getArtista(i).getNome());
				}
				System.out.println("");
				
				break;
				
			case 2: // DUPLA E MUSICA
				
				// Criano o objeto lerDupla
				Scanner lerD = new Scanner(System.in);
				
				// Criando o objeto dupla1
				Dupla dupla1 = new Dupla();
				
				// Obtendo os dados da Dupla que herda atributos de Pessoa
				
				System.out.println("Digite seu nome:");
				dupla1.setNome(lerD.next());
				
				System.out.println("Digite sua idade "+dupla1.getNome()+":");
				dupla1.setIdade(lerD.nextInt());
				
				System.out.println("Digite sua nacionalidade "+dupla1.getNome()+":");
				dupla1.setNacionalidade(lerD.next());
				
				System.out.println("Digite o nome da sua dupla "+dupla1.getNome()+":");
				dupla1.setNomeDupla(lerD.next());
				
				System.out.println("Digite sua idade "+dupla1.getNomeDupla()+":");
				dupla1.setIdadeDupla(lerD.nextInt());
				
				System.out.println("Digite sua nacionalidade "+dupla1.getNomeDupla()+":");
				dupla1.setNacionalidadeDupla(lerD.next());
				
				System.out.println("Por fim, digite o estilo Musical da dupla:");
				dupla1.setEstiloMusicalDupla(lerD.next());
				
				//-------------- Criando o objeto musica1 da Classe Musica ----------------------
				
				Musica musica1Dupla = new Musica();

				// Obtendo os dados da musica1Dupla
				
				System.out.println("Digite o nome da Musica:");
				musica1Dupla.setNomeMusica(lerD.next());
				
				System.out.println("Qual o genero da Musica "+musica1Dupla.getNomeMusica()+":");
				musica1Dupla.setGeneroMusica(lerD.next());
				
				System.out.println("Digite a letra da musica "+musica1Dupla.getNomeMusica()+":");
				musica1Dupla.setLetra(lerD.next());
				
				System.out.println("Qual a data de lançamento da musica "+musica1Dupla.getNomeMusica()+":");
				musica1Dupla.setLancamento(lerD.next());
				
				
				//----------------- Criando o objeto musica2Dupla da Classe Musica --------------------
				
				Musica musica2Dupla = new Musica();

				// Obtendo os dados da musica2Dupla
				
				System.out.println("Digite o nome da Musica:");
				musica2Dupla.setNomeMusica(lerD.next());
				
				System.out.println("Qual o genero da Musica "+musica2Dupla.getNomeMusica()+":");
				musica2Dupla.setGeneroMusica(lerD.next());
				
				//System.out.println("Digite a letra da musica: "+musica2Dupla.getNomeMusica());
				//musica2Dupla.setLetra(lerD.next());
				
				System.out.println("Letra da musica: "+musica2Dupla.getNomeMusica());
				
				musica2Dupla.setLetra("Moro num lugar\r\n"
						+ "Numa casinha inocente do sertão\r\n"
						+ "De fogo baixo aceso no fogão\r\n"
						+ "Fogão à lenha ai ai\r\n"
						+ "\r\n"
						+ "Tenho tudo aqui\r\n"
						+ "Umas vaquinha leiteira\r\n"
						+ "Um burro bão\r\n"
						+ "Uma baixada ribeira\r\n"
						+ "E um violão e umas galinha ai ai");
				
				System.out.println(musica2Dupla.getLetra());
				
				System.out.println("Qual a data de lançamento da musica "+musica2Dupla.getNomeMusica()+":");
				musica2Dupla.setLancamento(lerD.next());
				
				
				//----------------- Criando o objeto musica2Dupla da Classe Musica --------------------
				
				Musica musica3Dupla = new Musica();

				// Obtendo os dados da musica3Dupla
				
				System.out.println("Digite o nome da Musica:");
				musica3Dupla.setNomeMusica(lerD.next());
				
				System.out.println("Qual o genero da Musica "+musica3Dupla.getNomeMusica()+":");
				musica3Dupla.setGeneroMusica(lerD.next());
				
				System.out.println("Digite a letra da musica "+musica3Dupla.getNomeMusica()+":");
				musica3Dupla.setLetra(lerD.next());
				
				System.out.println("Qual a data de lançamento da musica "+musica3Dupla.getNomeMusica()+":");
				musica3Dupla.setLancamento(lerD.next());
				
				
				// Adicionando as musicas á lista de duplas e a dupla na Lista de Musicas
				
				dupla1.adicionarMusica(musica1Dupla);
				dupla1.adicionarMusica(musica2Dupla);
				dupla1.adicionarMusica(musica3Dupla);
				
				musica1Dupla.adicionarDupla(dupla1);
				musica2Dupla.adicionarDupla(dupla1);
				musica3Dupla.adicionarDupla(dupla1);
				
				// Listando os dados da Dupla:
				
				System.out.println("Dados da Dupla "+dupla1.getNome()+" e "+dupla1.getNomeDupla());
				System.out.println("");
				System.out.println("Nome: "+dupla1.getNome()+" e "+dupla1.getNomeDupla());
				System.out.println("* Idade \n- "+dupla1.getNome()+": "+dupla1.getIdade()+"\n- "+dupla1.getNomeDupla()+": "+dupla1.getIdadeDupla());
				System.out.println("* Nacionalidade \n- "+dupla1.getNome()+": "+dupla1.getNacionalidade()+"\n-"+dupla1.getNomeDupla()+": "+dupla1.getNacionalidadeDupla());
				System.out.println("Estilo Musical: "+dupla1.getEstiloMusicalDupla());
				System.out.println("");
				System.out.println("Musicas da Dupla "+dupla1.getNome()+" e "+dupla1.getNomeDupla()+":");
				System.out.println("");
				
				/* 
				 * Estrutura de repetição que vai printar na tela as musicas pertencentes a dupla1
				   Para isso definimos um contador que vai percorrer a quantidade de musicas e logo
				   depois vai imprimir o nome da musica da posição i, até chegar a quantidade de musicas cadastradas.
				 */
				
				for(int i = 0; i < dupla1.quantidadeMusicas(); i++) {
					
					System.out.println(dupla1.getMusica(i).getNomeMusica());
				}
				
				System.out.println("");
				System.out.println("Duplas que fizeram as Musicas "+musica1Dupla.getNomeMusica()+", a musica "+musica2Dupla.getNomeMusica()+" e a musica "+musica3Dupla.getNomeMusica());
				System.out.println("");
				
				/* 
				 * Estrutura de repetição que vai printar na tela as duplas pertencentes as duplas
				   Para isso definimos um contador que vai percorrer a quantidade de duplas e logo
				   depois vai imprimir o nome da dupla na posição i, até chegar a quantidade de duplas cadastradas.
				 */
				
				for(int i = 0; i < musica1Dupla.quantidadeDuplas(); i++) {
					
					System.out.println("Nome: "+musica1Dupla.getDupla(i).getNomeDupla());
					
				}
				System.out.println("");
				
				for(int i = 0; i < musica2Dupla.quantidadeDuplas(); i++) {
					
					System.out.println("Nome: "+musica2Dupla.getDupla(i).getNome()+" e "+dupla1.getNomeDupla());
					
				}
				System.out.println("");
				
				for(int i = 0; i < musica3Dupla.quantidadeDuplas(); i++) {
					
					System.out.println("Nome: "+musica3Dupla.getDupla(i).getNomeDupla());
					
				}
				System.out.println("");
				
				break;
				
				
				
			case 3: // MUSICA
				
				// Criano o objeto lerMusica
				Scanner lerM = new Scanner(System.in);
				
				System.out.println("BEM VINDO AO SISTEMA DE CADASTRO DE MUSICA!\n");
				
				//-------------- Criando o objeto musica1 da Classe Musica ----------------------
				
				Musica musica11 = new Musica();

				// Obtendo os dados da musica1
				
				System.out.println("Digite o nome da Musica:");
				musica11.setNomeMusica(lerM.next());
				
				System.out.println("Qual o genero da Musica? "+musica11.getNomeMusica());
				musica11.setGeneroMusica(lerM.next());
				
				//System.out.println("Digite a letra da musica: "+musica11.getNomeMusica());
				//System.out.println("Letra da musica: "+musica11.getNomeMusica());
				musica11.setLetra("Moro num lugar\r\n"
						+ "Numa casinha inocente do sertão\r\n"
						+ "De fogo baixo aceso no fogão\r\n"
						+ "Fogão à lenha ai ai\r\n"
						+ "\r\n"
						+ "Tenho tudo aqui\r\n"
						+ "Umas vaquinha leiteira\r\n"
						+ "Um burro bão\r\n"
						+ "Uma baixada ribeira\r\n"
						+ "E um violão e umas galinha ai ai");
				
				System.out.println("Qual a data de lançamento da musica: "+musica11.getNomeMusica());
				musica11.setLancamento(lerM.next());
				
				
				//----------------- Criando o objeto musica2 da Classe Musica --------------------
				
				Musica musica21 = new Musica();

				// Obtendo os dados da musica2
				
				System.out.println("Digite o nome da Musica:");
				musica21.setNomeMusica(lerM.next());
				
				System.out.println("Qual o genero da Musica? "+musica21.getNomeMusica());
				musica21.setGeneroMusica(lerM.next());
				
				//System.out.println("Digite a letra da musica: "+musica21.getNomeMusica());
				//System.out.println("Letra da musica: "+musica21.getNomeMusica());
				musica21.setLetra("Fada, fada querida\r\n"
						+ "Dona da minha vida\r\n"
						+ "Você se foi\r\n"
						+ "Levou meu calor\r\n"
						+ "Você se foi, mas não me levou\r\n"
						+ "\r\n"
						+ "Lua, lua de encanto\r\n"
						+ "Ouça pra quem eu canto\r\n"
						+ "Ela levou minha magia\r\n"
						+ "Mas ela é minha alegria\r\n"
						+ "\r\n"
						+ "Vejo uma luz, uma estrela brilhar\r\n"
						+ "Sinto um cheiro de perfume no ar\r\n"
						+ "Vejo minha fada e sua vara de condão\r\n"
						+ "Tocando meu coração");
				
				System.out.println("Qual a data de lançamento da musica: "+musica21.getNomeMusica());
				musica21.setLancamento(lerM.next());
				
				
				//------------------- Criando o objeto musica3 da Classe Musica -------------------
				
				Musica musica3 = new Musica();

				// Obtendo os dados da musica3
				
				System.out.println("Digite o nome da Musica:");
				musica3.setNomeMusica(lerM.next());
				
				System.out.println("Qual o genero da Musica? "+musica3.getNomeMusica());
				musica3.setGeneroMusica(lerM.next());
				
				//System.out.println("Digite a letra da musica: "+musica3.getNomeMusica());
				//System.out.println("letra da musica: "+musica3.getNomeMusica());
				musica3.setLetra("Nunca vi ninguém\r\n"
						+ "Viver tão feliz\r\n"
						+ "Como eu no sertão\r\n"
						+ "\r\n"
						+ "Perto de uma mata\r\n"
						+ "E de um ribeirão\r\n"
						+ "Deus e eu no sertão\r\n"
						+ "\r\n"
						+ "Casa simplesinha\r\n"
						+ "Rede pra dormir\r\n"
						+ "De noite, um show no céu\r\n"
						+ "Deito pra assistir\r\n"
						+ "\r\n"
						+ "Deus e eu no sertão\r\n"
						+ "\r\n"
						+ "Das horas, não sei\r\n"
						+ "Mas vejo o clarão\r\n"
						+ "Lá vou eu cuidar do chão\r\n"
						+ "\r\n"
						+ "Trabalho cantando\r\n"
						+ "A terra é a inspiração\r\n"
						+ "Deus e eu no sertão\r\n"
						+ "\r\n"
						+ "Não há solidão\r\n"
						+ "Tem festa lá na vila\r\n"
						+ "Depois da missa, vou\r\n"
						+ "Ver minha menina\r\n"
						+ "\r\n"
						+ "De volta pra casa\r\n"
						+ "Queima a lenha no fogão\r\n"
						+ "E junto ao som da mata\r\n"
						+ "Vou eu e um violão\r\n"
						+ "\r\n"
						+ "Deus e eu no sertão\r\n"
						+ "Deus e eu no sertão\r\n"
						+ "Deus e eu no sertão\r\n"
						+ "Deus e eu no sertão");
				
				System.out.println("Qual a data de lançamento da musica: "+musica3.getNomeMusica());
				musica3.setLancamento(lerM.next());
				
				//------------------- Criando o objeto musica4 da Classe Musica -------------------
				
				Musica musica4 = new Musica();

				// Obtendo os dados da musica3
				
				System.out.println("Digite o nome da Musica:");
				musica4.setNomeMusica(lerM.next());
				
				System.out.println("Qual o genero da Musica? "+musica4.getNomeMusica());
				musica4.setGeneroMusica(lerM.next());
				
				//System.out.println("Digite a letra da musica: "+musica4.getNomeMusica());
				//System.out.println("Letra da musica: "+musica4.getNomeMusica());
				musica4.setLetra("Percebo que o tempo já não passa\r\n"
						+ "Você diz que não tem graça amar assim\r\n"
						+ "Foi tudo tão bonito, mas voou pro infinito\r\n"
						+ "Parecido com borboletas de um jardim\r\n"
						+ "\r\n"
						+ "Agora você volta\r\n"
						+ "E balança o que eu sentia por outro alguém\r\n"
						+ "Dividido entre dois mundos\r\n"
						+ "Sei que estou amando, mas ainda não sei quem\r\n"
						+ "\r\n"
						+ "Não sei dizer o que mudou\r\n"
						+ "Mas nada está igual\r\n"
						+ "Numa noite estranha a gente se estranha e fica mal\r\n"
						+ "Você tenta provar que tudo em nós morreu\r\n"
						+ "Borboletas sempre voltam\r\n"
						+ "E o seu jardim sou eu\r\n"
						+ "\r\n"
						+ "Percebo que o tempo já não passa\r\n"
						+ "Você diz que não tem graça amar assim\r\n"
						+ "Foi tudo tão bonito, mas voou pro infinito\r\n"
						+ "Parecido com borboletas de um jardim\r\n"
						+ "\r\n"
						+ "Agora você volta\r\n"
						+ "E balança o que eu sentia por outro alguém\r\n"
						+ "Dividido entre dois mundos\r\n"
						+ "Sei que estou amando, mas ainda não sei quem\r\n"
						+ "\r\n"
						+ "Não sei dizer o que mudou\r\n"
						+ "Mas, nada está igual\r\n"
						+ "Numa noite estranha a gente se estranha e fica mal\r\n"
						+ "Você tenta provar que tudo em nós morreu\r\n"
						+ "Borboletas sempre voltam\r\n"
						+ "E o seu jardim sou eu\r\n"
						+ "\r\n"
						+ "Não sei dizer o que mudou\r\n"
						+ "Mas nada está igual\r\n"
						+ "Numa noite estranha a gente se estranha e fica mal\r\n"
						+ "Você tenta provar que tudo em nós morreu\r\n"
						+ "Borboletas sempre voltam\r\n"
						+ "E o seu jardim sou eu\r\n"
						+ "\r\n"
						+ "Sempre voltam\r\n"
						+ "E o seu jardim sou eu");
				
				System.out.println("Qual a data de lançamento da musica: "+musica4.getNomeMusica());
				musica4.setLancamento(lerM.next());
				
				// Listando as Musicas
				
				System.out.println("");
				System.out.println("MÚSICAS CADASTRADAS:\n");
				System.out.println("Nome: "+musica11.getNomeMusica()+"\n\nLetra: "+musica11.getLetra());
				System.out.println("");
				System.out.println("Nome: "+musica21.getNomeMusica()+"\n\nLetra: "+musica21.getLetra());
				System.out.println("");
				System.out.println("Nome: "+musica3.getNomeMusica()+"\n\nLetra: "+musica3.getLetra());
				System.out.println("");
				System.out.println("Nome: "+musica4.getNomeMusica()+"\n\nLetra: "+musica4.getLetra());
				System.out.println("");
				
				break;
				
				
			case 4:// PLAYLIST
				
				// Instanciando o objeto lerP (Ler Playlist) da classe Scanner:
				Scanner lerP = new Scanner(System.in);
				
				// Instanciando o objeto playlist1 da classe Playlist
				Playlist playlist1 = new Playlist();
				
				// Obtendo os dados de playlist
				System.out.println("Digite o nome da Playlist:");
				playlist1.setNomePlaylist(lerP.next());
				
				
				//-------------- Criando o objeto musica3 da Classe Musica ----------------------
				
				Musica musica1Play = new Musica();

				// Obtendo os dados da musica1
				
				System.out.println("Digite o nome da Musica:");
				musica1Play.setNomeMusica(lerP.next());
				
				System.out.println("Qual o genero da Musica? "+musica1Play.getNomeMusica());
				musica1Play.setGeneroMusica(lerP.next());
				
				System.out.println("Digite a letra da musica: "+musica1Play.getNomeMusica());
				musica1Play.setLetra(lerP.next());
				
				System.out.println("Qual a data de lançamento da musica "+musica1Play.getNomeMusica()+":");
				musica1Play.setLancamento(lerP.next());
				
				
				//----------------- Criando o objeto musica2 da Classe Musica --------------------
				
				Musica musica2Play = new Musica();

				// Obtendo os dados da musica2
				
				System.out.println("Digite o nome da Musica:");
				musica2Play.setNomeMusica(lerP.next());
				
				System.out.println("Qual o genero da Musica? "+musica2Play.getNomeMusica());
				musica2Play.setGeneroMusica(lerP.next());
				
				System.out.println("Digite a letra da musica: "+musica2Play.getNomeMusica());
				musica2Play.setLetra(lerP.next());
				
				System.out.println("Qual a data de lançamento da musica "+musica2Play.getNomeMusica()+":");
				musica2Play.setLancamento(lerP.next());
				
				
				//------------------- Criando o objeto musica3 da Classe Musica -------------------
				
				Musica musica3Play = new Musica();

				// Obtendo os dados da musica3
				
				System.out.println("Digite o nome da Musica:");
				musica3Play.setNomeMusica(lerP.next());
				
				System.out.println("Qual o genero da Musica? "+musica3Play.getNomeMusica());
				musica3Play.setGeneroMusica(lerP.next());
				
				System.out.println("Digite a letra da musica: "+musica3Play.getNomeMusica());
				musica3Play.setLetra(lerP.next());
				
				System.out.println("Qual a data de lançamento da musica "+musica3Play.getNomeMusica()+":");
				musica3Play.setLancamento(lerP.next());
				
				//------------------- Criando o objeto musica4 da Classe Musica -------------------
				
				Musica musica4Play = new Musica();

				// Obtendo os dados da musica3
				
				System.out.println("Digite o nome da Musica:");
				musica4Play.setNomeMusica(lerP.next());
				
				System.out.println("Qual o genero da Musica? "+musica4Play.getNomeMusica());
				musica4Play.setGeneroMusica(lerP.next());
				
				System.out.println("Digite a letra da musica: "+musica4Play.getNomeMusica());
				musica4Play.setLetra(lerP.next());
				
				System.out.println("Qual a data de lançamento da musica "+musica4Play.getNomeMusica()+":");
				musica4Play.setLancamento(lerP.next());
				
				// Adicionando as musicas á Playlist1 e a playlist1 nas musicas
				
				playlist1.adicionarMusica(musica1Play);
				playlist1.adicionarMusica(musica2Play);
				playlist1.adicionarMusica(musica3Play);
				playlist1.adicionarMusica(musica4Play);
				
				musica1Play.adicionarPlaylist(playlist1);
				musica2Play.adicionarPlaylist(playlist1);
				musica3Play.adicionarPlaylist(playlist1);
				musica4Play.adicionarPlaylist(playlist1);
				
				// Listando as musicas da Playlist1:
				
				System.out.println("MUSICAS DA PLAYLIST "+playlist1.getNomePlaylist());
				System.out.println("");
				
				/* 
				   Estrutura de repetição que vai printar na tela as musicas da playlist1.
				   Para isso definimos um contador que vai percorrer a quantidade de musicas e logo
				   depois vai imprimir o nome da musica da posição i, até chegar a quantidade de musicas cadastradas.
				 */
				
				for(int i = 0; i < playlist1.quantidadeMusicas(); i++) {
					
					System.out.println("Nome: "+playlist1.getMusica(i).getNomeMusica());
				}
				
				//--------------- Listando as playlists das musicas --------------- :
				
				System.out.println("\nPLAYLIST DA MUSICA "+musica1Play.getNomeMusica());
				System.out.println("");
				
				/* 
				   Estrutura de repetição que vai printar na tela as musicas da playlist1.
				   Para isso definimos um contador que vai percorrer a quantidade de musicas e logo
				   depois vai imprimir o nome da musica da posição i, até chegar a quantidade de musicas cadastradas.
				 */
				
				for(int i = 0; i < musica1Play.quantidadePlaylists(); i++) {
					
					System.out.println(musica1Play.getPlaylist(i).getNomePlaylist());
				}
				
				System.out.println("");
				System.out.println("PLAYLIST DA MUSICA "+musica2Play.getNomeMusica());
				System.out.println("");
				
				
				for(int i = 0; i < musica2Play.quantidadePlaylists(); i++) {
					
					System.out.println(musica2Play.getPlaylist(i).getNomePlaylist());
				}
				
				System.out.println("");
				System.out.println("PLAYLIST DA MUSICA "+musica3Play.getNomeMusica());
				System.out.println("");
				
				
				for(int i = 0; i < musica3Play.quantidadePlaylists(); i++) {
					
					System.out.println(musica3Play.getPlaylist(i).getNomePlaylist());
				}
				
				System.out.println("");
				System.out.println("PLAYLIST DA MUSICA "+musica4Play.getNomeMusica());
				System.out.println("");
				
				
				for(int i = 0; i < musica4Play.quantidadePlaylists(); i++) {
					
					System.out.println(musica4Play.getPlaylist(i).getNomePlaylist());
				}
				System.out.println("");
				break;
				
			case 5: // Sair do Menu
				
				System.out.println("Obrigado por visitar o site Letras e Musicas.");
				
				break;
				
			}
			
		}while(opcao != 5);
		
		
	}
	
}
