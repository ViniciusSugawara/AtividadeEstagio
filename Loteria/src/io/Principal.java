package io;

import loteria.Loteria;
import loteria.LoteriaView;
import dominio.Participante;
import jogos.*;
import sorteadores.*;

public class Principal {
    public static void main(String[] args) {
        SimpleJogoFactory jogoFactory = new SimpleJogoFactory();

        Jogo primeiroJogo = jogoFactory.criaJogo("federal");
        Jogo segundoJogo = jogoFactory.criaJogo("megasena");
        Jogo terceiroJogo = jogoFactory.criaJogo("federal simplificada");
        Jogo quartoJogo = jogoFactory.criaJogo("megasena simplificada");

        Participante p1 = new Participante("Jonas", 1);
        Participante p2 = new Participante("Viana", 3);

//        Sorteador sorteio = new SorteadorTendencioso(terceiroJogo.getQuantidadeNumeros(), terceiroJogo.getValorMaximo());
        Sorteador sorteioDois = new SorteadorPadrao(quartoJogo.getQuantidadeNumeros(), quartoJogo.getValorMaximo());
//
        Loteria loteria = new Loteria(quartoJogo,
                                        sorteioDois,
                                        p1, p2);

        LoteriaView loteriaView = new LoteriaView(loteria);

        loteriaView.demonstraExecucao();
        loteriaView.demonstraResultados();
    }
}
