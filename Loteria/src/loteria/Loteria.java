package loteria;
import jogos.Jogo;

import java.util.ArrayList;
import java.util.List;
public class Loteria {
    // Classe que realiza a interação entre as classes, como um Mediator.
    private List<Participante> participantes;
    private Participante vencedor = null;
    private Bilhete bilheteVencedor = null;
    private Jogo jogo;
    private Sorteio sorteio;
    int[] resultado;
    double premio = 0;
    public Loteria(Jogo jogo, Participante... participantes){
        this.jogo = jogo;
        this.resultado = new int[jogo.getQuantiaNumeros()];
        this.sorteio = new Sorteio(jogo.getQuantiaNumeros(), jogo.getLimite());
        this.participantes = new ArrayList();

        for(Participante participante : participantes){
            this.participantes.add(participante);
            this.premio += 6;
        }
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
    public void adicionaParticipante(Participante participante){
        this.participantes.add(participante);
    }

    private void preencheBilhete(){
        int[] numerosParaPreencher = new int[jogo.getQuantiaNumeros()];
        for(Participante participante : participantes){
            for(Bilhete bilhete : participante.getBilhetes()){
                System.out.println("Jogador " + participante.getNome() + ", Insira os numeros para aposta: ");
                for(int i = 0; i < numerosParaPreencher.length; i++){
                    System.out.println(i + 1 + "o numero");
                    numerosParaPreencher[i] = EntradaDados.retornaNumero();
                }
                bilhete.setNumeros(numerosParaPreencher);
            }
        }
    }

    private boolean verificaVencedor(){
        for(Participante participante : participantes){
            for(Bilhete bilhete : participante.getBilhetes()){
                if(resultado.equals(bilhete.getNumeros())){
                    vencedor = participante;
                    bilheteVencedor = bilhete;
                    return true;
                }
            }
        }
        return false;
    }

    public void execucao(){
        if(jogo.isEscolheNumeros()){
            preencheBilhete();
        }
        resultado = sorteio.realizaSorteio();
        if(verificaVencedor()) {
            System.out.println("O vencedor foi " + vencedor.getNome());
            System.out.println("Com os numeros: " + bilheteVencedor.retornaNumeros());
            System.out.println("Com a premiacao de " + premio);
        } else {
            System.out.println("Ninguem venceu");
        }
    }
}
