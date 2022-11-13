package jogos;

public abstract class Jogo {
    // Classe que representa os jogos fornecidos em uma loteria.
    private int quantiaNumeros;
    private int limite;
    private boolean escolheNumeros;

    public boolean isEscolheNumeros() {
        return escolheNumeros;
    }
    protected void setEscolheNumeros(boolean escolheNumeros) {
        this.escolheNumeros = escolheNumeros;
    }

    protected void setQuantiaNumeros(int quantiaNumeros){
        this.quantiaNumeros = quantiaNumeros;
    }
    public int getQuantiaNumeros(){
        return quantiaNumeros;
    }

    public int getLimite() {
        return limite;
    }

    protected void setLimite(int limite) {
        this.limite = limite;
    }
}
