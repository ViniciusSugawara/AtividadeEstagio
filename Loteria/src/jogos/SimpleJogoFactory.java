package jogos;

public class SimpleJogoFactory {
    public JogoAbs criaJogo(String nomeJogo){
        JogoAbs jogoAbs = null;
        if(nomeJogo.toLowerCase().equals("federal")){
            jogoAbs = new Federal();
        } else if (nomeJogo.toLowerCase().equals("megasena")){
            jogoAbs = new MegaSena();
        } else if (nomeJogo.toLowerCase().equals("federal simplificada")){
            jogoAbs = new FederalSimplificada();
        } else if (nomeJogo.toLowerCase().equals("megasena simplificada")){
            jogoAbs = new MegaSenaSimplificada();
        }
        return jogoAbs;
    }
}
