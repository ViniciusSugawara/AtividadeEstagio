package jogos;

public class SimpleJogoFactory {
    public Jogo criaJogo(String nomeJogo){
        Jogo jogo = null;
        if(nomeJogo.toLowerCase().equals("federal")){
            jogo = new Federal();
        } else if (nomeJogo.toLowerCase().equals("megasena")){
            jogo = new MegaSena();
        } else if (nomeJogo.toLowerCase().equals("federal simplificada")){
            jogo = new FederalSimplificada();
        }
        return jogo;
    }
}
