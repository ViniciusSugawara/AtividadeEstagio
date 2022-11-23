package dominio;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    //Classe de dominio do participante
    private String nome;
    private List<Bilhete> bilhetes;
    private int quantidadeBilhetes;
    
    public Participante(String nome, int quantidadeBilhetes){
        this.nome = nome;
        this.quantidadeBilhetes = quantidadeBilhetes;
        this.bilhetes = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Bilhete> getBilhetes() {
        return bilhetes;
    }
    public void setBilhetes(List<Bilhete> bilhete) { this.bilhetes = bilhete; }
    public void adicionaBilhetes(Bilhete bilhete){
        this.bilhetes.add(bilhete);
    }


    public int getQuantidadeBilhetes() { return quantidadeBilhetes; }
    public void setQuantidadeBilhetes(int quantidadeBilhetes) { this.quantidadeBilhetes = quantidadeBilhetes; }
}
