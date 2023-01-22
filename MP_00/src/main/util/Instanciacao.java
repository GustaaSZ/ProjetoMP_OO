package main.util;

import main.controller.OuvinteController;
import main.controller.PlaylistController;
import main.model.Artista;
import main.model.Musica;
import main.model.Ouvinte;
import main.model.Playlist;

import java.util.ArrayList;
import java.util.Date;

public class Instanciacao {

    private static ArrayList<String> letras = new ArrayList<>();
    public static void instanciar() {

        letras = letras();

        Artista artista1 = new Artista("Djonga");
        Artista artista2 = new Artista("Froid");
        Artista artista3 = new Artista("Veigh");
        Artista artista4 = new Artista("Yunk Vino");
        Artista artista5 = new Artista("Kyan");
        Artista artista6 = new Artista("Leviano");

        Musica musica1 = new Musica(artista1, "O Mundo é Nosso", letras.get(0), "Rap", new Date());
        Musica musica2 = new Musica(artista2, "Peita de dar Rolê", letras.get(1), "Rap", new Date());
        Musica musica3 = new Musica(artista3, "Mil Maneiras", letras.get(2), "Trap", new Date());
        Musica musica4 = new Musica(artista4, "237", letras.get(3), "Trap", new Date());
        Musica musica5 = new Musica(artista5, "Mandrake", letras.get(4), "Drill", new Date());
        Musica musica6 = new Musica(artista6, "Quieto", letras.get(5), "Trap", new Date());

        Playlist playlist1 = new Playlist("Rap", "Descrição 1");

        PlaylistController controller1 = new PlaylistController(playlist1);

        controller1.adicionarMusica(musica1);
        controller1.adicionarMusica(musica2);
        controller1.adicionarMusica(musica3);

        Playlist playlist2 = new Playlist("Rock", "Descrição 2");
        Playlist playlist3 = new Playlist("Samba", "Descrição 3");
        PlaylistController controller2 = new PlaylistController(playlist2);

        controller2.adicionarMusica(musica4);
        controller2.adicionarMusica(musica5);
        controller2.adicionarMusica(musica6);

        Ouvinte ouvinte1 = new Ouvinte("Joãozinho");
        Ouvinte ouvinte2 = new Ouvinte("Maria");
        Ouvinte ouvinte3 = new Ouvinte("Pedro");

        OuvinteController ouvinteController1 = new OuvinteController(ouvinte1);
        OuvinteController ouvinteController2 = new OuvinteController(ouvinte2);
        OuvinteController ouvinteController3 = new OuvinteController(ouvinte3);

        ouvinteController1.adicionarPlaylist(playlist1);
        ouvinteController1.adicionarPlaylist(playlist2);

        ouvinteController2.adicionarPlaylist(playlist1);
        ouvinteController2.adicionarPlaylist(playlist3);

        ouvinteController3.adicionarPlaylist(playlist2);
        ouvinteController3.adicionarPlaylist(playlist3);
    }

