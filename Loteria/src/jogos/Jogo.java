package jogos;

public abstract class Jogo {
    // Classe que representa os jogos fornecidos em uma loteria.
    private int quantidadeNumeros;
    private int numeroMaximo;
    private boolean escolheNumeros;

    public boolean isEscolheNumeros() {
        return escolheNumeros;
    }
    protected void setEscolheNumeros(boolean escolheNumeros) {
        this.escolheNumeros = escolheNumeros;
    }

    protected void setQuantidadeNumeros(int quantidadeNumeros){
        this.quantidadeNumeros = quantidadeNumeros;
    }
    public int getQuantidadeNumeros(){
        return quantidadeNumeros;
    }

    public int getNumeroMaximo() {
        return numeroMaximo;
    }

    protected void setNumeroMaximo(int numeroMaximo) {
        this.numeroMaximo = numeroMaximo;
    }
}
