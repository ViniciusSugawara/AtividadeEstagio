package controllers;
import dominio.Bilhete;
import dominio.Loteria;
import dominio.Participante;
import jogos.Jogo;
import dominio.Premio;
import utilidades.Verificador;
import sorteadores.Sorteador;

public class LoteriaController {
    private Loteria loteriaModelo = new Loteria();
    private Sorteador sorteador;
    private Verificador verificador;
    private final Premio premiacao;
    private BilheteController bilheteController;
    private ParticipanteController participanteController;
    public LoteriaController(Jogo jogo, Sorteador sorteador, Participante... participantes){
        loteriaModelo.setJogo(jogo);
        this.sorteador = sorteador;
        this.participanteController = new ParticipanteController();
        this.premiacao = new Premio();

        for(Participante participante : participantes){
            participante.setBilhetes(
                    participanteController.adicionaBilhetes(participante.getQuantidadeBilhetes()));
            this.loteriaModelo.adicionaParticipantes(participante);
            this.premiacao.calculaPremioTotal(6, participante.getQuantidadeBilhetes());
        }
    }

//    public List<Bilhete> getBilhetes() {
//        for (Participante participante : loteriaModelo.getParticipantes()) {
//            for (Bilhete bilhete : participante.getBilhetes()) {
//                bilhetes.add(bilhete);
//            }
//        }
//        return bilhetes;
//    }

    private void preencheBilheteManualmente(){
        for(Participante participante : loteriaModelo.getParticipantes()){
            System.out.println("Jogador " + participante.getNome() + ", ");
            bilheteController.preencheBilheteManualmente(
                    participante.getBilhetes(), loteriaModelo.getJogo().getQuantidadeNumeros());
        }
    }

    private void preencheBilheteAutomaticamente() {
        for (Participante participante : loteriaModelo.getParticipantes()) {
            bilheteController.preencheBilheteAutomaticamente(
                    participante.getBilhetes(), sorteador);
        }
    }

    private String mostraBilhetes(){
        String apostas = "";
        for(Participante participante : loteriaModelo.getParticipantes()){
            apostas += "Jogador " + participante.getNome() + " com os numeros ";
            for(Bilhete bilhete : participante.getBilhetes()) {
                apostas += bilhete.retornaNumeros() + ", ";
            }
        }
        return apostas;
    }

    private String mostraResultadoSorteado(){
        String resultado = "";
        for(int numero : loteriaModelo.getResultadoSorteado()){
            resultado += numero + ", ";
        }
        return resultado;
    }

    public String executaDemonstracaoResultados(){
        String mensagem = "";
        mensagem += "\nNumeros sorteados foram: " + sorteador.retornaNumerosSorteados();
        mensagem += "\nNumeros apostados foram: " + mostraBilhetes();

        return mensagem;
    }

    public String executaJogo(){
        String mensagem = "";
        this.bilheteController = new BilheteController();
        if(loteriaModelo.getJogo().isJogadorEscolheNumeros()){
            preencheBilheteManualmente();
        } else {
            preencheBilheteAutomaticamente();
        }
        sorteador.realizaSorteio();
        loteriaModelo.setResultadoSorteado(sorteador.getNumerosSorteados());

        this.verificador = new Verificador(loteriaModelo.getResultadoSorteado(), loteriaModelo.getParticipantes());

        if(verificador.verificaVencedor() != null) {
            mensagem += "O vencedor foi " + verificador.verificaVencedor().getNome();
            mensagem += "\nCom os numeros: " + mostraResultadoSorteado();
            mensagem += "\nCom a premiacao de " + premiacao.getPremioTotal();
            return mensagem;
        } else {
            return "Ninguem venceu";
        }
    }
}
