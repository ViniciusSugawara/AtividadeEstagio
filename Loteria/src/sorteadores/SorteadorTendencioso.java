package sorteadores;

public class SorteadorTendencioso implements ISorteador {
    private int[] numerosSorteados;
    private int valorMaximo;

    public SorteadorTendencioso(int quantiaNumerosSorteados, int valorMaximo){
        this.numerosSorteados = new int[quantiaNumerosSorteados];
        this.valorMaximo = valorMaximo;
    }

    private boolean verificaRepeticao(int numero){
        for(int i = 0; i < numerosSorteados.length; i++){
            if(numerosSorteados[i] == numero){
                return true;
            }
        }
        return false;
    }
    @Override
    public void realizaSorteio() {
        int numero = 0;
        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosSorteados[i] = ++numero;
        }
    }

    @Override
    public int[] getNumerosSorteados() {
        return numerosSorteados;
    }

    @Override
    public String retornaNumerosSorteados() {
        String resultado = "";
        for(int numero : numerosSorteados){
            resultado += numero + ", ";
        }
        return resultado.substring(0, resultado.length()-2);
    }
}
