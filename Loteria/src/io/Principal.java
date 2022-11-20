package io;

import dominio.Participante;
import jogos.*;
import sorteadores.*;
import sorteadores.SorteadorTendencioso;

public class Principal {
    public static void main(String[] args) {
        SimpleJogoFactory jogoFactory = new SimpleJogoFactory();

        Jogo primeiroJogo = jogoFactory.criaJogo("federal");
        Jogo segundoJogo = jogoFactory.criaJogo("megasena");
        Jogo terceiroJogo = jogoFactory.criaJogo("federal simplificada");
        Jogo quartoJogo = jogoFactory.criaJogo("megasena simplificada");

        Participante p1 = new Participante("Jonas", 1);
        Participante p2 = new Participante("Viana", 1);

        Sorteador sorteio = new SorteadorTendencioso(terceiroJogo.getQuantidadeNumeros(), terceiroJogo.getValorMaximo());
        Sorteador sorteioDois = new SorteadorPadrao(quartoJogo.getQuantidadeNumeros(), quartoJogo.getValorMaximo());

        Loteria loteria = new Loteria(quartoJogo,
                                        sorteioDois,
                                        p1, p2);
        loteria.execucao();
    }
}
