package jogos;

public abstract class Jogo {
    private int quantidadeNumeros;
    private int valorMaximo;
    private boolean jogadorEscolheNumeros;

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
}
