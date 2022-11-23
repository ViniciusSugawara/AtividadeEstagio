package sorteadores;

public interface ISorteador {
    // Interface que cuida dos metodos que sorteadores irao implementar
    public void realizaSorteio();
    public int[] getNumerosSorteados();
    public String retornaNumerosSorteados();
}
