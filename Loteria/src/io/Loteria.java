package io;
import controllers.BilheteController;
import controllers.ParticipanteController;
import dominio.Bilhete;
import dominio.Participante;
import jogos.Jogo;
import utilidades.Verificador;
import sorteadores.Sorteador;

import java.util.ArrayList;
import java.util.List;

public class Loteria {
    private List<Participante> participantes;
    private List<Bilhete> bilhetes;
    private Jogo jogo;
    private Sorteador sorteador;
    private int[] resultadoSorteado;
    private double premio = 0;
    private Verificador verificador;
    private BilheteController bilheteController;
    private ParticipanteController participanteController;
    public Loteria(Jogo jogo, Sorteador sorteador, Participante... participantes){
        this.jogo = jogo;
        this.sorteador = sorteador;
        this.participantes = new ArrayList();
        this.participanteController = new ParticipanteController();

        for(Participante participante : participantes){
            participante.setBilhetes(
                    participanteController.adicionaBilhetes(participante.getQuantidadeBilhetes()));
            this.participantes.add(participante);
            this.premio += 6 * participante.getQuantidadeBilhetes();
        }
    }

    public List<Bilhete> getBilhetes() {
        for (Participante participante : participantes) {
            for (Bilhete bilhete : participante.getBilhetes()) {
                bilhetes.add(bilhete);
            }
        }
        return bilhetes;
    }

    private void preencheBilheteManualmente(){
        for(Participante participante : participantes){
            System.out.println("Jogador " + participante.getNome() + ", ");
            bilheteController.preencheBilheteManualmente(
                    participante.getBilhetes(), jogo.getQuantidadeNumeros());
        }
    }

    private void preencheBilheteAutomaticamente() {
        for (Participante participante : participantes) {
            bilheteController.preencheBilheteAutomaticamente(
                    participante.getBilhetes(), sorteador);
        }
    }

    private String mostraBilhetes(){
        String apostas = "";
        for(Participante participante : participantes){
            apostas += "Jogador " + participante.getNome() + " com os numeros ";
            for(Bilhete bilhete : participante.getBilhetes()) {
                apostas += bilhete.retornaNumeros() + ", ";
            }
        }
        return apostas;
    }

    private String mostraResultadoSorteado(){
        String resultado = "";
        for(int numero : this.resultadoSorteado){
            resultado += numero + ", ";
        }
        return resultado;
    }

    public void execucaoTeste(){
        sorteador.realizaSorteio();
        System.out.println(sorteador.retornaNumerosSorteados());
        System.out.println(mostraBilhetes());
    }

    public void execucao(){
        this.bilheteController = new BilheteController();
        if(jogo.isJogadorEscolheNumeros()){
            preencheBilheteManualmente();
        } else {
            preencheBilheteAutomaticamente();
        }
        sorteador.realizaSorteio();
        resultadoSorteado = sorteador.getNumerosSorteados();

        this.verificador = new Verificador(resultadoSorteado, this.participantes);

        if(verificador.verificaVencedor() != null) {
            System.out.println("O vencedor foi " + verificador.verificaVencedor().getNome());
            System.out.println("Com os numeros: " + mostraResultadoSorteado());
            System.out.println("Com a premiacao de " + premio);
        } else {
            System.out.println("Ninguem venceu");
        }
        System.out.println("Os numeros apostados foram " + mostraBilhetes());
        System.out.println("Os numeros sorteados foram " + sorteador.retornaNumerosSorteados());
    }
}
