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

        Artista artista7 = new Artista("ColdPlay");
        Artista artista8 = new Artista("Chris Brown");
        Artista artista9 = new Artista("Jorge Aragão");
        Artista artista10 = new Artista("Grupo Revelação");
        Artista artista11 = new Artista("Raça Negra");

        Musica musica1 = new Musica(artista1, "O Mundo é Nosso", letras.get(0), "Rap", new Date());
        Musica musica2 = new Musica(artista2, "Peita de dar Rolê", letras.get(1), "Rap", new Date());
        Musica musica3 = new Musica(artista3, "Mil Maneiras", letras.get(2), "Trap", new Date());
        Musica musica4 = new Musica(artista4, "237", letras.get(3), "Trap", new Date());
        Musica musica5 = new Musica(artista5, "Mandrake", letras.get(4), "Drill", new Date());
        Musica musica6 = new Musica(artista6, "Quieto", letras.get(5), "Trap", new Date());
        
        Musica musica7 = new Musica(artista7, "Magic",letras.get(6), "Rock alternativo", new Date());
        Musica musica8 = new Musica(artista7, "Clocks",letras.get(7), "Rock alternativo", new Date());
        Musica musica9 = new Musica(artista8, "Under The Influence",letras.get(8), "R&B/soul", new Date());
        Musica musica10 = new Musica(artista9, "Eu e você Sempre", letras.get(9), "Samba", new Date());
        Musica musica11 = new Musica(artista10, "Coração Radiante", letras.get(10), "Samba", new Date());
        Musica musica12 = new Musica(artista10, "Deixa Acontecer", letras.get(11), "Samba", new Date());
        Musica musica13 = new Musica(artista11, "É Tarde Demais", letras.get(12), "Samba", new Date());

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

        Playlist playlist4 = new Playlist("Internacionais", "Playlist com Musicas internacionais");
        PlaylistController controller3 = new PlaylistController(playlist4);

        controller3.adicionarMusica(musica7);
        controller3.adicionarMusica(musica8);
        controller3.adicionarMusica(musica9);


        PlaylistController controller4 = new PlaylistController(playlist3);
        controller4.adicionarMusica(musica10);  
        controller4.adicionarMusica(musica11); 
        controller4.adicionarMusica(musica12); 
        controller4.adicionarMusica(musica13);     

        Ouvinte ouvinte1 = new Ouvinte("Joãozinho");
        Ouvinte ouvinte2 = new Ouvinte("Maria");
        Ouvinte ouvinte3 = new Ouvinte("Pedro");
        Ouvinte ouvinte4 = new Ouvinte("Gustavo");
        Ouvinte ouvinte5 = new Ouvinte("Felipe");

        OuvinteController ouvinteController1 = new OuvinteController(ouvinte1);
        OuvinteController ouvinteController2 = new OuvinteController(ouvinte2);
        OuvinteController ouvinteController3 = new OuvinteController(ouvinte3);
        OuvinteController ouvinteController4 = new OuvinteController(ouvinte4);
        OuvinteController ouvinteController5 = new OuvinteController(ouvinte5);

        ouvinteController1.adicionarPlaylist(playlist1);
        ouvinteController1.adicionarPlaylist(playlist2);

        ouvinteController2.adicionarPlaylist(playlist1);
        ouvinteController2.adicionarPlaylist(playlist3);

        ouvinteController3.adicionarPlaylist(playlist2);
        ouvinteController3.adicionarPlaylist(playlist3);

        ouvinteController4.adicionarPlaylist(playlist4);
        ouvinteController4.adicionarPlaylist(playlist3);

        ouvinteController5.adicionarPlaylist(playlist3);
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
        
        
        letras.add("""
                Call it magic
                Call it true
                I call it magic
                When I'm with you

                And I just got broken
                Broken into two
                Still I call it magic
                When I'm next to you

                And I don't, and I don't, and I don't, and I don't
                No, I don't, it's true
                I don't, no, I don't, no, I don't, no, I don't
                Want anybody else but you

                I don't, no, I don't, no, I don't, no, I don't
                No, I don't, it's true
                I don't, no, I don't, no, I don't, no, I don't
                Want anybody else but you
                (Ooh, ooh)

                Call it magic
                Cut me into two
                And with all your magic
                I disappear from view

                And I can't get over
                Can't get over you
                Still I call it magic
                Such a precious jewel

                And I don't, and I don't, and I don't, and I don't
                No, I don't, it's true
                I don't, no, I don't, no, I don't, no, I don't
                Want anybody else but you

                I don't, no, I don't, no, I don't, no, I don't
                No, I don't, it's true
                I don't, no, I don't, no, I don't, no, I don't
                Want anybody else but you

                Wanna fall
                I fall so far
                I wanna fall
                I fall so hard

                And I call it magic
                And I call it true
                I call it ma-ma-ma-magic

                Ooh, ooh
                Ooh, ooh
                Ooh, ooh
                Ooh, ooh

                And if you were to ask me
                After all that we've been through
                Still believe in magic?
                Oh, yes, I do

                Oh, yes, I do
                Oh, yes, I do
                Oh, yes, I do
                Of course, I do""");

        letras.add("""
                Lights go out and I can't be saved
                Tides that I tried to swim against
                Have brought me down upon my knees
                Oh, I beg, I beg and plead, singing

                Come out of things unsaid
                Shoot an apple off my head
                And a trouble that can't be named
                A tiger's waiting to be tamed, singing

                You are, you are

                Confusion never stops
                Closing walls and ticking clocks
                Gonna come back and take you home
                I could not stop that you now know, singing

                Come out upon my seas
                Cursed missed opportunities
                Am I a part of the cure?
                Or am I part of the disease? Singing

                You are, you are
                You are, you are

                You are, you are

                And nothing else compares
                Oh, nothing else compares
                And nothing else compares

                You are, you are

                Home, home where I wanted to go
                Home, home where I wanted to go
                Home, home where I wanted to go (you are)
                Home, home where I wanted to go (you are)""");

        letras.add("""
                (Kido, Kido)
                (K-Kiddominant on the beat, better run it back)

                Fuckin' Robitussin
                I don't know why this shit got me lazy right now, yeah
                Can't do Percocets or molly
                I'm turnin' one, tryna live it up here right, right, right

                Baby, you can
                Ride it, oh, yeah
                Bring it over to my place
                And you be like
                Baby, who cares?
                But I know you care
                Bring it over to my place

                You don't know what you did, did to me
                Your body lightweight speaks to me
                I don't know what you did, did to me
                Your body lightweight speaks to me

                (Yeah)
                (Yeah)

                I can make it hurricane on it
                Hunnid bands, make it rain on it
                Tie it up, put a chain on it
                Make you tattoo my name on it, oh
                Make you cry like a baby, yeah
                Let's Go Pro and make a video, yeah
                Make you cry like a baby, yeah
                Let's Go Pro and make a video
                Oh, yeah, yeah, yeah

                Baby, you can
                Ride it, oh, yeah
                Bring it over to my place
                And you be like
                Baby, who cares?
                But I know you care
                Bring it over to my place

                You don't know what you did, did to me
                Your body lightweight speaks to me
                I don't know what you did, did to me
                Your body lightweight speaks to me

                Baby, you can
                Ride it, oh, yeah
                And you be like
                Baby, who cares?
                But I know you care""");

        letras.add("""
                Logo, logo, assim que puder, vou telefonar
                Por enquanto tá doendo
                E quando a saudade quiser me deixar cantar
                Vão saber que andei sofrendo

                E que agora, longe de mim
                Você possa, enfim
                Ter felicidade
                Nem que faça um tempo ruim
                Não se sinta assim
                Só pela metade

                Ontem demorei pra dormir, tava assim, sei lá
                Meio passional por dentro
                Se eu tivesse o dom de fugir pra qualquer lugar
                Ia feito um pé de vento

                Sem pensar no que aconteceu
                Nada, nada é meu
                Nem meu pensamento
                Por falar em nada que é meu
                Encontrei o anel
                Que você esqueceu

                Aí foi que o barraco desabou
                Nessa que meu barco se perdeu
                Nele tá gravado só você e eu
                Aí foi que o barraco desabou
                Nessa que meu barco se perdeu
                Nele tá gravado só você e eu

                Logo, logo, assim que puder, vou telefonar
                Por enquanto tá doendo
                E quando a saudade quiser me deixar cantar
                Vão saber que andei sofrendo

                E que agora, longe de mim
                Você possa, enfim
                Ter felicidade
                Nem que faça um tempo ruim
                Não se sinta assim
                Só pela metade

                Ontem demorei pra dormir, tava assim, sei lá
                Meio passional por dentro
                Se eu tivesse o dom de fugir pra qualquer lugar
                Ia feito um pé de vento

                Sem pensar no que aconteceu
                Nada, nada é meu
                Nem meu pensamento
                Por falar em nada que é meu
                Encontrei o anel
                Que você esqueceu

                Aí foi que o barraco desabou
                Nessa que meu barco se perdeu
                Nele tá gravado só você e eu
                Aí foi que o barraco desabou
                Nessa que meu barco se perdeu
                Nele tá gravado só você e eu

                Aí foi que o barraco desabou
                Nessa que meu barco se perdeu
                Nele tá gravado só você e eu
                Aí foi que o barraco desabou
                Nessa que meu barco se perdeu
                Nele tá gravado só você e eu

                Só você e eu
                Só você e eu""");

        letras.add("""
                O que mais quero é te dar um beijo
                E o seu corpo acariciar
                Você bem sabe que eu te desejo
                Está escrito no meu olhar
                O teu sorriso é um paraíso
                Onde contigo eu queria estar
                Ai, quem me dera se eu fosse o céu
                Você seria o meu luar

                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar
                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar

                Meu coração está radiante
                Bate feliz, acho que é amor
                Quando te vejo chego a sonhar
                Penso em você quase a todo instante
                Seu jeito meigo me apaixonou
                O que fazer pra te conquistar?

                O que mais quero é te dar um beijo
                E o seu corpo acariciar
                Você bem sabe que eu te desejo
                Está escrito no meu olhar
                O teu sorriso é um paraíso
                Onde contigo eu queria estar
                Ai, quem me dera se eu fosse o céu
                Você seria o meu luar

                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar
                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar

                Meu coração está radiante
                Bate feliz, acho que é amor
                Quando te vejo chego a sonhar
                Penso em você quase a todo instante
                Seu jeito meigo me apaixonou
                O que fazer pra te conquistar?

                O que mais quero é te dar um beijo
                E o seu corpo acariciar
                Você bem sabe que eu te desejo
                Está escrito no meu olhar
                O teu sorriso é um paraíso
                Onde, contigo, eu queria estar
                Ai, quem me dera se eu fosse o céu
                Você seria o meu luar

                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar
                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar

                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar

                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar

                Eu te quero só pra mim
                Como as ondas são do mar
                Não dá pra viver assim
                Querer sem poder te tocar""");
                
        letras.add("""
                Deixa acontecer naturalmente
                Eu não quero ver você chorar
                Deixa que o amor encontre a gente
                Nosso caso vai eternizar

                Deixa acontecer naturalmente
                Eu não quero ver você chorar
                Deixa que o amor encontre a gente
                Nosso caso vai eternizar

                Você já disse que me quer
                Pra toda vida, eternidade
                Quando está distante de mim
                Fica louca de saudade

                Que a razão do seu viver sou eu
                Está tudo bem, eu acredito
                Eu não tô duvidando disso

                Só que eu tenho muito medo de me apaixonar
                Esse filme já passou na minha vida
                E você tá me ajudando a superar
                Eu não quero ser um mal na sua vida

                Deixa acontecer naturalmente
                Eu não quero ver você chorar
                Deixa que o amor encontre a gente
                Nosso caso vai eternizar

                Deixa acontecer naturalmente
                (Deixa acontecer naturalmente)
                Eu não quero ver você chorar
                (Eu não quero ver você chorar)
                Deixa que o amor encontre a gente
                (Deixa que o amor encontre a gente)
                Nosso caso vai eternizar

                Você já disse que me quer
                Pra toda vida, eternidade
                Quando está distante de mim
                Fica louca de saudade

                Que a razão do seu viver sou eu
                Está tudo bem, eu acredito
                Eu não tô duvidando disso

                Só que eu tenho muito medo de me apaixonar
                Esse filme já passou na minha vida
                E você tá me ajudando a superar
                Eu não quero ser um mal na sua vida

                Deixa acontecer naturalmente
                (Deixa acontecer naturalmente)
                Eu não quero ver você chorar
                (Eu não quero ver você chorar)
                Deixa que o amor encontre a gente
                (Deixa que o amor encontre a gente)
                Nosso caso vai eternizar

                Deixa acontecer naturalmente
                (Deixa acontecer naturalmente)
                Eu não quero ver você chorar
                (Eu não quero ver você chorar)
                Deixa que o amor encontre a gente
                (Deixa que o amor encontre a gente)
                Nosso caso vai eternizar""");

        letras.add("""
                Olha só você
                Depois de me perder
                Veja só você
                Que pena

                Você não quis me ouvir
                Você não quis saber
                Desfez do meu amor
                Que pena, que pena

                Hoje é você quem está sofrendo, amor
                Hoje sou eu quem não te quer
                O meu coração já tem um novo amor
                Você pode fazer o que quiser

                Você jogou fora o amor que eu te dei
                O sonho que sonhei, isso não se faz
                Você jogou fora a minha ilusão, a louca paixão
                É tarde demais
                Que pena
                Que pena, amor
                Que pena
                Que pena, amor

                Hoje é você quem está sofrendo, amor
                Hoje sou eu quem não te quer
                O meu coração já tem um novo amor
                Você pode fazer o que quiser

                Você jogou fora o amor que eu te dei
                O sonho que sonhei, isso não se faz
                Você jogou fora a minha ilusão, a louca paixão
                É tarde demais
                Que pena
                Que pena, amor
                Que pena
                Que pena, amor
                Que pena
                Que pena, amor
                Que pena""");

        letras.add("sdsdsd");




        return letras;
    }
}
