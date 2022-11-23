package dominio;

import jogos.JogoAbs;

import java.util.ArrayList;
import java.util.List;

public class Loteria {
    //Classe de dominio da loteria
    private List<Participante> participantes = new ArrayList<>();
    private List<Bilhete> bilhetes;
    private JogoAbs jogoAbs;
    private int[] resultadoSorteado;

    public Loteria(){}

    public List<Participante> getParticipantes() { return participantes; }
    public void setParticipantes(List<Participante> participantes) { this.participantes = participantes; }
    public void adicionaParticipantes(Participante participante){ participantes.add(participante); }

    public List<Bilhete> getBilhetes() { return bilhetes; }
    public void setBilhetes(List<Bilhete> bilhetes) { this.bilhetes = bilhetes; }

    public JogoAbs getJogo() { return jogoAbs; }
    public void setJogo(JogoAbs jogoAbs) { this.jogoAbs = jogoAbs; }

    public int[] getResultadoSorteado() { return resultadoSorteado; }
    public void setResultadoSorteado(int[] resultadoSorteado) { this.resultadoSorteado = resultadoSorteado; }
}
