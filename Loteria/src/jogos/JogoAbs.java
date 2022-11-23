package jogos;

public abstract class JogoAbs {
    //Classe abstrata que representa jogos e seus comportamentos.
    private int quantidadeNumeros;
    private int valorMaximo;
    private boolean jogadorEscolheNumeros;
    private double valorJogo;

    public boolean isJogadorEscolheNumeros() {
        return jogadorEscolheNumeros;
    }
    protected void setJogadorEscolheNumeros(boolean jogadorEscolheNumeros) { this.jogadorEscolheNumeros = jogadorEscolheNumeros; }

    public int getQuantidadeNumeros(){
        return quantidadeNumeros;
    }
    protected void setQuantidadeNumeros(int quantidadeNumeros){
        this.quantidadeNumeros = quantidadeNumeros;
    }

    public int getValorMaximo() {
        return valorMaximo;
    }
    protected void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public double getValorJogo() {
        return valorJogo;
    }
    public void setValorJogo(double valorJogo) {
        this.valorJogo = valorJogo;
    }
}
