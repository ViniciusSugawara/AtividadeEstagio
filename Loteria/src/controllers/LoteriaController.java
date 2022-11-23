package controllers;
import dominio.Bilhete;
import dominio.Loteria;
import dominio.Participante;
import jogos.JogoAbs;
import dominio.Premio;
import sorteadores.ISorteador;
import utilidades.Verificador;

public class LoteriaController {
    private Loteria loteriaModelo = new Loteria();
    private ISorteador iSorteador;
    private Verificador verificador;
    private final Premio premiacao;
    private BilheteController bilheteController;
    private ParticipanteController participanteController;

    public LoteriaController(JogoAbs jogoAbs, ISorteador iSorteador, Participante... participantes){
        loteriaModelo.setJogo(jogoAbs);
        this.iSorteador = iSorteador;
        this.participanteController = new ParticipanteController();
        this.bilheteController = new BilheteController();
        this.premiacao = new Premio();

        for(Participante participante : participantes){
            this.loteriaModelo.adicionaParticipantes(participante);
//            participante.setBilhetes(
//                    participanteController.adicionaBilhetes(
//                            participante.getQuantidadeBilhetes()
//                    )
//            );
            if(jogoAbs.isJogadorEscolheNumeros()){
                preencheManual(participante);
            } else {
                preencheAutomatico(participante);
            }

            this.premiacao.calculaPremioTotal(jogoAbs.getValorJogo(), participante.getQuantidadeBilhetes());
        }
    }

    private void preencheManual(Participante participante){
        for(int i = 0; i < participante.getQuantidadeBilhetes(); i++) {
            System.out.println("Participante " + participante.getNome() + ", insira " + (i + 1) + " bilhete");
            participante.adicionaBilhetes(
                    bilheteController.preencheBilheteManualmente(
                            loteriaModelo.getJogo().getQuantidadeNumeros()
                    )
            );
        }
    }

    private void preencheAutomatico(Participante participante){
        for(int i = 0; i < participante.getQuantidadeBilhetes(); i++) {
            participante.adicionaBilhetes(
                    bilheteController.preencheBilheteAutomaticamente(
                            this.iSorteador
                    )
            );
        }
    }


    private String mostraBilhetes(){
        String apostas = "";

        for(Participante participante : loteriaModelo.getParticipantes()){
            apostas += "Jogador " + participante.getNome() + " com os numeros ";
            int i = 0;

            for(Bilhete bilhete : participante.getBilhetes()) {
                apostas += ++i + "o bilhete foi " + bilhete.retornaNumeros() + ", ";
            }
        }
        return apostas.substring(0, apostas.length()-2);
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
        mensagem += "\nNumeros sorteados foram: " + iSorteador.retornaNumerosSorteados();
        mensagem += "\nNumeros apostados foram: " + mostraBilhetes();

        return mensagem;
    }

    public String executaJogo(){
        String mensagem = "";

        iSorteador.realizaSorteio();
        loteriaModelo.setResultadoSorteado(iSorteador.getNumerosSorteados());

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
