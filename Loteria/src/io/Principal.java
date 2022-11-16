package io;

import dominio.Participante;
import jogos.*;
import loteria.Loteria;

public class Principal {
    public static void main(String[] args) {
        SimpleJogoFactory jogoFactory = new SimpleJogoFactory();

        Jogo primeiroJogo = jogoFactory.criaJogo("federal");
        Jogo segundoJogo = jogoFactory.criaJogo("megasena");
        Jogo terceiroJogo = jogoFactory.criaJogo("federal simplificada");

        Participante p1 = new Participante("Jonas", 1);
        Participante p2 = new Participante("Viana", 1);

        Loteria loteria = new Loteria(terceiroJogo, p1, p2);
        loteria.execucao();
    }
}
