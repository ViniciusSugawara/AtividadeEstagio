package loteria;
import controllers.BilheteController;
import dominio.Bilhete;
import dominio.Participante;
import jogos.Jogo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loteria {
    // Classe que realiza a interação entre as classes, como um Mediator.
    private List<Participante> participantes;
    private List<Bilhete> bilhetes;
    private Map<Participante, List<Bilhete>> mapaBilhetes;
    private Jogo jogo;
    private Sorteio sorteio;
    private int[] resultado;
    private double premio = 0;
    private Verificador verificador;
    private BilheteController bilheteController;
    public Loteria(Jogo jogo, Participante... participantes){
        this.jogo = jogo;
        this.sorteio = new Sorteio(jogo.getQuantidadeNumeros(), jogo.getNumeroMaximo());
        this.bilheteController = new BilheteController();
        this.participantes = new ArrayList();
        this.bilhetes = new ArrayList();
        this.mapaBilhetes = new HashMap<>();

        for(Participante participante : participantes){
            preencheMapa(participante);
            this.participantes.add(participante);
            calculaPremio();
        }

    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
    public void adicionaParticipante(Participante participante){
        this.participantes.add(participante);
    }

    public List<Bilhete> getBilhetes(){
        for(Participante participante : participantes){
            for(Bilhete bilhete : participante.getBilhetes()){
                bilhetes.add(bilhete);
            }
        }
        return bilhetes;
    }

    private void calculaPremio(){
        for(int i = 0; i < bilhetes.size(); i++)
            this.premio += 6;
    }

    private void preencheMapa(Participante participante){
        this.mapaBilhetes.put(participante, participante.getBilhetes());
    }

    private void preencheBilheteManualmente(){
        for(Bilhete bilhete : bilhetes){
            bilhete = bilheteController.preencheBilhete(bilhete, jogo.getQuantidadeNumeros());
        }
    }

    private void preencheBilheteAutomaticamente() {
        for (Participante participante : participantes) {
            for (Bilhete bilhete : participante.getBilhetes()) {
                sorteio.realizaSorteio();
                bilhete.setNumeros(sorteio.getNumerosSorteados());
            }
        }
    }

    private String mostraBilhetes(){
        String numerosApostados = "";
        for(Bilhete bilhete : bilhetes){
            numerosApostados += bilhete.retornaNumeros();
        }
        return numerosApostados;
    }

    public void execucaoTeste(){
        sorteio.realizaSorteio();
        System.out.println(sorteio.retornaNumerosSorteados());
        System.out.println(mostraBilhetes());
    }

    public void execucao(){
        if(jogo.isEscolheNumeros()){
            preencheBilheteManualmente();
        } else {
            System.out.println("Entrou no metodo certo");
            preencheBilheteAutomaticamente();
        }
        sorteio.realizaSorteio();
        resultado = sorteio.getNumerosSorteados();

        this.verificador = new Verificador(resultado, this.participantes);

        if(verificador.verificaVencedor() != null) {
            System.out.println("O vencedor foi " + verificador.verificaVencedor().getNome());
            System.out.println("Com os numeros: " + resultado);
            System.out.println("Com a premiacao de " + premio);
        } else {
            System.out.println("Ninguem venceu");
        }
        System.out.println("Os numeros foram " + mostraBilhetes());
    }
}
