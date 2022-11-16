package dominio;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nome;
    private List<Bilhete> bilhetes;
    private int quantidadeBilhetes;
    
    public Participante(String nome, int quantidadeBilhetes){
        this.nome = nome;
        bilhetes = new ArrayList<>();
        addBilhetes();
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

    private void addBilhetes(){
        for(int i = 0; i < quantidadeBilhetes; i++){
            bilhetes.add(new Bilhete());
        }
    }

}