    private static ArrayList<String> letras() {


        letras.add(
                """
                Homem negro, inferno branco, tipo Tarantino
                Homem branco, inferno banto, tipo tá tirano
                Os menor tá desesperado, tipo atirando
                Eu querendo salvar o mundo, e ela pergunta "'tá zuando?"
                É que as ruas me lembram o Massacre da Serra Elétrica
                Eles tentam roubar, é o massacre da cerca elétrica
                E o rap preocupa com o povo ou preocupa com a métrica
                Mas os tentáculos do polvo é o que vai me afundar
                E o olho que me julga precisa fazer regime
                Ou algum de nós dois vai estar lá na cena do crime
                E eu só querendo eu e minha mina na fila do cine
                Vendo o filme da minha vitória
                Sou da sua raça, mano, é a nossa vitória
                Já foram farsa, vamo, contar nossa história
                Quilombos, favelas, do futuro seremos reis, Charles
                Seremos a negra mais linda desse baile charme
                A negra velha mais sábia, crianças a chave
                Eles são cadeado, já foram corrente, sabe?
                O lado negro da força, mato com meu sabre
                Te corto com meu sabre
                Como se fosse a noite, 'cê vê tudo preto
                Como fosse um blackout, 'cê vê tudo preto
                São meus manos, minhas minas
                Meus irmãos, minhas irmãs, yeah
                O mundo é nosso, hã
                Tipo a noite, 'cê vê tudo preto
                Tipo um blackout, 'cê vê tudo preto
                São cantos de esquinas, de reis e rainhas
                Yeah, o mundo é nosso
                Já disse, pretos no topo, e eu falava sério
                Tipo BK, me veja como exemplo
                Minha quebrada na merda, minha city fora do mapa, mano
                Pros meus irmão eu sou exemplo, não nasci branco
                Para ser franco, não nasci blanco
                Mesmo assim a Paty quer sentar
                Sou elétrico, tenho em mim a resistência
                Sou DV Afrotribo pondo fim na concorrência
                Ganhar dinheiro tipo Cassino de Scorsese
                Gastar dinheiro tipo 'até que a sorte nos separe'
                Manos se drogam, pensam até que a morte nos ampare
                E a bola de cristal do boy é a taça de Campari
                E o morro chora, desespero e ainda tem barro lá
                Prefeito diz "Senhor é meu pastor, mas nada te asfaltará
                Tudo te faltará, se comprometerá
                Pra consumir doses de alegria, e não pagará"
                É o Homem na Estrada de todo dia
                E sabe a resposta, o que é clara e salgada
                Os mais novo vive queimando largada
                Não sabe ler nem escrever, e sabe o nome da delegada
                Sejamos Abraham Lincoln, independência
                Com a pele de Barack Obama
                Sejamos Tupac Shakur, Afeni Shakur
                Achemos a cura pra nossa insegurança
                Cada bala de fuzil é uma lágrima de Oxalá
                Mas na rua né não, na mão dos cana né não
                Na cintura era um celular e eles confundem com um oitão
                Como se fosse a noite, 'cê vê tudo preto
                Como fosse um blackout, 'cê vê tudo preto
                São meus manos, minhas minas
                Meus irmãos, minhas irmãs, yeah
                O mundo é nosso, hã
                Tipo a noite, 'cê vê tudo preto
                Tipo um blackout, 'cê vê tudo preto
                São cantos de esquinas, de reis e rainhas
                Yeah, o mundo é nosso
                """
                );
        letras.add("""
                Você nunca atende, você é maluca
                Mas você nunca me atende
                Você é maluca e me entende
                Você é a única que vai ganhar música
                Da minha pessoa pública daqui pra frente
                Mas você nunca me atende
                Você é maluca e me entende
                Você é a única que vai ganhar música
                Da minha pessoa pública daqui pra frente
                Misturo fogo com gasolina, tô sem minha peita de dar rolê
                Volto sem peita, eu deixei com a mina, tá com meu cheiro pra tu saber
                Minha camiseta é a favorita, então você tem que me devolver
                Tá com meu cheiro na axila, Vitória, eu sei qual é o seu segredo
                Mano, um dia eu fui na Diesel, o Derek disse pra eu não usar listra
                Briso amarelo porque combina, algo bem quente num dia cinza
                Toda essa moda é tão relativa, antes da grana eu pegava mina
                Com a minha camisa da Maresia, o que ela quer é adrenalina
                Eu tenho um carro, já tive moto, foda-se o topo
                Não tô por falar quando eu entoco
                Não dá pra falar que eu não me importo
                Você é linda, me via em foto, tem uma vírgula no seu corpo
                Sei que elas dizem que eu não sou santo, eu tô aqui pra botar um ponto
                Lembra de mim no primeiro encontro?
                Sei que eu mudei, 'cê num sabe o quanto
                Mas eu ainda sou o que canto, por isso me encontrou por todo canto
                É pra você que eu trampo, mas eu preciso de um sindicato
                Acho que ainda sou só um sujeito, essa canção é meu predicado
                Mas você nunca me atende
                Você é maluca e me entende
                Você é a única que vai ganhar música
                Da minha pessoa pública daqui pra frente
                Mas você nunca me atende
                Você é maluca e me entende
                Você é a única que vai ganhar música
                Da minha pessoa pública daqui pra frente
                E-e-e-e-ei
                Eu dividi a capa do jornal com a Björk, eu só pude ler no day off
                Eletros do meu carro no poste, todos querem a chave do cofre
                A polícia não confia nos jovens, os jovens não confiam em ninguém
                Nós somos rebeldes
                Dormi na sua casa de novo, eu sei, você precisa de alguém
                Me dê mais remédios, me conte segredos, jovens não confiam em ninguém
                A era do medo
                Quem me disse foi um bebo no trem, ninguém acredita no bem
                O mal não é mais um agente secreto, amar é pros fortes
                Amargo, massa, gado, sorte, o sol, o sal, tua vida, longa vida boa
                Chega dessa vida dupla, vida adulta, vida cobra, o tempo leva
                Toda dor embora, tenho ótimas notícias, péssimas memórias
                Boas histórias são tristes, boas histórias são
                A gente existe por obrigação e ainda insiste numa ligação
                Que você nunca atende, você é maluca, me entende
                Única""");
        letras.add("É preciso passar pela escuridão, pra apreciar o nascer do sol\n" +
                "Que a maldade não me atinja, que a inveja reflita no ouro do cordão\n" +
                "Inimigos eu sei, tenho alguns, se me odeiam, sem ressentimentos\n" +
                "Cada um oferece oque tem, de boas intenções o inferno tá cheio\n" +
                "Pela brecha da porta eu vejo\n" +
                "Mil motivos de fazer dinheiro\n" +
                "Mil maneiras de ficar famoso\n" +
                "Mas nada é de graça tudo tem um preço\n" +
                "Rodeado de falsos amores\n" +
                "Querendo sugar do pouco que eu tenho\n" +
                "Mas o pouco, com Deus, sempre é muito, né\n" +
                "Cê entendeu ou quer que eu desenho\n" +
                "Noites em claro só pensamentos, gasolina nóis' que divida\n" +
                "Dentre situações de tormento, mãe eu vou te tirar dessa vida\n" +
                "Um sorriso no rosto da Lyllian, o Ryan vai tá forte, de fato\n" +
                "Vai andar só com peça da moda, o tênis do mais foda e com 18 um carro\n" +
                "O menino que saiu do morro\n" +
                "Em busca do tesouro, jovem milionário\n" +
                "O menino que saiu do morro\n" +
                "Ahn, futuro milionário\n" +
                "É preciso passar pela escuridão, pra apreciar o nascer do sol\n" +
                "Que a maldade não me atinja, que a inveja reflita no ouro do cordão\n" +
                "Inimigos eu sei, tenho alguns, se me odeiam, sem ressentimentos\n" +
                "Cada um oferece o que tem, de boas intenções o inferno tá cheio\n" +
                "Não temerás espanto noturno, nem seta que voe de dia\n" +
                "Nem peste que ande na escuridão\n" +
                "Nem a mortandade que assole ao meio-dia\n" +
                "Mil cairão ao teu lado, e dez mil à tua direita\n" +
                "Mas tu jamais serás atingido\n" +
                "Ahn, futuro milionário\n" +
                "O menino que saiu do morro\n" +
                "Em busca do tesouro, jovem milionário\n" +
                "O menino que saiu do morro\n" +
                "Ahn, futuro milionário\n" +
                "O menino que saiu do morro\n" +
                "Em busca do tesouro, jovem milionário\n" +
                "O menino que saiu do morro\n" +
                "Ahn, futuro milionário");
        letras.add("""
                Yeah, yeah
                Baby, yeah, yeah, yeah, yeah
                Yeah-eah-eah
                Baby, yeah, yeah

                Shawty, call me, look me
                Just sippin' that drink
                Yeah, 237 on my neck (on my neck, baby)
                237 on my neck (on my neck, baby)
                Okay, forget me but trust me
                Mas sei que sabe que isso não é de hoje
                Yeah, 237 on my neck (on my neck, baby)
                237 on my neck (on my neck, baby)

                Leve igual Promethazine, me levou de mim (alright, alright)
                Me tire de mim, eu já não tô aguentando mais (mais, mais)
                Lean on lean around me, Percs e codeine (all night, night, night)
                Levo dentro do meu jeans só droga toda white (white, white)
                Te guardei dentro da caixa do meu milli (milli)
                Lady, you so pretty
                Tudo com você me lembra um filme (filme, filme)
                Até quando eu conto a porra do fino

                Shawty, call me, look me
                Just sippin' that drink
                Yeah, 237 on my neck (on my neck, baby)
                237 on my neck (on my neck, baby)
                Okay, forget me but trust me
                Mas sei que sabe que isso não é de hoje
                Yeah, 237 on my neck (on my neck, baby)
                237 on my neck (on my neck, baby)

                54, isso tá me fazendo mal
                Sei, isso foi há uns meses, mas não sinto não
                Tattoos na minha face pra aliviar o caos
                Armas no meu basement já virou normal
                Bitches querem, babies já querem ir no meu pau
                Bounce, throw your ass on me
                Quero te sentir
                Será o apocalipse?
                Fica aqui

                Just call me, look me
                Just sippin' that drink
                Yeah, 237 on my neck (on my neck, baby)
                237 on my neck (on my neck)
                Okay, forget me but trust me
                Mas sei que sabe que isso não é de hoje
                Yeah, 237 on my neck (on my neck, baby)
                237 on my neck (on my neck, baby)""");
        letras.add("""
                O papo é reto, pra depois falar que não avisou
                Vai rolar o funk, não se empolga
                Não dá tiro, que vai ser esculachado, hein

                Moleque Mandrake, dia de baile
                Vamo cair pra pista e voltar de transalp
                Ela gosta de bandido e de nave
                O Oito na cinta, no olhar a maldade
                No jet cavernoso, sem capa cabuloso
                Vou dar tapa na bunda, pra vê se ela late
                Cordão no pescoço, no peito tá o croco
                Bandido periculoso e disso elas sabe
                Pede pra ser assumida, quer ser minha bandida

                Me viu de 66, disse que eu sou o toque
                Calmô, filha! Você tá na fila
                Tem várias puta, querendo tá no nome
                Então faz por onde, entra na disputa
                Rebola no baile, me ganha com sua bunda
                Quer ser minha Bonnie, então me escuta
                Me chupa dando fuga dos rocambole
                Tirado de bandido, é porque fiz por onde
                Quando vê atravessa a rua e esconde o telefone
                Neguinho sagaz, que não tinha estudo
                E você quando me vê, esconde a bolsa e a filha junto

                Não fujo do conflito, muito menos do perigo
                Amante do dinheiro e da foda sem compromisso
                Preto bandido, nos kit eu tô breck
                Nike, Lacoste, sem camisa e Ap Vest
                Fica interessante quando você vê o cash
                Sente atração com os menó de juliet
                Boné de lado, beca jogada
                Pensar em nóis te deixa molhada
                Preto bandido, nos kit eu tô breck
                Nike, Lacoste, sem camisa e Ap Vest

                Fica interessante quando você vê o cash
                Sente atração com os menó de juliet
                Boné de lado, beca jogada
                Pensar em nóis te deixa molhada
                Boné de lado, beca jogada
                Pensar em nóis te deixa (prrr)
                Boné de lado, beca jogada
                Pensar em nóis te deixa molhada
                Boné de lado, beca jogada
                Pensar em nóis te deixa molhada

                Boné de lado, beca jogada
                Te deixa molhada""");
        letras.add("""
                Vários caído traiu
                Por isso eu fico esperto (sempre)
                Na internet ele é barril
                Na vida real, ele é quieto
                Os federais sempre por perto
                Por isso que eu mantenho a minha gang no certo (ha-ha)
                Jogo essa festa no teto
                Eu sou o cara que abastece-tece (Molly)

                Sempre correndo da PETO, eu faço cash e a minha conta cresce (só cresce)
                Nego, eu vim do inferno, acostumado a situações de estresse (no, eeh)
                Pingentão de concreto, azul e branco, igual um olho cego (ahn)
                Carro importado, eu pego, eu vim do tráfico, eu não minto, eu não nego (não)
                Pasta branca igual coco', baby, limpando igual colgate
                A buceta, a buceta branca dela igual rosé, igual bumbum de bebê
                Os mano' na quadra, mas não tão jogando basquete, eles tão fazendo o que?
                Criança na selva se identificando na net, eu mostro meu amor pra eles

                Vários caído traiu
                Por isso eu fico esperto (sempre)
                Na internet ele é barril
                Na vida real, ele é quieto (o que aconteceu? Ahn?)
                Os federais sempre por perto
                Por isso que eu mantenho a minha gang no certo (ha-ha)
                Jogo essa festa no teto
                Eu sou o cara que abastece-tece (Molly)

                Tu não sabe como é tá no corre
                Viradão até as nove
                Vendo viciado chegando fala teu nome
                Pode ser algum X9
                Alguém vai acabar morrendo por gritar "gang-gang"
                E esse alguém nem se envolve
                Mas ela tem a base de fazer essa grana
                Ela tem, ela não precisa de um homem (não, não)

                Meu crumble é igual manteiga (manteiga)
                Minha dona é igual uma pêra
                Na rua, na rua é muita treta, meu nego
                Mantenha a esperança acesa (aham)

                Tão quer dizer que tu tá com a seda, e tua mãe ainda tá na mesma? (Ah, não)
                Tão quer dizer que tu gasta a placa na festa sem nada na geladeira? (Ah, não)
                Era pra mim tá na cadeia (não hoje), se minha gata não fosse ligeira
                Ela viu a droga na mesa e se saiu com a droga na meia (perfeito)
                No canil meus cachorro tão preso, a liberdade tem um preço (eu pago)
                Tudo que eu quero alvarei, juro, tudo que eu quero eu tenho

                Vários caído traiu
                Por isso eu fico esperto (sempre)
                Na internet ele é barril
                Na vida real ele quieto (ahn?)
                Os federais sempre por perto
                Por isso que eu mantenho a minha gang no certo (ha-ha)
                Jogo essa festa no teto
                Eu sou o cara que abastece-tece""");
        letras.add("sdsdsd");




        return letras;
    }
}
