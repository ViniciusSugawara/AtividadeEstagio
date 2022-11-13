package loteria;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nome;
    private List<Bilhete> bilhetes;
    private int numeroBilhetes;
    
    public Participante(String nome, int numeroBilhetes){
        this.nome = nome;
        bilhetes = new ArrayList<>();
        for(int i = 0; i < numeroBilhetes; i++){
            bilhetes.add(new Bilhete());
        }
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
    public void setBilhetes(List<Bilhete> bilhete) {
        this.bilhetes = bilhete;
    }
}
