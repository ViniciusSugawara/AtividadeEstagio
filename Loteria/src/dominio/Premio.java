package dominio;

public class Premio {
    //Classe responsavel pelo calculo do premio
    private long premioTotal;

    public Premio(){}

    public void calculaPremioTotal(double valorAposta, int quantidadeApostas){
        this.premioTotal += valorAposta * quantidadeApostas;
    }

    public long getPremioTotal() {
        return premioTotal;
    }
}
