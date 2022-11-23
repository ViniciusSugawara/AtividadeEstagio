package io;

import controllers.LoteriaController;
import dominio.Participante;
import jogos.*;
import sorteadores.*;

public class Principal {
    public static void main(String[] args) {
        SimpleJogoFactory jogoFactory = new SimpleJogoFactory();

        JogoAbs primeiroJogoAbs = jogoFactory.criaJogo("federal");
        JogoAbs segundoJogoAbs = jogoFactory.criaJogo("megasena");
        JogoAbs terceiroJogoAbs = jogoFactory.criaJogo("federal simplificada");
        JogoAbs quartoJogoAbs = jogoFactory.criaJogo("megasena simplificada");

        Participante p1 = new Participante("Jonas", 1);
        Participante p2 = new Participante("Viana", 3);

            ISorteador sorteio = new SorteadorTendencioso(quartoJogoAbs.getQuantidadeNumeros(), quartoJogoAbs.getValorMaximo());
        ISorteador sorteioDois = new SorteadorPadrao(quartoJogoAbs.getQuantidadeNumeros(), quartoJogoAbs.getValorMaximo());
//
        LoteriaController loteriaController = new LoteriaController(quartoJogoAbs,
                                        sorteioDois,
                                        p1, p2);

        LoteriaView loteriaView = new LoteriaView(loteriaController);

        loteriaView.demonstraExecucao();
        loteriaView.demonstraResultados();
    }
}
