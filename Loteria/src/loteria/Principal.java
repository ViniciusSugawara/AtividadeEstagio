package loteria;

import jogos.Federal;
import jogos.Jogo;
import jogos.MegaSena;

public class Principal {
    public static void main(String[] args) {
        Jogo primeiroJogo = new Federal();
        Jogo segundoJogo = new MegaSena();
        Participante p1 = new Participante("Jonas", 1);
        Participante p2 = new Participante("Viana", 1);

        Loteria loteria = new Loteria(segundoJogo, p1, p2);
        loteria.execucao();
    }
}
