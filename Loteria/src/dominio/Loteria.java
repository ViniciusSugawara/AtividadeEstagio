package dominio;

import jogos.Jogo;

import java.util.ArrayList;
import java.util.List;

public class Loteria {
    private List<Participante> participantes;
    private List<Bilhete> bilhetes;
    private Jogo jogo;
    private int[] resultadoSorteado;
    private double premio = 0;


    public Loteria(){
        this.participantes = new ArrayList<>();

    }

    public List<Participante> getParticipantes() { return participantes; }
    public void setParticipantes(List<Participante> participantes) { this.participantes = participantes; }
    public void adicionaParticipantes(Participante participante){ participantes.add(participante); }

    public List<Bilhete> getBilhetes() { return bilhetes; }
    public void setBilhetes(List<Bilhete> bilhetes) { this.bilhetes = bilhetes; }

    public Jogo getJogo() { return jogo; }
    public void setJogo(Jogo jogo) { this.jogo = jogo; }

    public int[] getResultadoSorteado() { return resultadoSorteado; }
    public void setResultadoSorteado(int[] resultadoSorteado) { this.resultadoSorteado = resultadoSorteado; }

    public double getPremio() { return premio; }
    public void setPremio(double premio) { this.premio = premio; }
}
