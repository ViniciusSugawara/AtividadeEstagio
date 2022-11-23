package loteria;

public class Premio {
    private long premioTotal;

    public Premio(){}

    public void calculaPremioTotal(int valorAposta, int quantidadeApostas){
        this.premioTotal += valorAposta * quantidadeApostas;
    }

    public long getPremioTotal() {
        return premioTotal;
    }
}
